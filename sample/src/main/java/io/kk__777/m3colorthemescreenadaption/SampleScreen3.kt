package io.kk__777.m3colorthemescreenadaption

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import io.kk__777.library.StaticColorSourceTheme

private const val yellowSeed = 0xFFFFFF00

@StaticColorSourceTheme(
    name = "Hogehoge",
    rgbColor = yellowSeed
)
@Composable
fun SampleScreen3(
    route: NavigationRoots,
    screenNavController: NavController
) {
    HogehogeM3ColorTheme {
        SampleContent(route, screenNavController)
    }
}