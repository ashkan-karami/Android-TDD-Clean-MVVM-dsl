// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.androidApplication) version Versions.android apply false
    id(Plugins.androidLibrary) version Versions.android apply false
    id(Plugins.kotlin) version Versions.kotlin apply false
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}