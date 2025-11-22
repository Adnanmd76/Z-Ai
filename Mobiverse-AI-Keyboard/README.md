#MobiVerse🤖

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://android.com)
[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg)](https://android-arsenal.com/api?level=24)
[![Version](https://img.shields.io/badge/Version-1.0.0-blue.svg)](https://github.com/Adnanmd76/Z-Ai)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

An intelligent Android application that provides an AI-powered choice selection interface with modern Material Design 3 UI, smart notifications, and auto-start capabilities.

## ✨ Features

- **🎯 AI-Powered Choice Selection**: Intelligent choice recommendation system
- **🎨 Material Design 3**: Modern UI following Google's latest design guidelines
- **🔔 Smart Notifications**: Context-aware notification system
- **🚀 Auto-Start**: Optional automatic app launch on device boot
- **💾 Choice Persistence**: Save and restore user choices
- **⚡ Performance Optimized**: Efficient memory usage and fast response

## 🏗️ Architecture

```
Z-Ai/
├── app/
│   ├── src/main/
│   │   ├── java/com/zai/choicescreen/
│   │   │   ├── ChoiceActionReceiver.java    # Choice action handling
│   │   │   └── BootReceiver.java            # Auto-start functionality
│   │   └── res/
│   │       ├── drawable/
│   │       │   └── ic_notification.xml      # Notification icon
│   │       └── values/
│   │           ├── strings.xml              # String resources
│   │           └── themes.xml               # Material Design themes
│   └── proguard-rules.pro                   # ProGuard configuration
├── build.gradle                             # Project-level build script
├── settings.gradle                          # Project settings
├── gradle.properties                        # Gradle properties
└── README.md                                # This file
```

## 🚀 Getting Started

### Prerequisites

- Android Studio Arctic Fox (2020.3.1) or newer
- Android SDK API level 24 (Android 7.0) or higher
- Java JDK 8 or higher
- Gradle 8.4 or higher

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Adnanmd76/Z-Ai.git
   cd Z-Ai
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned directory and select it

3. **Build the project**
   ```bash
   ./gradlew build
   ```

## 🔧 Configuration

### Build Configuration

- **Compile SDK**: 34 (Android 14)
- **Target SDK**: 34
- **Min SDK**: 24 (Android 7.0)
- **Kotlin**: 1.9.20
- **AGP**: 8.1.4

### Key Components

#### ChoiceActionReceiver
Handles choice-related broadcast actions:
- Choice selection processing
- Choice confirmation handling
- Notification management
- SharedPreferences integration

#### BootReceiver
Manages auto-start functionality:
- Device boot detection
- Auto-start preference checking
- Background service initialization
- Boot statistics tracking

#### Material Design 3 Theming
- Light, dark, and system themes
- Custom button styles
- Card-based layouts
- Accessibility support

## 🛠️ Development

### Building for Release

```bash
# Build release APK
./gradlew assembleRelease

# Build App Bundle
./gradlew bundleRelease
```

### Testing

```bash
# Run unit tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest
```

### Performance Optimization

- **R8 Code Shrinking**: Removes unused code
- **ProGuard Obfuscation**: Protects and optimizes code
- **Resource Shrinking**: Removes unused resources
- **Build Cache**: Faster incremental builds
- **Parallel Execution**: Multi-threaded compilation

## 📊 Project Status

### Completed ✅
- [x] Project structure setup
- [x] Material Design 3 theming system
- [x] Choice action handling (ChoiceActionReceiver)
- [x] Auto-start functionality (BootReceiver)
- [x] Notification system implementation
- [x] ProGuard/R8 optimization configuration
- [x] Build performance optimizations
- [x] String resources and themes
- [x] Notification icon design
- [x] Comprehensive documentation

### TODO 📋
- [ ] Implement MainActivity with choice selection UI
- [ ] Create app manifest with proper permissions
- [ ] Add app-level build.gradle configuration
- [ ] Design choice selection layouts
- [ ] Add Material Design color resources
- [ ] Create app launcher icons
- [ ] Implement choice processing logic
- [ ] Add comprehensive unit tests
- [ ] Create instrumentation tests
- [ ] Add user documentation

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m 'Add amazing feature'`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

### Development Guidelines

- Follow Android development best practices
- Write clear, concise commit messages
- Add tests for new features
- Update documentation as needed
- Follow the existing code style

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2024 Muhammad Adnan Ul Mustafa

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```

## 👨‍💻 Author

**Muhammad Adnan Ul Mustafa**
- Email: [adnanmd76@gmail.com](mailto:adnanmd76@gmail.com)
- GitHub: [@Adnanmd76](https://github.com/Adnanmd76)
- Project: [Z-AI Choice Screen](https://github.com/Adnanmd76/Z-Ai)

## 🙏 Acknowledgments

- Google for Android development tools and Material Design
- AndroidX team for modern Android libraries
- Open source community for inspiration and resources
- Material Design team for the excellent design system

## 📞 Support

If you have any questions, issues, or suggestions:

1. **GitHub Issues**: [Create an issue](https://github.com/Adnanmd76/Z-Ai/issues)
2. **Email**: [adnanmd76@gmail.com](mailto:adnanmd76@gmail.com)
3. **Documentation**: Check this README and code comments

---

<div align="center">
  <p><strong>Made with ❤️ for the Android community</strong></p>
  <p>⭐ Star this repository if you find it helpful!</p>
</div>
