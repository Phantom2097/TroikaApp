import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.androidKmpLibrary)

    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
    alias(libs.plugins.serialization)
}

kotlin {
    jvmToolchain(21)
//    compilerOptions {
//        freeCompilerArgs.apply {
//            add("-Xskip-prerelease-check")
//            add("-Xexplicit-backing-fields")
//            add("-XXLanguage:+ExplicitBackingFields")
//        }
//    }

    androidLibrary {
        namespace = "ru.phantom2097.trikaapp"
        compileSdk = libs.versions.android.compileSdk.get().toInt()

        androidResources.enable = true
        version = "0.1.0"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvm()

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.activity.compose)
            // Koin
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(libs.material3.adaptive)
            implementation(libs.material3.adaptive.navigation.suite)

            // DataStore library
            api(libs.androidx.datastore)
            // The Preferences DataStore library
            api(libs.androidx.datastore.preferences)

            // DateTime
            implementation(libs.kotlinx.datetime)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)

            // Navigation 3
            implementation(libs.jetbrains.navigation3.ui)
            implementation(libs.jetbrains.material3.adaptiveNavigation3)

            // Serialization
            implementation(libs.kotlinx.serialization.json)

            // Room
            implementation(libs.androidx.room.runtime)
            implementation(libs.androidx.sqlite.bundled)

            // Window size class
            implementation(libs.jetbrains.compose.material3.windowSizeClass)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            // Coroutine
            implementation(libs.kotlinx.coroutines.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "ru.phantom2097.troikaapp.resources"
    generateResClass = auto
}

dependencies {
    androidRuntimeClasspath(libs.androidx.compose.ui.tooling)

    add("kspAndroid", libs.androidx.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
    add("kspIosArm64", libs.androidx.room.compiler)
    add("kspJvm", libs.androidx.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}

compose.desktop {
    application {
        mainClass = "ru.phantom2097.troikaapp.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ru.phantom2097.troikaapp"
            packageVersion = "1.0.0"
        }
    }
}
