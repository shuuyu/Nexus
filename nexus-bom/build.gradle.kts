plugins {
    `maven-publish`
    `java-platform`
}

dependencies {
    constraints {
        rootProject.subprojects.forEach {
            if (!it.plugins.hasPlugin("maven-publish") || it.name == name) return@forEach
            it.the<PublishingExtension>().publications.forEach { publication ->
                if (publication !is MavenPublication) return@forEach

                val artifactId = publication.artifactId
                if (artifactId.endsWith("-metadata") || artifactId.endsWith("-kotlinMultiplatform")) {
                    return@forEach
                }

                api("${publication.groupId}:${publication.artifactId}:${publication.version}")
            }
        }
    }
}

the<PublishingExtension>().publications {
    create<MavenPublication>("maven") {
        from(components.findByName("javaPlatform"))
    }
}

// I could've thought of a smarter way to do this but eh
publishing {
    val mavenUser = System.getenv("MAVEN_USER")
    val mavenPassword = System.getenv("MAVEN_PASSWORD")
    val releaseType = System.getenv("RELEASE_TYPE")

    repositories {
        if (mavenUser != null && mavenPassword != null) {
            when (releaseType) {
                "release" -> maven("https://maven.shuuyu.live/releases") {
                    credentials {
                        username = mavenUser.toString()
                        password = mavenPassword.toString()
                    }
                }

                "snapshot" -> maven("https://maven.shuuyu.live/snapshots") {
                    credentials {
                        username = mavenUser.toString()
                        password = mavenPassword.toString()
                    }
                }

                "private" -> maven("https://maven.shuuyu.live/private") {
                    credentials {
                        username = mavenUser.toString()
                        password = mavenPassword.toString()
                    }
                }

                else -> throw GradleException("No release type provided in .env! Please provide one, then try again.")
            }
        }
    }
}

