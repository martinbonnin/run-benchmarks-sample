@file:Suppress("UnstableApiUsage")

plugins {
  id("org.jetbrains.kotlin.android")
  id("com.android.test")
}

android {
  namespace = "benchmark.sample.macrobenchmark"
  compileSdk = 33

  defaultConfig {
    minSdk = 23
    targetSdk = 33

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    create("benchmark") {
      isDebuggable = true
      signingConfig = getByName("debug").signingConfig
      matchingFallbacks += listOf("release")
    }
  }

  targetProjectPath = ":app"
  experimentalProperties["android.experimental.self-instrumenting"] = true
}

dependencies {
  implementation("androidx.test.ext:junit:1.1.3")
  implementation("androidx.test.espresso:espresso-core:3.4.0")
  implementation("androidx.test.uiautomator:uiautomator:2.2.0")
  implementation("androidx.benchmark:benchmark-macro-junit4:1.1.0")
}

androidComponents {
  beforeVariants(selector().all()) {
    it.enable = it.buildType == "benchmark"
  }
}