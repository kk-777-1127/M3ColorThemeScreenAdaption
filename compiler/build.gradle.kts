plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
    implementation(kotlin("stdlib"))
    implementation(libs.ksp)
    implementation(libs.kotlin.poet)
}
