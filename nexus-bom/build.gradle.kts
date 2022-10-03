/*
 * This file is part of Nexus, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022 Myosyn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
            val repository = when (releaseType) {
                "release" -> maven("https://maven.shuuyu.live/releases")
                "snapshot" -> maven("https://maven.shuuyu.live/snapshots")
                "private" -> maven("https://maven.shuuyu.live/private")
                else -> throw GradleException("No release type provided in .env! Please provide one, then try again.")
            }

            repository.credentials {
                username = mavenUser.toString()
                password = mavenPassword.toString()
            }
        }
    }
}

