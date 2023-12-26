pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/LogicSoftInd/lsutil_android")
            credentials {
                username = "premkumar4701"
                password = "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"
            }
        }
    }
}

rootProject.name = "dynamicViewMposV2"
include(":app")
 