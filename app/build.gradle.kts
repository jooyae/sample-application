plugins {
    id(Plugins.APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.HILT_ANDROID_PLUGIN)
    id(Plugins.SAFE_ARGS)
    id(Plugins.PARCELIZE)
}

android {
    compileSdk = ConfigData.COMPILE_SDK

    defaultConfig {
        applicationId = ConfigData.APPLICATION_ID
        minSdk= ConfigData.MIN_SDK
        targetSdk= ConfigData.TARGET_SDK
        versionCode = ConfigData.VERSION_CODE
        versionName = ConfigData.VERSION_NAME
        buildToolsVersion = ConfigData.BUILD_TOOLS
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner =  Test.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }
    compileOptions {
        sourceCompatibility= JavaVersion.VERSION_1_8
        targetCompatibility= JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Plugins.COMPOSE
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(Kotlin.KOTLIN_STDLIBS)
    implementation(AndroidX.CORE_KTX)
    implementation(AndroidX.FRAGMENT_KTX)
    implementation(AndroidX.ACTIVITY_KTX)
    implementation(AndroidX.APPCOMPAT)
    implementation (AndroidX.CONSTRAINT_LAYOUT)
    implementation (Google.MATERIAL)
    implementation(AndroidX.COMPOSE_MATERIAL)
    androidTestImplementation(AndroidX.COMPOSE)
    testImplementation(Test.JUNIT)
    androidTestImplementation(Test.AndroidTest.JUNIT_EXT)
    androidTestImplementation(Test.AndroidTest.ESPRESSO_CORE)

    implementation(DaggerHilt.HILT_ANDROID)
    kapt(DaggerHilt.HILT_ANDROID_COMPILER)

    implementation(AndroidX.Lifecycle.VIEWMODEL)
    implementation(AndroidX.Lifecycle.LIVEDATA)

    implementation(ReactiveX.RX_JAVA)
    implementation(ReactiveX.RX_ANDROID)

    implementation(AndroidX.Navigation.NAVIGATION_FRAGMENT_KTX)
    implementation(AndroidX.Navigation.NAVIGATION_UI_KTX)


    //OkHttp Logging Interceptor
    implementation(Square.OKHTTP_LOGGING_INTERCEPTOR)

    implementation(Square.RETROFIT)
    implementation(Square.CONVERTER_GSON)
    implementation(Square.ADAPTER_RXJAVA)
    implementation(Square.GSON)

    //Coil
    implementation(Coil.COIL)

    //Paging3
    implementation(Paging3.Paging3)

    //Kakao
    implementation(KakaoSDK.V2_USER)

    //Lottie
    implementation(Lottie.LOTTIE)

    implementation(Lorem.LOREM_IPSUM)
    implementation(AndroidX.Paging.PAGING)
    implementation(AndroidX.Paging.PAGING_RXJAVA3)
}