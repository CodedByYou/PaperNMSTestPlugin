plugins {
    java
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.11" apply true
    kotlin("jvm")
}

dependencies {
    paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.processResources {
    val props = mapOf("version" to project.version)
    inputs.properties(props)
    filteringCharset = "UTF-8"

    filesMatching("plugin.yml") {
        expand(props)
    }
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}