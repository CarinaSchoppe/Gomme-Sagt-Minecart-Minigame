import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins{
    kotlin("jvm") version "+"
    id("xyz.jpenilla.run-paper") version "+"
    id("com.github.johnrengelman.shadow") version "+"
    id("java")
}
description = "Minecraft Minigame Plugin"
group = "me.carina"
version = "2.4.1"
repositories{
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    mavenCentral()
}
dependencies{
    compileOnly("io.papermc.paper:paper-api:+")
    testImplementation(kotlin("test"))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}


tasks {
    runServer {
        minecraftVersion("1.19")
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
        options.release.set(17)
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
    }
    withType<KotlinCompile>{
        kotlinOptions {
            freeCompilerArgs = listOf(
                "-Xuse-k2",
                "-Xjdk-release=17"
            )
            jvmTarget = "17"
            languageVersion = "1.7"
        }
    }
    test {
        useJUnitPlatform()
    }
}