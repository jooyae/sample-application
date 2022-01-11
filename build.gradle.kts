// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (Gradle.GRADLE_DEPENDENCY)
        classpath (Plugins.KOTLIN_GRADLE_PLUGIN)
        classpath(Plugins.DAGGER_HILT_GRADLE_PLUGIN)
        classpath(Plugins.NAVIGATION_PLUGIN)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://devrepo.kakao.com/nexus/content/groups/public/")
        maven {
            setUrl("https://naver.jfrog.io/artifactory/maven/")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}