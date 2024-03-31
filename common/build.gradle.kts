plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":submodule-utility"))
    implementation(libs.ktor.core)
    implementation(libs.ktor.engine.cio)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
}