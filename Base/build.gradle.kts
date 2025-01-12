import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.11" apply true
    id("io.github.goooler.shadow") version "8.1.3"
    kotlin("jvm")
}

dependencies {
    paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")

    implementation(kotlin("stdlib-jdk8"))
    implementation(
        project(
            ":Versions:1.20"
        )
    )
    implementation(project(":Shared"))

}

tasks.processResources {
    val props = mapOf("version" to project.version)
    inputs.properties(props)
    filteringCharset = "UTF-8"

    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks.withType<ShadowJar> {
    dependsOn("processResources")
    archiveBaseName.set("PaperNMSTestPlugin")
    archiveClassifier.set("") // Makes this the main jar file
    archiveVersion.set("") // Removes the version from the jar file

    relocate("com.codedbyyou.papernmstestplugin.shared", "com.codedbyyou.papernmstestplugin.base")
    relocate("com.codedbyyou.papernmstestplugin.v1_20", "com.codedbyyou.papernmstestplugin.versions.v1_20")

    manifest.attributes["Main-Class"] = "com.kyotopvp.papernmstestplugin.PaperNMSTestPlugin"



    from(sourceSets["main"].output)
    from(sourceSets["main"].resources)

    minimize()

}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}