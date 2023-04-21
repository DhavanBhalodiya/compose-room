import com.example.buildsrc.*
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.composewithroom"
    compileSdk = Configs.compileSdk

    defaultConfig {
        applicationId = "com.example.composewithroom"
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Libs.CoreKtx)
    implementation(Libs.LifeCycleRunTime)
    implementation(Libs.Activity)
    implementation(Libs.ComposeUi)
    implementation(Libs.ComposeMaterial)

    testImplementation(TestingLibs.Junit)
    androidTestImplementation(TestingLibs.JunitExt)
    androidTestImplementation(TestingLibs.Espresso)
    androidTestImplementation(TestingLibs.ComposeUiTestJunit)
    debugImplementation(Libs.Tooling)
    debugImplementation(Libs.Manifest)

    //compose
    implementation(platform(Libs.ComposeBom))
    // Android Studio Preview support
    implementation(Libs.ComposUiPreview)

    implementation(Libs.Material)

    // Room components
    implementation(Libs.RoomKtx)
    kapt(Libs.RoomCompiler)

    // Lifecycle components
    implementation(Libs.ViewModelKTX)
    implementation(Libs.LiveDataKtx)
    implementation(Libs.CommonJava)

}