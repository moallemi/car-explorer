# Car Explorer
A sample app illustrating Android development best practices with Android Jetpack.

Getting Started
---------------
This project uses the Gradle build system. To build this project, use the
`gradlew build` command or use "Import Project" in Android Studio.

There are Gradle tasks for testing the project:
* `test` - for running unit tests

Android development
--------------
* [Foundation][0] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
  * [AppCompat][1] - Degrade gracefully on older versions of Android.
  * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
  * [Test][4] - An Android testing framework for unit and runtime UI tests.
* [Architecture][10] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
  * [LiveData][13] - Build data objects that notify views when the underlying database changes.
  * [ViewModel][17] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
* Third party
  * [Dagger][88] - For Dependency Injection
  * [RxJava][89] - To Manage async calls in reactive way
  * [Picasso][90] - For image loading

Development setup
------------------------
For development, the latest version of Android Studio 3.4 is required. The latest version can be
downloaded from [here](https://developer.android.com/studio/).

### Code style

Car Explorer uses [ktlint](https://ktlint.github.io/) to enforce Kotlin coding styles.
Here's how to configure it for use with Android Studio (instructions adapted
from the ktlint [README](https://github.com/shyiko/ktlint/blob/master/README.md)):

- Close Android Studio if it's open

- Download ktlint using these [installation instructions](https://github.com/shyiko/ktlint/blob/master/README.md#installation)

- Inside the project root directory run:

  `./ktlint --apply-to-idea-project --android`

- Start Android Studio

### API keys

You need to supply API / client keys for the various services the
app uses. That is currently Google Maps Api Key. You can find information about
how to gain access via the relevant links.

When you obtain the keys, you can provide them to the app by putting the following in the
`gradle.properties` file in your user home:

Get this from [Google Cloud Console][91]
```
car_explorer_google_maps_api_key=<insert>
```

On Linux/Mac that file is typically found at `~/.gradle/gradle.properties` or in the project directory `car-explorer/gradle.properties`


[0]: https://developer.android.com/jetpack/foundation/
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[4]: https://developer.android.com/training/testing/
[10]: https://developer.android.com/jetpack/arch/
[12]: https://developer.android.com/topic/libraries/architecture/lifecycle
[13]: https://developer.android.com/topic/libraries/architecture/livedata
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel
[88]: https://google.github.io/dagger/
[89]: https://github.com/ReactiveX/RxJava
[90]: https://github.com/square/picasso
[91]: https://developers.google.com/maps/documentation/android-sdk/signup


