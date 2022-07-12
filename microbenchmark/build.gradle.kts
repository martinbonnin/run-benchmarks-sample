plugins {
  id("org.jetbrains.kotlin.android")
  id("com.android.library")
  id("androidx.benchmark")
}

android {
  namespace = "benchmark.sample.microbenchmark"
  compileSdk = 33

  defaultConfig {
    minSdk = 23
    testInstrumentationRunner = "androidx.benchmark.junit4.AndroidBenchmarkRunner"
  }

  @Suppress("UnstableApiUsage")
  useLibrary("android.test.base")
}

dependencies {
  androidTestImplementation("androidx.benchmark:benchmark-junit4:1.1.0")
  androidTestImplementation("androidx.test:core:1.4.0")
  androidTestImplementation(project(":lib"))
}