/**
 * Created by lukasdylan on 2020-01-11
 */
object Dependency {
    // region Kotlin Library
    const val KOTLIN_STD_LIBRARY =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.KOTLIN_STD_LIBRARY}"
    const val COROUTINES_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.KOTLIN_COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.KOTLIN_COROUTINES}"
    // endregion

    // region AndroidX Library
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Version.ANDROIDX_APPCOMPAT}"
    const val CORE_KTX = "androidx.core:core-ktx:${Version.ANDROIDX_CORE_KTX}"
    const val GOOGLE_MATERIAL = "com.google.android.material:material:${Version.GOOGLE_MATERIAL}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Version.ANDROIDX_CONSTRAINT_LAYOUT}"
    const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel:${Version.ANDROIDX_LIFECYCLE}"
    const val VIEWMODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.ANDROIDX_LIFECYCLE}"
    const val LIVEDATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Version.ANDROIDX_LIFECYCLE}"
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Version.ANDROIDX_NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Version.ANDROIDX_NAVIGATION}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Version.ANDROIDX_FRAGMENT_KTX}"
    // endregion

    // region Others Library
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
    const val OKHTTP3_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP3_LOGGING_INTERCEPTOR}"
    const val RETROFIT_CONVERTER_MOSHI =
        "com.squareup.retrofit2:converter-moshi:${Version.RETROFIT_CONVERTER_MOSHI}"
    const val MOSHI_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:${Version.MOSHI_CODEGEN}"
    const val TIMBER = "com.jakewharton.timber:timber:${Version.TIMBER}"
    const val COIL = "io.coil-kt:coil:${Version.COIL}"
    const val DAGGER = "com.google.dagger:dagger:${Version.DAGGER}"
    const val DAGGER_ANDROID = "com.google.dagger:dagger-android-support:${Version.DAGGER}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Version.DAGGER}"
    const val DAGGER_ANDROID_PROCESSOR =
        "com.google.dagger:dagger-android-processor:${Version.DAGGER}"
    const val LOTTIE = "com.airbnb.android:lottie:${Version.LOTTIE}"
    // endregion

    // region Unit Test Library
    const val JUNIT = "junit:junit:${Version.JUNIT}"
    const val MOCKITO_CORE = "org.mockito:mockito-core:${Version.MOCKITO}"
    const val MOCKITO_ANDROID = "org.mockito:mockito-android:${Version.MOCKITO}"
    const val RETROFIT_MOCK = "com.squareup.retrofit2:retrofit-mock:${Version.RETROFIT}"
    const val ANDROIDX_CORE_TESTING =
        "androidx.arch.core:core-testing:${Version.ANDROIDX_CORE_TESTING}"
    // endregion

    // region Instrument Test Library
    const val TEST_EXT_JUNIT = "androidx.test.ext:junit:${Version.TEST_EXT_JUNIT}"
    const val TEST_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}"
    // endregion

    object Version {
        const val KOTLIN_STD_LIBRARY = "1.3.61"
        const val KOTLIN_COROUTINES = "1.3.3"
        const val ANDROIDX_APPCOMPAT = "1.1.0"
        const val ANDROIDX_CORE_KTX = "1.2.0"
        const val ANDROIDX_CONSTRAINT_LAYOUT = "2.0.0-beta4"
        const val ANDROIDX_LIFECYCLE = "2.2.0"
        const val ANDROIDX_NAVIGATION = "2.2.1"
        const val ANDROIDX_FRAGMENT_KTX = "1.2.1"
        const val GOOGLE_MATERIAL = "1.2.0-alpha04"
        const val RETROFIT = "2.7.1"
        const val OKHTTP3_LOGGING_INTERCEPTOR = "4.3.1"
        const val RETROFIT_CONVERTER_MOSHI = "2.7.1"
        const val MOSHI_CODEGEN = "1.8.0"
        const val TIMBER = "4.7.1"
        const val COIL = "0.9.5"
        const val DAGGER = "2.25.4"
        const val LOTTIE = "3.3.1"
        const val JUNIT = "4.12"
        const val MOCKITO = "3.2.4"
        const val ANDROIDX_CORE_TESTING = "2.1.0"
        const val TEST_EXT_JUNIT = "1.1.1"
        const val ESPRESSO_CORE = "3.2.0"
    }
}
