package io.kk__777.m3colorthemescreenadaption

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.kk__777.m3colorthemescreenadaption.ui.theme.M3ColorThemeScreenAdaptionTheme

enum class NavigationRoots(val root: String) {
    Root("default") {
        @Composable
        override fun Content(screenNavController: NavController) {
            M3ColorThemeScreenAdaptionTheme {
                SampleContent(route = this, screenNavController = screenNavController)
            }
        }
    },
    Blue("blue") {
        @Composable
        override fun Content(screenNavController: NavController) {
            SampleScreen1(route = this, screenNavController = screenNavController)
        }
    },
    Pink("pink") {
        @Composable
        override fun Content(screenNavController: NavController) {
            SampleScreen2(route = this, screenNavController = screenNavController)
        }
    },
    Yellow("yellow") {
        @Composable
        override fun Content(screenNavController: NavController) {
            SampleScreen3(route = this, screenNavController = screenNavController)
        }
    };

    @Composable
    abstract fun Content(screenNavController: NavController)
}

@Composable
fun SampleRootScreen() {
    M3ColorThemeScreenAdaptionTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = NavigationRoots.Root.root) {
            NavigationRoots.entries.forEach { roots ->
                composable(roots.root) { roots.Content(screenNavController = navController) }
            }
        }
    }
}