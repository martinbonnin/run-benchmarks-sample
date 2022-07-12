@file:Suppress("UnstableApiUsage")

plugins {
  id("org.jetbrains.kotlin.android")
  id("com.android.application")
  id("androidx.benchmark")
}

android {
  namespace = "benchmark.sample.app"
  compileSdk = 33

  defaultConfig {
    minSdk = 23
    targetSdk = 33
    testInstrumentationRunner = "androidx.benchmark.junit4.AndroidBenchmarkRunner"
  }
  buildTypes {
    create("benchmark") {
      signingConfig = signingConfigs.getByName("debug")
      matchingFallbacks += listOf("release")
      isDebuggable = false
    }
  }

  buildFeatures.compose = true

  composeOptions {
    kotlinCompilerExtensionVersion = "1.2.0"
  }
}


dependencies {
  implementation("androidx.core:core-ktx:1.8.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")
  implementation("androidx.activity:activity-compose:1.5.0")
  implementation("androidx.compose.ui:ui:1.1.1")
  implementation("androidx.compose.ui:ui-tooling-preview:1.1.1")
  implementation("androidx.compose.material:material:1.3.0-alpha01")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.1")
  debugImplementation("androidx.compose.ui:ui-tooling:1.1.1")
  debugImplementation("androidx.compose.ui:ui-test-manifest:1.1.1")
}