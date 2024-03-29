# Nexus
A very bare metal library providing support for all types of functions.

This dependency introduces two features that would otherwise not be implemented, which are multi-bot support, and also modules
that are essential for enhancing the user experience. There is no inbetween when it comes to this.

**Note**: This isn't finished! Please do not use this for production.

## Usage
The point of Nexus was to be as powerful as possible, while not sacrificing materials that you don't need. For that reason,
we completely split the core from the command structure. While this may seem annoying at first, you'll understand the purpose
of the given approach.

## Implementation

As of currently, we only have Kotlin examples. I know, it is pretty underwhelming. 

### Kotlin

**build.gradle.kts**

```kotlin
plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "1.7.10"
}

repositories {
    mavenCentral()
    // Required for Kord
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.shuuyu.live/repositories/snapshots")
}

dependencies {
    // This will automatically bump you to that latest COMMIT, not stable version.
    // Be sure to check if the latest release has some breaking features that may possibly 
    // break your bot!
    implementation("live.shuuyu.nexus:core:0.0.1-SNAPSHOT")
}
```

**settings.gradle.kts**

```kotlin
pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        // Required for Kord
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.shuuyu.live/repositories/snapshots")
    }
}

rootProject.name = "XOXO"
```

We recommend that you use Shadow to relocate this dependency because it might conflict with other libraries.
