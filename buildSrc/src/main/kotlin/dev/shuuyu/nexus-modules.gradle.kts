import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import gradle.kotlin.dsl.accessors._e955592cfcca1783c48ac959ec339844.implementation
import org.gradle.kotlin.dsl.application
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
    id("com.github.johnrengelman.shadow")
}

group = "dev.myosyn.nabi"
version = "1.0.0-PRE1" + "-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
    maven("https://maven.kotlindiscord.com/repository/maven-snapshots/")
}

// This is unnecessary but I don't care
val shade: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

tasks {
    "shadowJar"(ShadowJar::class) {
        configurations = listOf(shade)
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "17"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.contracts.ExperimentalContracts"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.InternalSerializationApi"
        }
    }
    "compileJava"(JavaCompile::class) {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
}