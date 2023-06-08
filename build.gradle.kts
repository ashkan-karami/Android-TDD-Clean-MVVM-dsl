// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.androidApplication) version Versions.android apply false
    id(Plugins.androidLibrary) version Versions.android apply false
    id(Plugins.kotlin) version Versions.kotlin apply false
    id(Plugins.hilt) version Versions.hilt apply false
    id(Plugins.navigation) version Versions.navigation apply false
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}