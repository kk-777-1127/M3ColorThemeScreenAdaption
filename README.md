# M3ColorThemeScreen

This library generates M3 Theme for screen from a single seed color

## Example
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
    SampleScreenThemeM3ColorTheme { // Use Generating Theme 
        SampleContent(route, screenNavController)
    }
}
```

## To Do
- Support Dynamic Theme 
- Publish this library
- Develop a feature to create a color palette and theme based on a seed color extracted from a loaded image URL.
