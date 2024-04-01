# M3ColorThemeScreen

Generate an M3 Theme for screen or screens based on a single seed color, using annotations. Utilizes [material-color-utilities](https://github.com/material-foundation/material-color-utilities) for generating color palettes.

## Usage
```gradle.kts
plugin {
    id("com.google.devtools.ksp")
}

dependencies {
    implementation("com.github.kk-777-1127.M3ColorThemeScreen:m3-color-theme-screen:0.1.1-SNAPSHOT")
    ksp("com.github.kk-777-1127.M3ColorThemeScreen:compiler:0.1.1-SNAPSHOT")
}
```

```kotlin
private const val blueSeed = 0xFF00008B

@StaticColorSourceTheme( // Add annotation for generating color palette and theme at build time.
    name = "SampleScreenTheme",
    rgbColor = blueSeed
)
@Composable
fun SampleScreen1(
    route: NavigationRoots,
    screenNavController: NavController
) {
    SampleScreenThemeM3ColorTheme { // Use Generated Theme 
        SampleContent(route, screenNavController)
    }
}
```

## To Do
- Support Dynamic Theme
- a seed color extracted from a loaded image URL.
