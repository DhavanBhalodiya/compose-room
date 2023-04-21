package com.example.buildsrc


object Configs {
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val CoreKtx = "1.7.0"
    const val ComposeUiVersion = "1.2.0"
    const val MaterialVersion = "1.2.0"
    const val RoomVersion = "2.5.0"
    const val LifecycleVersion = "2.6.0"
}
object Libs {
    const val ComposeBom="androidx.compose:compose-bom:2023.01.00"
    const val CoreKtx = "androidx.core:core-ktx:${Versions.CoreKtx}"
    const val ComposeUi = "androidx.compose.ui:ui:${Versions.ComposeUiVersion}"
    const val ComposUiPreview="androidx.compose.ui:ui-tooling-preview"
    const val ComposeMaterial = "androidx.compose.material:material:${Versions.MaterialVersion}"
    const val Activity = "androidx.activity:activity-compose:1.3.1"
    const val LifeCycleRunTime="androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val Tooling = "androidx.compose.ui:ui-tooling"
    const val Manifest = "androidx.compose.ui:ui-test-manifest"
    const val RoomKtx = "androidx.room:room-ktx:${Versions.RoomVersion}"
    const val RoomCompiler="androidx.room:room-compiler:${Versions.RoomVersion}"
    const val ViewModelKTX="androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LifecycleVersion}"
    const val LiveDataKtx="androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LifecycleVersion}"
    const val CommonJava="androidx.lifecycle:lifecycle-common-java8:${Versions.LifecycleVersion}"
    const val Material="com.google.android.material:material:1.8.0"
}

object TestingLibs{
    const val Junit = "junit:junit:4.13.2"
    const val JunitExt= "androidx.test.ext:junit:1.1.5"
    const val Espresso = "androidx.test.espresso:espresso-core:3.5.1"
    const val ComposeUiTestJunit= "androidx.compose.ui:ui-test-junit4:${Versions.ComposeUiVersion}"
}