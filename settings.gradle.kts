pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "UserProfile"
include(":app")
include(":common:base_domain")
include(":common:core")
include(":common:network")
include(":data")
include(":domain")
include(":features:profile:data")
include(":features:profile:domain")
include(":features:profile:profile_feature")
include(":common:navigation")
include(":features:login:data")
include(":features:login:domain")
include(":features:login:login_feature")
