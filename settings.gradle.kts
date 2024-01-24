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
    }
}

rootProject.name = "PosApp"
include(":app")
include(":core:database")
include(":core:data")
include(":core:domain")
include(":core:preferences")
include(":core:design")
include(":feature:auth")
include(":feature:home")
include(":feature:items")
include(":feature:purchases")
include(":feature:category")
include(":feature:exchange")
include(":feature:unit")
