import org.gradle.api.internal.artifacts.configurations.Configurations

plugins {
    kotlin("jvm")
}

// This is unnecessary but I don't care
val shadowMe: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

dependencies {
    shadowMe("dev.kord:kord-core:0.8.x-SNAPSHOT")
    shadowMe("com.kotlindiscord.kord.extensions:kord-extensions:1.5.3-SNAPSHOT")
}