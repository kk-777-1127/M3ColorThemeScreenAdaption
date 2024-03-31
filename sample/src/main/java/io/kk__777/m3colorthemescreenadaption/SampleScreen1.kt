package io.kk__777.m3colorthemescreenadaption

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import io.kk__777.library.StaticColorSourceTheme

private const val blueSeed = 0xFF00008B

@StaticColorSourceTheme( // Annotation for creating color pallet via build
    name = "SampleScreenTheme",
    rgbColor = blueSeed
)
@Composable
fun SampleScreen1(
    route: NavigationRoots,
    screenNavController: NavController
) {
    SampleScreenThemeM3ColorTheme { // Use Theme after build
        SampleContent(route, screenNavController)
    }
}