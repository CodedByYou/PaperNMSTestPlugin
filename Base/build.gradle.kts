import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.11" apply true
    id("io.github.goooler.shadow") version "8.1.3"
    kotlin("jvm")
}

val type = 0
val types = arrayOf("", "-DEV", "-PROD")

description = "PaperNMSTestPlugin"
version = "1.0-SNAPSHOT${types[type]}"


dependencies {
    paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":Versions:1.20"))
    implementation(project(":Shared"))
}

tasks.processResources {
    filesMatching("plugin.yml") {
        expand("version" to project.version)
    }
}

tasks.withType<ShadowJar> {
    dependsOn("processResources")
    mergeServiceFiles()

    archiveFileName.set("${project.description}-${project.version}.jar")
    archiveClassifier.set("all") // Makes this the main jar file
    archiveVersion.set(project.version.toString())

    relocate("com.codedbyyou.papernmstestplugin.shared", "com.codedbyyou.papernmstestplugin.base")
    relocate("com.codedbyyou.papernmstestplugin.v1_20", "com.codedbyyou.papernmstestplugin.versions.v1_20")

    manifest.attributes["Main-Class"] = "com.kyotopvp.papernmstestplugin.PaperNMSTestPlugin"

    from(sourceSets["main"].output)

    minimize()
}


repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}