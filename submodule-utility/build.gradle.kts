plugins {
    kotlin("jvm")
}

sourceSets {
    getByName("main") {
        java.srcDirs("submodule/java")
    }
}

dependencies {
    compileOnly(libs.error.phone)
    compileOnly("androidx.annotation:annotation:1.7.1")
}