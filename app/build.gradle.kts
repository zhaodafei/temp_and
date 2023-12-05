plugins {
    id("com.android.application")
}

android {
    namespace = "com.fei.myfei"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.fei.myfei"
        minSdk = 26
        targetSdk = 33
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

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Room 操作SQLite数据库
    implementation("androidx.room:room-runtime:2.5.1")
    annotationProcessor("androidx.room:room-compiler:2.5.1")

    // 地区三级联动: 需要在 settings.gradle.kts 中配置 maven("https://jitpack.io")
    implementation("com.github.gzu-liyujiang.AndroidPicker:Common:4.1.12")
    implementation("com.github.gzu-liyujiang.AndroidPicker:WheelView:4.1.12")
    implementation("com.github.gzu-liyujiang.AndroidPicker:WheelPicker:4.1.12")
    implementation("com.github.gzu-liyujiang.AndroidPicker:AddressPicker:4.1.12")
    implementation("com.github.gzu-liyujiang.AndroidPicker:ColorPicker:4.1.12")
    implementation("com.github.gzu-liyujiang.AndroidPicker:FilePicker:4.1.12")
    implementation("com.github.gzu-liyujiang.AndroidPicker:CalendarPicker:4.1.12")
    implementation("com.github.gzu-liyujiang.AndroidPicker:ImagePicker:4.1.12")

    // fastjson json解析
    // implementation("com.alibaba:fastjson:2.0.28")
    // 网路请求库 okhttp 网络框架
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    // 网路请求库  retrofit
    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")


}