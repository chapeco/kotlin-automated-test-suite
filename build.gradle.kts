import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val cucumberGroup = "io.cucumber"
val cucumberVersion = "4.3.1"

plugins {
    kotlin("jvm") version "1.3.21"
}

group = "chapeco"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    with(cucumberVersion) {
        testImplementation(group = cucumberGroup, name= "cucumber-java8", version = this)
        testImplementation(group = cucumberGroup, name = "cucumber-junit", version = this)
    }
    testCompile(group = "org.jetbrains.kotlin", name = "kotlin-test", version = "1.3.41")
    testCompile(group = "junit", name = "junit", version = "4.12")
    compile(group = "org.seleniumhq.selenium", name = "selenium-java", version = "3.141.59")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}