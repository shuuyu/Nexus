# Nexus
Modules required for Nabi to function correctly. 

## Implementation

### Kotlin
build.gradle.kts
```kotlin
plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
}

val shadowMe: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

dependencies {
    shadowMe("com.kotlindiscord.kord.extensions:kord-extensions:1.5.3-SNAPSHOT")
    shadowMe("com.github.myosyn:Nexus:-SNAPSHOT")
}
```