object ApplicationId {
    const val id = "io.kotlin.gear"
}

object Modules {
    const val app = ":app"
    const val common = ":commons"
    const val core = ":core"
    const val libraries = ":libraries"
    const val model = ":model"
    const val localDatabase = ":local"
    const val repository = ":repository"
    const val remote = ":remote"
}

object Constant {
    const val packageName = "com.example.gear_kotlin"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val kotlin = "1.3.71"
    const val gradle = "3.6.1"
    const val compileSdk = 28
    const val minSdk = 21
    const val targetSdk = 28
    const val appCompat = "1.1.0"
    const val coreKtx = "1.1.0"
    const val activityKtx = "1.1.0"
    const val fragmentKtx = "1.2.4"
    const val liveDataKtx = "2.2.0"
    const val constraintLayout = "1.1.3"

    const val androidTestRunner = "1.1.2-alpha02"
    const val espressoCore = "3.2.0-alpha02"
    const val retrofit = "2.8.1"
    const val retrofitCoroutines = "0.9.2"
    const val retrofitGson = "2.8.1"
    const val gson = "2.8.5"
    const val okHttp = "4.5.0"
    const val coroutines = "1.3.0"
    const val koin = "1.0.2"
    const val timber = "4.7.1"
    const val lifecycle = "2.2.0"
    const val navigation = "2.2.1"
    const val room = "2.2.5"
    const val recyclerview = "1.1.0"
    const val glide = "4.9.0"
    const val mockwebserver = "2.7.5"
    const val archCoreTest = "2.0.0"
    const val androidJunit = "1.1.0"
    const val mockk = "1.9.2"
    const val fragmentTest = "1.1.0-alpha06"
    const val databinding = "3.3.2"
    const val googleServicesVersion = "4.3.3"
    const val daggerVersion = "2.27"
    const val eventbus = "3.2.0"
    const val workVersion = "2.3.4"
}

object Libraries {
    // KOIN
    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    // ROOM
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // RETROFIT
    val retrofitCoroutineAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"

    val retrofitOkHTTP = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    // GLIDE
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    // Dagger

    val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    var daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"

    //    eventBus
    val eventBus = "org.greenrobot:eventbus:${Versions.eventbus}"
    val eventBusAnotation = "org.greenrobot:eventbus-annotation-processor:${Versions.eventbus}"
}

object KotlinLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinCoroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidLibraries {
    // KOTLIN
    const val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // ANDROID
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveDataKtx}"
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workVersion}"

}

object TestLibraries {
    // ANDROID TEST
    val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
    val fragmentNav = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"

    // KOIN
    val koin = "org.koin:koin-test:${Versions.koin}"

    // MOCK WEBSERVER
    val mockWebServer = "com.squareup.okhttp:mockwebserver:${Versions.mockwebserver}"

    // MOCK
    val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"

    // COROUTINE
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    // DATA BINDING
    val databinding = "androidx.databinding:databinding-compiler:${Versions.databinding}"
}