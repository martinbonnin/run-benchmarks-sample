plugins {
  id("org.jetbrains.kotlin.android")
  id("com.android.library")
  id("androidx.benchmark")
}

android {
  namespace = "benchmark.sample.lib"
  compileSdk = 33

  defaultConfig {
    minSdk = 23
  }
}

dependencies {
}