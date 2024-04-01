import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm")
    `maven-publish`
//    id("cl.franciscosolis.sonatype-central-upload") version "1.0.3"

    id("com.vanniktech.maven.publish") version "0.28.0"
}

group = "io.kk__777.library"
version = "0.1-SNAPSHOT"
//
//java {
//    withSourcesJar()
//    withJavadocJar()
//}
//
//publishing {
//    publications {
//        register<MavenPublication>("maven") {
//            pom {
//                name.set(project.name)
//                description.set("Introducing a library that dynamically generates a Color Palette and Theme for your Android app from a single seed color")
//                url.set("https://github.com/kk-777-1127/M3ColorThemeScreenAdaption")
//                licenses {
//                    license {
//                        name.set("Apache License")
//                        url.set("https://github.com/kk-777-1127/M3ColorThemeScreenAdaption/blob/main/LICENSE")
//                        distribution.set("repo")
//                    }
//                }
//                developers {
//                    developer {
//                        id.set("kk__777")
//                    }
//                }
//                scm {
//                     url.set("https://github.com/kk-777-1127/M3ColorThemeScreenAdaption")
//                }
//            }
//        }
//    }
//}
//
//tasks.named<SonatypeCentralUploadTask>("sonatypeCentralUpload") {
//    dependsOn( "jar", "sourcesJar", "javadocJar", "generatePomFileForMavenPublication")
//    username = System.getenv("SONATYPE_CENTRAL_USERNAME")
//    password = System.getenv("SONATYPE_CENTRAL_PASSWORD")
//    archives = files(
//        tasks.named("jar"),
//        tasks.named("sourcesJar"),
//        tasks.named("javadocJar"),
//    )
//    pom = file(
//        tasks.named("generatePomFileForMavenPublication").get().outputs.files.single()
//    )
//    signingKey = System.getenv("PGP_SIGNING_KEY")
//    signingKeyPassphrase = System.getenv("PGP_SIGNING_KEY_PASSPHRASE")
//}


mavenPublishing {
    publishToMavenCentral(SonatypeHost.DEFAULT)
    signAllPublications()
}

mavenPublishing {
    coordinates(
        "io.kk__777.m3-screen-color-theme",
        "m3-screen-color-theme",
        "0.1-SNAPSHOT"
    )

    pom {
        name.set(project.name)
        description.set("Introducing a library that dynamically generates a Color Palette and Theme for your Android app from a single seed color")
        inceptionYear.set("2020")
        url.set("https://github.com/kk-777-1127/M3ColorThemeScreenAdaption")
        licenses {
            license {
                name.set("Apache License")
                url.set("https://github.com/kk-777-1127/M3ColorThemeScreenAdaption/blob/main/LICENSE")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("kk__777")
            }
        }
        scm {
            url.set("https://github.com/kk-777-1127/M3ColorThemeScreenAdaption")
            connection.set("scm:git:git://github.com/kk-777-1127/M3ColorThemeScreenAdaptiongit")
            developerConnection.set("scm:git:ssh://git@github.com/kk-777-1127/M3ColorThemeScreenAdaption.git")
        }
    }
}