package io.kk__777.m3colorthemescreenadaption.test

import android.icu.text.SimpleDateFormat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.TimePicker
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import io.kk__777.m3colorthemescreenadaption.ui.theme.M3ColorThemeScreenAdaptionTheme
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Locale

@Composable
fun TestSwitchColorThemes() {
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
            M3ColorThemeScreenAdaptionTheme {
                SampleContent(route = this, screenNavController = screenNavController)
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
                SampleContent(route = this, screenNavController = screenNavController)
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
                SampleContent(route = this, screenNavController = screenNavController)
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
                SampleContent(route = this, screenNavController = screenNavController)
            }
        }
    };

    @Composable
    abstract fun Content(screenNavController: NavController)

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SampleContent(
    route: NavigationRoots,
    screenNavController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        var openDialog by remember { mutableStateOf(false) }

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
                            onClick = {
                                selectedItem = item
                                screenNavController.navigate(item.root) {
                                    navOptions {
                                        launchSingleTop = true
                                    }
                                }
                            }
                        )
                    }
                }
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(onClick = {
                    openDialog = true
                }) {
                    Column {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                        Text(text = "Open Dialog")
                    }
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
                    var showTimePicker by remember { mutableStateOf(false) }
                    val state = rememberTimePickerState()
                    val formatter = remember { SimpleDateFormat("hh:mm a", Locale.getDefault()) }
                    val snackState = remember { SnackbarHostState() }
                    val snackScope = rememberCoroutineScope()

                    Box(propagateMinConstraints = false) {
                        Button(
                            modifier = Modifier.align(Alignment.Center),
                            onClick = { showTimePicker = true }
                        ) {
                            Text("Set Time")
                        }
                        SnackbarHost(hostState = snackState)
                    }

                    if (showTimePicker) {
                        TimePickerDialog(
                            onCancel = { showTimePicker = false },
                            onConfirm = {
                                val cal = Calendar.getInstance()
                                cal.set(Calendar.HOUR_OF_DAY, state.hour)
                                cal.set(Calendar.MINUTE, state.minute)
                                cal.isLenient = false
                                snackScope.launch {
                                    snackState.showSnackbar("Entered time: ${formatter.format(cal.time)}")
                                }
                                showTimePicker = false
                            },
                        ) {
                            TimePicker(state = state)
                        }
                    }
                }

                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
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

                item {
                    var state by remember { mutableIntStateOf(0) }
                    val titles = listOf("Primary", "Secondary", "Tertiary")
                    val pagerState = rememberPagerState { titles.size }
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
                        HorizontalPager(state = pagerState) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .background(
                                        when (it) {
                                            0 -> MaterialTheme.colorScheme.primary
                                            1 -> MaterialTheme.colorScheme.secondary
                                            else -> MaterialTheme.colorScheme.tertiary
                                        }
                                    )
                            )
                        }
                    }
                }

                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
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
                        var selected2 by remember { mutableStateOf(false) }
                        InputChip(
                            selected = selected2,
                            onClick = { selected2 = !selected2 },
                            label = { Text("Input Chip") },
                        )
                    }
                }

                item {
                    val checkedState = remember { mutableStateOf(true) }
                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it }
                    )
                }

                item {
                    TooltipBox(
                        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                        tooltip = {
                            PlainTooltip {
                                Text("Add to favorites")
                            }
                        },
                        state = rememberTooltipState()
                    ) {
                        IconButton(
                            onClick = { /* Icon button's click event */ }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Localized Description"
                            )
                        }
                    }
                }

                item {
                    val options = listOf("Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread")
                    var expanded by remember { mutableStateOf(false) }
                    var text by remember { mutableStateOf(options[0]) }

                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = it },
                    ) {
                        TextField(
                            // The `menuAnchor` modifier must be passed to the text field for correctness.
                            modifier = Modifier.menuAnchor(),
                            value = text,
                            onValueChange = {},
                            readOnly = true,
                            singleLine = true,
                            label = { Text("Label") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            options.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option, style = MaterialTheme.typography.bodyLarge) },
                                    onClick = {
                                        text = option
                                        expanded = false
                                    },
                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                                )
                            }
                        }
                    }
                }

                item {
                    var progress by remember { mutableStateOf(0.1f) }
                    val animatedProgress by animateFloatAsState(
                        targetValue = progress,
                        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        LinearProgressIndicator(
                            progress = { animatedProgress },
                        )
                        Spacer(Modifier.requiredHeight(30.dp))
                        Text("Set progress:")
                        Slider(
                            modifier = Modifier.width(300.dp),
                            value = progress,
                            valueRange = 0f..1f,
                            onValueChange = { progress = it },
                        )
                    }
                }

                item {
                    // We have two radio buttons and only one can be selected
                    var state by remember { mutableStateOf(true) }
                    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior.
                    // We also set a content description for this sample, but note that a RadioButton would usually
                    // be part of a higher level component, such as a raw with text, and that component would need
                    // to provide an appropriate content description. See RadioGroupSample.
                    Row(Modifier.selectableGroup()) {
                        RadioButton(
                            selected = state,
                            onClick = { state = true },
                            modifier = Modifier.semantics { contentDescription = "Localized Description" }
                        )
                        RadioButton(
                            selected = !state,
                            onClick = { state = false },
                            modifier = Modifier.semantics { contentDescription = "Localized Description" }
                        )
                    }
                }

                item {
                    var expanded by remember { mutableStateOf(false) }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.TopStart)
                    ) {
                        IconButton(onClick = { expanded = true }) {
                            Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Edit") },
                                onClick = { /* Handle edit! */ },
                                leadingIcon = {
                                    Icon(
                                        Icons.Outlined.Edit,
                                        contentDescription = null
                                    )
                                })
                            DropdownMenuItem(
                                text = { Text("Settings") },
                                onClick = { /* Handle settings! */ },
                                leadingIcon = {
                                    Icon(
                                        Icons.Outlined.Settings,
                                        contentDescription = null
                                    )
                                })
                            HorizontalDivider()
                            DropdownMenuItem(
                                text = { Text("Send Feedback") },
                                onClick = { /* Handle send feedback! */ },
                                leadingIcon = {
                                    Icon(
                                        Icons.Outlined.Email,
                                        contentDescription = null
                                    )
                                },
                                trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
                        }
                    }
                }

                item {
                    Card(
                        Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surfaceDim)
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

        if (openDialog) {
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onDismissRequest.
                    openDialog = false
                },
                title = {
                    Text(text = "Title")
                },
                text = {
                    Text(text = "Turned on by default")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog = false
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog = false
                        }
                    ) {
                        Text("Dismiss")
                    }
                }
            )
        }
    }
}


@Composable
fun TimePickerDialog(
    title: String = "Select Time",
    onCancel: () -> Unit,
    onConfirm: () -> Unit,
    toggle: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onCancel,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = MaterialTheme.colorScheme.surface
                ),
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.labelMedium
                )
                content()
                Row(modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                ) {
                    toggle()
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = onCancel) {
                        Text("Cancel")
                    }
                    TextButton(onClick = onConfirm) {
                        Text("OK")
                    }
                }
            }
        }
    }
}