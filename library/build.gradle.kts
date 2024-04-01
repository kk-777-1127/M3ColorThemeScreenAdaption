plugins {
    kotlin("jvm")
    `maven-publish`
}

version = project.version.toString()

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = project.group.toString()
                artifactId = project.properties["artifactId"].toString()
                version = project.version.toString()

                from(components["java"])
            }
        }
    }
}