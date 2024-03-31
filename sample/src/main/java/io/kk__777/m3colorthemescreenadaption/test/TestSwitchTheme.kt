package io.kk__777.m3colorthemescreenadaption.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.kk__777.library.StaticColorSourceTheme
import io.kk__777.m3colorthemescreenadaption.ui.theme.M3ColorThemeScreenAdaptionTheme
import java.util.Locale

const val samplePinkSeed = 0xFFFF1493
@Composable
fun TestSwitchColorThemes() {
    MaterialTheme
    M3ColorThemeScreenAdaptionTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = NavigationRoots.Root.root) {
            NavigationRoots.entries.forEach { roots ->
                composable(roots.root) { roots.Content(screenNavController = navController)}
            }
        }
    }
}

enum class NavigationRoots(val root: String) {
    Root("root") {
        @Composable
        override fun Content(screenNavController: NavController) {
            greetingM3ColorTheme {
                Greeting(route = this, screenNavController = screenNavController)
            }
        }
    },
    Blue("blue") {
        @Composable
        override fun Content(screenNavController: NavController) {
            M3ColorThemeScreenAdaptionTheme(
                lightColorScheme = BlueLightColors,
                darkColorScheme = BlueDarkColors
            ) {
                Greeting(route = this, screenNavController = screenNavController)
            }
        }
    },
    Yellow("yellow") {
        @Composable
        override fun Content(screenNavController: NavController) {
            M3ColorThemeScreenAdaptionTheme(
                lightColorScheme = YellowLight,
                darkColorScheme = YellowDark
            ) {
                Greeting(route = this, screenNavController = screenNavController)
            }
        }
    },
    Pink("pink") {
        @Composable
        override fun Content(screenNavController: NavController) {
            M3ColorThemeScreenAdaptionTheme(
                lightColorScheme = PinkLightColors,
                darkColorScheme = PinkDarkColors
            ) {
                Greeting(route = this, screenNavController = screenNavController)
            }
        }
    };

    @Composable
    abstract fun Content(screenNavController: NavController)

}

@StaticColorSourceTheme(
    name = "greeting",
    rgbColor = 0xFFFF1493,
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(
    route: NavigationRoots,
    screenNavController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = route.name.uppercase(Locale.ROOT)) }) },
            bottomBar = {
                var selectedItem by remember { mutableStateOf(route) }
                NavigationBar {
                    NavigationRoots.entries.forEach { item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = ""
                                )
                            },
                            selected = selectedItem == item,
                            onClick = { selectedItem = item }
                        )
                    }
                }
            },
            snackbarHost = {},
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            },
        ) {
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .padding(it)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        IconButton(
                            onClick = {
                                val entries = NavigationRoots.entries
                                screenNavController.navigate(
                                    entries[try {
                                        entries.indexOf(route) + 1
                                    } catch (e: Exception) {
                                        0
                                    }].root
                                )
                            },
                            modifier = Modifier.align(Alignment.CenterEnd)
                        ) {
                            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                        }
                    }
                }

                item {
                    Card(
                        Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(24.dp)
                                .fillMaxWidth()
                        ) {
                            Text(text = "Title", style = MaterialTheme.typography.headlineMedium)
                            Text(text = "SubTitle", style = MaterialTheme.typography.headlineSmall)
                            Text(
                                style = MaterialTheme.typography.bodyMedium,
                                text = "bodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybodybody"
                            )
                        }
                    }
                }

                item {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        item {
                            FilledTonalButton(onClick = { }) {
                                Text(text = "FilledTonalButton")
                            }
                            OutlinedButton(onClick = { }) {
                                Text(text = "OutlinedButton")
                            }
                            Button(onClick = { }) {
                                Text(text = "Button")
                            }
                            TextButton(onClick = { }) {
                                Text(text = "TextButton")
                            }
                        }
                    }
                }

                item {
                    var state by remember { mutableStateOf(0) }
                    val titles = listOf("Tab 1", "Tab 2", "Tab 3 with lots of text")
                    Column {
                        PrimaryTabRow(selectedTabIndex = state) {
                            titles.forEachIndexed { index, title ->
                                Tab(
                                    selected = state == index,
                                    onClick = { state = index },
                                    text = {
                                        Text(
                                            text = title,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                )
                            }
                        }
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = "Text tab ${state + 1} selected",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                item {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        item {
                            AssistChip(
                                onClick = { /* Do something! */ },
                                label = { Text("Assist Chip") },
                                leadingIcon = {
                                    Icon(
                                        Icons.Filled.Settings,
                                        contentDescription = "Localized description",
                                        Modifier.size(AssistChipDefaults.IconSize)
                                    )
                                }
                            )
                        }

                        item {
                            ElevatedAssistChip(
                                onClick = { /* Do something! */ },
                                label = { Text("Assist Chip") },
                                leadingIcon = {
                                    Icon(
                                        Icons.Filled.Settings,
                                        contentDescription = "Localized description",
                                        Modifier.size(AssistChipDefaults.IconSize)
                                    )
                                }
                            )
                        }

                        item {
                            var selected by remember { mutableStateOf(false) }
                            FilterChip(
                                selected = selected,
                                onClick = { selected = !selected },
                                label = { Text("Filter chip") },
                                leadingIcon = if (selected) {
                                    {
                                        Icon(
                                            imageVector = Icons.Filled.Done,
                                            contentDescription = "Localized Description",
                                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                                        )
                                    }
                                } else {
                                    null
                                }
                            )
                        }

                        item {
                            var selected by remember { mutableStateOf(false) }
                            InputChip(
                                selected = selected,
                                onClick = { selected = !selected },
                                label = { Text("Input Chip") },
                            )
                        }
                    }
                }
                item {
                    (0..10).forEach {
                        ListItem(
                            headlineContent = {
                                Text(text = "ListItem $it")
                            }
                        )
                    }
                }
            }
        }
    }
}