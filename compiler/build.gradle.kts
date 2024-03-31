plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation(libs.ksp)
    implementation(libs.kotlin.poet)
    implementation(libs.kotlin.poet.ksp)
}
