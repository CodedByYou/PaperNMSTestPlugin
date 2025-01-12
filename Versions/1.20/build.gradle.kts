plugins {
    java
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.11" apply true
    kotlin("jvm")
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")
    implementation(kotlin("stdlib-jdk8"))
    compileOnly(project(":Shared"))
}


repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}