package io.kk__777.m3colorthemescreenadaption

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.kk__777.m3colorthemescreenadaption.test.TestSwitchColorThemes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestSwitchColorThemes()
        }
    }
}