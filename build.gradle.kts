plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "br.com.agendaaulaapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.com.agendaaulaapp"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.converter.jackson)
    implementation(libs.converter.gson)
    implementation(libs.converter.moshi)
    implementation(libs.converter.protobuf)
    implementation(libs.converter.wire)
    implementation(libs.converter.simplexml)
    implementation(libs.converter.jaxb)
    implementation(libs.okhttp.android)
    implementation(files("src/main/java/libs/jersey-bundle-1.17.1.jar"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}