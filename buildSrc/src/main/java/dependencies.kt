@file:Suppress("ClassName", "unused")

object Versions {
    // android
    const val compileSdk = 28
    const val minSdk = 14
    const val minSdkConductor = 16
    const val targetSdk = 28
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val androidGradlePlugin = "3.2.0"
    const val androidx = "1.0.0"
    const val androidxArch = "2.0.0-rc01"
    const val conductor = "2.1.5"
    const val kotlin = "1.3.0-rc-57"
    const val mavenGradle = "2.1"
    const val rxJava = "2.2.2"
}

object Deps {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidx}"

    const val archLifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime:${Versions.androidxArch}"

    const val conductor = "com.bluelinelabs:conductor:${Versions.conductor}"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val mavenGradlePlugin = "com.github.dcendents:android-maven-gradle-plugin:${Versions.mavenGradle}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
}