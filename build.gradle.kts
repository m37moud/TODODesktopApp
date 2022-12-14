import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0"
    id("com.squareup.sqldelight")
    id("kotlin-parcelize")
}

group = "me.m37mo"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.6.0")
     // Decompose : Decompose
    val decomposeVersion = "0.2.5"
    implementation("com.arkivanov.decompose:decompose-jvm:$decomposeVersion")
    implementation("com.arkivanov.decompose:extensions-compose-jetbrains-jvm:$decomposeVersion")
    implementation("com.arkivanov.mvikotlin:mvikotlin:3.0.2")
    implementation(com.ArkIvanov.MVIKotlin.mvikotlinMain)
    implementation("com.badoo.reaktive:reaktive:1.2.2")
    implementation(com.Badoo.Reaktive.coroutinesInterop)
    implementation("com.squareup.sqldelight:gradle-plugin:1.5.4")
    implementation ("com.squareup.sqldelight:jdbc-driver:1.5.3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "TODODesktopApp"
            packageVersion = "1.0.0"
        }
    }
}

sqldelight {
    database("TodoDatabase") {
        packageName = "example.todo.database"
    }
}
