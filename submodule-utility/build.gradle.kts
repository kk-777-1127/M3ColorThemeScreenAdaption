plugins {
    kotlin("jvm")
    `maven-publish`
}

version = project.version.toString()

sourceSets {
    getByName("main") {
        java.srcDirs("submodule/java")
    }
}

dependencies {
    compileOnly(libs.error.phone)
    compileOnly("androidx.annotation:annotation:1.7.1")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = project.group.toString()
                artifactId = project.properties["artifactId.submodule"].toString()
                version = project.version.toString()

                from(components["java"])
            }
        }
    }
}