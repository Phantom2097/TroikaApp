# Troika App 🚇

**Troika App** — это кроссплатформенное приложение (Kotlin Multiplatform), разработанное для оптимизации расходов на общественный транспорт. Приложение анализирует историю ваших поездок по карте «Тройка» и помогает рассчитать, что выгоднее: покупать абонемент на определенный срок или оплачивать каждую поездку отдельно.

---

## 🚀 Технологический стек

Проект построен на **Kotlin Multiplatform (KMP)**, что позволяет использовать единую бизнес-логику и UI на всех платформах.

* **UI:** [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) (Shared UI для всех платформ).
* **Navigation:** [Navigation 3](https://developer.android.com/jetpack/compose/navigation) (актуальное решение для KMP).
* **DI:** [Koin](https://insert-koin.io/) для внедрения зависимостей.
* **Database:** [Room](https://developer.android.com/kotlin/multiplatform/room) (KMP поддержка).
* **Storage:** [DataStore](https://developer.android.com/kotlin/multiplatform/datastore) для хранения настроек и простых данных.
* **Asynchronous:** Kotlin Coroutines & Flow.

---

## 🏗 Архитектура

Приложение спроектировано с соблюдением принципов **Clean Architecture** и **SOLID**, чтобы обеспечить тестируемость и масштабируемость.

* **Presentation Layer:** Паттерн **MVVM** (Model-View-ViewModel).
* **Domain Layer:** Бизнес-логика, Use Cases и сущности.
* **Data Layer:** Репозитории, источники данных (Room, DataStore).

---

## 📱 Поддерживаемые платформы

| Платформа   | Статус           | Примечание                                                              |
|-------------|------------------|-------------------------------------------------------------------------|
| **Android** | ✅ Поддерживается | Полная работоспособность.                                               |
| **Windows** | ✅ Поддерживается | Desktop-версия.                                                         |
| **iOS**     | ⚠️ В разработке  | Код написан, но **не протестирован** из-за отсутствия macOS устройства. |

---

## 📈 Планы по развитию (Roadmap)

* [ ] Интеграция с NFC для чтения данных карты (Android).
* [ ] Детализированные графики расходов.

---

This is a Kotlin Multiplatform project targeting Android, iOS, Desktop (JVM).

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
    folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run Desktop (JVM) Application

To build and run the development version of the desktop app, use the run configuration from the run widget
in your IDE’s toolbar or run it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:run
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:run
  ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
