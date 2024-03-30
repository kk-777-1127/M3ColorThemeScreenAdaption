package io.kk__777.m3colorthemescreenadaption

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import io.kk__777.m3colorthemescreenadaption.test.TestSwitchColorThemes
import utils.ColorUtils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestSwitchColorThemes()
        }
    }
}