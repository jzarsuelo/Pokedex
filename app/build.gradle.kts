plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileSdkVersion(BuildConfigVersion.compileSdk)
    buildToolsVersion(BuildConfigVersion.buildTools)

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
    }

    defaultConfig {
        applicationId = "com.jzarsuelo.pokedex"
        minSdkVersion(BuildConfigVersion.minSdk)
        targetSdkVersion(BuildConfigVersion.targetSdk)
        versionCode = BuildConfigVersion.appVersionCode
        versionName = BuildConfigVersion.appVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            versionNameSuffix = "-debug"
        }

        getByName("release") {
            isDebuggable = false
            // R8 is enabled by default by using `minifyEnabled true`
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependency.kotlin)
    implementation(Dependency.android)
    implementation(Dependency.libraries)
    kapt(Dependency.compilers)
    testImplementation(Dependency.test)
    androidTestImplementation(Dependency.androidTest)

    implementation("androidx.legacy:legacy-support-v4:1.0.0")
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}