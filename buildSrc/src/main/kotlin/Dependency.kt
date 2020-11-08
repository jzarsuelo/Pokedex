object Dependency {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"

    object Classpath {
        const val buildGradle = "com.android.tools.build:gradle:${Version.gradle}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
        const val daggerHiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Version.Library.daggerHilt}"
        const val navSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.Android.nav}"
    }

    val android = listOf(
        Android.ktxCore,
        Android.appCompat,
        Android.constraintLayout,
        Android.navFragment,
        Android.navUi,
        Android.navRuntime,
        Android.coordinatorLayout
    )

    val libraries = listOf(
        Library.material,
        Library.timber,
        Library.daggerHilt,
        Library.daggerHiltViewModel,
        Library.retrofit,
        Library.okhttp,
        Library.okhttpLoggingInterceptor,
        Library.retrofitConverterMoshi,
        Library.moshi,
        Library.moshiKotlinAdapter,
        Library.coil
    )

    val compilers = listOf(
        Library.moshiCodeGen,
        Library.daggerHiltCompiler,
        Library.daggerHiltViewModelCompiler
    )

    val test = listOf(
        Test.junit
    )

    val androidTest = listOf(
        AndroidTest.androidTestExtensionJunit,
        AndroidTest.espressoCore
    )

    private object Android {
        const val ktxCore = "androidx.core:core-ktx:${Version.Android.ktxCore}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.Android.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.Android.constraintLayout}"

        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Version.Android.nav}"
        const val navUi = "androidx.navigation:navigation-ui-ktx:${Version.Android.nav}"
        const val navRuntime = "androidx.navigation:navigation-runtime-ktx:${Version.Android.nav}"
        // not used for now
        const val navDynamicFeatures = "androidx.navigation:navigation-dynamic-features-fragment:${Version.Android.nav}"

        const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Version.Android.coordinatorLayout}"
    }

    private object Test {
        const val junit = "junit:junit:${Version.Test.junit}"
    }

    private object AndroidTest {
        const val androidTestExtensionJunit = "androidx.test.ext:junit:${Version.AndroidTest.androidTestExtensionJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.AndroidTest.espressoCore}"
    }

    private object Library {
        // material
        const val material = "com.google.android.material:material:${Version.Library.material}"

        // log
        const val timber = "com.jakewharton.timber:timber:${Version.Library.timber}"

        // dependency injection
        const val daggerHilt = "com.google.dagger:hilt-android:${Version.Library.daggerHilt}"
        const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.Library.daggerHilt}"
        const val daggerHiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Version.Library.daggerHiltViewModel}"
        const val daggerHiltViewModelCompiler = "androidx.hilt:hilt-compiler:${Version.Library.daggerHiltViewModel}"

        // network
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.Library.retrofit}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Version.Library.okhttp}"
        const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.Library.okhttp}"

        // parser
        const val retrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:${Version.Library.retrofit}"
        const val moshi = "com.squareup.moshi:moshi:${Version.Library.moshi}"
        const val moshiKotlinAdapter = "com.squareup.moshi:moshi-kotlin:${Version.Library.moshi}"
        const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Version.Library.moshi}"

        // image loader
        const val coil = "io.coil-kt:coil:${Version.Library.coil}"
    }
}