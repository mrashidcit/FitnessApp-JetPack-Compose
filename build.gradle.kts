
buildscript {
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    id("com.android.application") version "8.2.0" apply false
    id("com.android.application") version "8.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.21" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
//    id("com.google.dagger.hilt.android") version "2.44" apply false
}

// [Versions]

// Sdk and tools
val minSdkVersion by extra(21)
val targetSdkVersion by extra(34)
val compileSdkVersion by extra(34)

// App dependencies
val hiltVersion by extra("2.50")


