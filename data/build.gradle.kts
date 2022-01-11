import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}
dependencies {
    implementation("org.junit.jupiter:junit-jupiter")
}

repositories {
    mavenCentral()
}