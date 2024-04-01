plugins {
    kotlin("jvm")
    `maven-publish`
}

dependencies {
    implementation(project(":submodule-utility"))
    implementation(libs.ktor.core)
    implementation(libs.ktor.engine.cio)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = project.group.toString()
                artifactId = project.properties["artifactId.common"].toString()
                version = project.version.toString()

                from(components["java"])
            }
        }
    }
}