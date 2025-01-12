# PaperNMSTestPlugin
A PaperMC template plugin that demonstrates the usage of multiple NMS (Net Minecraft Server) versions. This project enables compatibility with different Minecraft versions.

## Features

- Modular approach to handling different NMS versions using Gradle SubModules.
- Demonstrates version-specific NMS functionality.

## Project Structure

- **Base**: Contains common logic used by all versions. ( Uses Latest Version )
- **Shared**: Shared interfaces and utilities for version-specific classes. ( Uses Latest Version (Optional) )
- **Versions**: Contains version-specific NMS classes (e.g., `1_20`).

```bash
./gradlew Base:shadowJar
```

This command will build the plugin and output a fat JAR file, which contains all dependencies and is ready for use in a PaperMC server.

## Notes

- The module-specific `build.gradle.kts` and the general `settings.gradle.kts` both contain important configuration such as the versions included and modules and their dependencies. Make sure these files are properly set up for your specific project needs to ensure everything works as intended.
- Also the main `build.gradle.kts` is important, and can be further improved. This is just a template plugin that i had made to get a small win before using it in my main plugin.

## Running the Plugin

Build the plugin using the command above.
Copy the generated .jar file into the plugins directory of your PaperMC server.
Restart or reload the server to enable the plugin.

