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
        // JitPack 远程仓库：https://jitpack.io
        maven("https://jitpack.io")
    }
}

rootProject.name = "temp_and"
include(":app")
 