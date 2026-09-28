plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.1.0"
}

group = "com.twobelle"
version = "1.0.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaUltimate("2026.2")
        instrumentationTools()
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "262"
            untilBuild = provider { null }
        }
    }
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }

    instrumentCode {
        enabled = false
    }

    // Desativa a tarefa automatizada de opções pesquisáveis que causava a falha no build
    buildSearchableOptions {
        enabled = false
    }

    runIde {
        systemProperty("user.language", "pt")
        systemProperty("user.country", "BR")
    }
}