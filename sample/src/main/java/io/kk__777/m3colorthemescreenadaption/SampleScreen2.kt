package io.kk__777.m3colorthemescreenadaption

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import io.kk__777.library.StaticColorSourceTheme

private const val pinkSeed = 0xFFFF1493

@StaticColorSourceTheme(
    name = "", // If Empty, be used functionName.
    rgbColor = pinkSeed
)
@Composable
fun SampleScreen2(
    route: NavigationRoots,
    screenNavController: NavController
) {
    SampleScreen2M3ColorTheme {
        SampleContent(route, screenNavController)
    }
}