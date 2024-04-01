plugins {
    kotlin("jvm")
    `maven-publish`
}

version = project.version.toString()

dependencies {
    implementation(project(":common"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation(libs.ksp)
    implementation(libs.kotlin.poet)
    implementation(libs.kotlin.poet.ksp)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = project.group.toString()
                artifactId = project.properties["artifactId.compiler"].toString()
                version = project.version.toString()

                from(components["java"])
            }
        }
    }
}