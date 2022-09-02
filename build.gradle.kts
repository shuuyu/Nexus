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
    `nexus-modules`
    id("org.jetbrains.dokka") version "1.7.10"
    base
    publishing
    signing
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.7.10")
}

tasks {
    dokkaHtml.configure {
        outputDirectory.set(buildDir.resolve("dokka"))
        moduleName.set("Nexus")
        moduleVersion.set("1.0.0")
        dokkaSourceSets {
            configureEach {
                jdkVersion.set(17)
            }
        }
    }
}

rootProject.apply {
    from(rootProject.file("gradle/root.gradle.kts"))
    from(rootProject.file("gradle/versioning.gradle.kts"))
    from(rootProject.file("gradle/module-versioning.gradle.kts"))
}