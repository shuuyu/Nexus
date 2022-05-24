# Nexus
Modules required for Nabi to function correctly.

This dependency introduces two features that would otherwise not be implemented, which are multi-bot support, and also modules
that are essential for enhancing the user experience. There is no inbetween when it comes to this.

There will come a day where we need to cut off Kord-Extension, and just use vanilla Kord. We'll let you know when this occurs.

Note: This isn't finished! Please do not use this for production.

## Implementation

As of currently, we only support Kotlin script implementation. I know, it is pretty underwhelming. 

### Kotlin

**build.gradle.kts**

```kotlin
plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.github.johnrengelman.shadow")
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
    // Kord-Ex automatically bundles Kord, no need to implement it again.
    shadowMe("com.kotlindiscord.kord.extensions:kord-extensions:1.5.3-SNAPSHOT")
    // This will automatically bump you to that latest COMMIT, not stable version.
    // Be sure to check if the latest release has some breaking features that may possibly 
    // break your bot!
    shadowMe("com.github.myosyn:Nexus:main-SNAPSHOT")
    
    // You can add other dependencies as well, as long as they do not conflict
}
```
**root.gradle.kts**
```kotlin
plugins {
    kotlin("jvm") version "1.6.21" apply false
    kotlin("plugin.serialization") version "1.6.21" apply false
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
}

preprocessor {
    // Because preprocessor is meant to make it so you can 
}

```


**settings.gradle.kts**

```kotlin
pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == dev.shuuyu.preprocessor) {
                useModule("com.github.myosyn:nexus:preprocessor:${requested.version}")
            }
        }
    }
}

rootProject.name = "XOXO"
// I'm addicted to Replaymod's preprocessor lol
rootProject.buildFileName = "root.gradle.kts"

// This isn't needed if you have multiple directories. If you want to set up multiple bots, you can make it so 
// each of the bots have its separate directory, but inherits all of the main attributes of the main bot.
val directoryStuff = listOf (
    "main-bot"        
)

directoryStuff.forEach { bot ->
    // Do whatever you want here
}
```

We recommend that you use Shadow to relocate this dependency because it might conflict with other mods.
