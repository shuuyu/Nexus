plugins {
    `nexus-modules`
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.ktor.bundle)
    implementation(libs.bundles.kotlinLibs.bundle)
    implementation(libs.bundles.test.bundle)
    implementation("dev.kord:kord-core:0.8.x-SNAPSHOT")
}