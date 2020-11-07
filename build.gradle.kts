// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(Dependency.Classpath.buildGradle)
        classpath(Dependency.Classpath.kotlinGradlePlugin)
        classpath(Dependency.Classpath.daggerHiltGradlePlugin)
        classpath(Dependency.Classpath.navSafeArgs)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

task ("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}