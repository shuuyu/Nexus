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

@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.jetbrains.dokka") {
                useModule("org.jetbrains.dokka:dokka-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "Nexus"

include(":modules:time-module")
include(":modules:user-module")
include(":core")
include(":nexus-bom")
include(":nexus-commands")
include(":annotations")
include(":annotation-processor")

// Test directory
include(":test")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            ktor()
            kotlinLibs()
            tests()
        }
    }
}

/**
 * Implements all Ktor implementation within a single implementation.
 *
 * @author yujin
 */
// Apparently bom doesn't exist on ktor anymore?
fun VersionCatalogBuilder.ktor() {
    val ktorVersion = version("ktor", "2.1.0")

    library("ktor-client-json", "io.ktor", "ktor-client-json").versionRef(ktorVersion)
    library("ktor-client-websockets", "io.ktor", "ktor-client-websockets").versionRef(ktorVersion)
    library("ktor-server-core-jvm", "io.ktor", "ktor-server-core-jvm").versionRef(ktorVersion)
    library("ktor-client-core-jvm", "io.ktor", "ktor-client-core-jvm").versionRef(ktorVersion)
    library("ktor-client-cio-jvm", "io.ktor", "ktor-client-cio-jvm").versionRef(ktorVersion)
    library("ktor-client-content-negotiation-jvm", "io.ktor", "ktor-client-content-negotiation-jvm").versionRef(ktorVersion)

    bundle("ktor-bundle", listOf(
        "ktor-client-json",
        "ktor-client-websockets",
        "ktor-server-core-jvm",
        "ktor-client-core-jvm",
        "ktor-client-cio-jvm",
        "ktor-client-content-negotiation-jvm",
    ))
}

/**
 * Implements all Kotlin specific libs in one implementation.
 *
 * @author yujin
 */
fun VersionCatalogBuilder.kotlinLibs() {
    val kotlinVersion = version("kotlin", "1.7.10")
    val coroutineVersion = version("coroutuine", "1.6.4")
    val serializationVersion = version("serialization", "1.4.0")
    val atomicfuVersion = version("atomicfu", "0.18.3")

    library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef(kotlinVersion)
    library("kotlin-stdlib-jdk7", "org.jetbrains.kotlin", "kotlin-stdlib-jdk7").versionRef(kotlinVersion)
    library("kotlin-stdlib-jdk8", "org.jetbrains.kotlin", "kotlin-stdlib-jdk8").versionRef(kotlinVersion)
    library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef(kotlinVersion)
    library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef(coroutineVersion)
    library("kotlinx-coroutines-core-jvm", "org.jetbrains.kotlinx", "kotlinx-coroutines-core-jvm").versionRef(coroutineVersion)
    library("kotlinx-coroutines-jdk8", "org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8").versionRef(coroutineVersion)
    library("kotlinx-serialization", "org.jetbrains.kotlinx", "kotlinx-serialization-json").versionRef(serializationVersion)
    library("atomicfu", "org.jetbrains.kotlinx", "atomicfu").versionRef(atomicfuVersion)

    bundle("kotlinLibs-bundle", listOf(
        "kotlin-stdlib",
        "kotlin-stdlib-jdk7",
        "kotlin-stdlib-jdk8",
        "kotlin-reflect",
        "kotlinx-coroutines-core",
        "kotlinx-coroutines-core-jvm",
        "kotlinx-coroutines-jdk8",
        "atomicfu",
    ))
}

fun VersionCatalogBuilder.tests() {
    val junitVersion = version("junit", "5.9.0")

    library("mockk", "io.mockk", "mockk").version("1.13.2")
    library("kotlinx-coroutines-test", "org.jetbrains.kotlinx", "kotlinx-coroutines-test").version("1.6.4")
    library("junit-jupiter-api", "org.junit.jupiter", "junit-jupiter-api").versionRef(junitVersion)

    library("slf4j-simple", "org.slf4j", "slf4j-simple").version("2.0.3")
    library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef(junitVersion)

    bundle("test-bundle", listOf(
        "mockk",
        "kotlinx-coroutines-test",
        "junit-jupiter-api",
        "slf4j-simple",
        "junit-jupiter-engine",
    ))
}