buildscript {
//  val compose_ui_version by extra("1.2.0")
}

plugins {
  id("org.jetbrains.kotlin.jvm").version("1.7.0").apply(false)
  id("com.android.application").version("7.4.0-alpha08").apply(false)
  id("androidx.benchmark").version("1.1.0").apply(false)
}

allprojects {
  repositories {
    mavenCentral()
    google()
  }
}