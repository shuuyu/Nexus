plugins {
    `nexus-modules`
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}