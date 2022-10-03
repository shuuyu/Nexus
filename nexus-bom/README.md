# nexus-bom
Nexus' bill of materials.

## Implementation

Kotlin Script
```kotlin
plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "1.7.10"
}

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.shuuyu.live/repositories/snapshots")
}

dependencies {
    implementation("live.shuuyu.nexus:nexus-bom:0.0.1-SNAPSHOT")
    implementation("live.shuuyu.nexus:core")
}
```