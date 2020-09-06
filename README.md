# digio-interview-exam🤖

[![Use this template](https://img.shields.io/badge/from-kotlin--android--template-brightgreen?logo=dropbox)](https://github.com/cortinico/kotlin-android-template/generate) ![Pre Merge Checks](https://github.com/giovaniguerra/digio-interview-test/workflows/Pre%20Merge%20Checks/badge.svg)  ![License](https://img.shields.io/github/license/cortinico/kotlin-android-template.svg) ![Language](https://img.shields.io/github/languages/top/cortinico/kotlin-android-template?color=blue&logo=kotlin)

Digio exam implementation project. 

[Exam description](teste_mobile_android_digio.pdf)

This project is build with **static analysis** and **continuous integration** already in place.

## Features 🎨

- **MVVM Architecture**.
- 100% Gradle Kotlin DSL setup.
- Dependency versions managed via `buildSrc`.
- CI Setup with GitHub Actions.
- Material Design Components
- Kotlin Static Analysis via `ktlint` and `detekt`.
- Kotlin Coroutines
- Kotlin Flow
- Android Arch ViewModel
- Android Arch LiveData
- Retrofit
- ViewBinding

## Gradle Setup 🐘

This project is using [**Gradle Kotlin DSL**](https://docs.gradle.org/current/userguide/kotlin_dsl.html) as well as the [Plugin DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block) to setup the build.

Dependencies are centralized inside the [Dependencies.kt](buildSrc/src/main/kotlin/Dependencies.kt) file in the `buildSrc` folder. This provides convenient auto-completion when writing your gradle files.

## Static Analysis 🔍

This project is using [**ktlint**](https://github.com/pinterest/ktlint) with the [ktlint-gradle](https://github.com/jlleitschuh/ktlint-gradle) plugin to format your code. To reformat all the source code as well as the buildscript you can run the `ktlintFormat` gradle task.

This project is also using [**detekt**](https://github.com/detekt/detekt) to analyze the source code, with the configuration that is stored in the [detekt.yml](config/detekt/detekt.yml) file (the file has been generated with the `detektGenerateConfig` task).

## CI ⚙️

This project is using [**GitHub Actions**](https://github.com/giovaniguerra/digio-interview-test/actions) as CI.

There are currently the following workflows available:
- [Validate Gradle Wrapper](.github/workflows/gradle-wrapper-validation.yml) - Will check that the gradle wrapper has a valid checksum
- [Pre Merge Checks](.github/workflows/pre-merge.yaml) - Will run the `build`, `check` tasks. 
