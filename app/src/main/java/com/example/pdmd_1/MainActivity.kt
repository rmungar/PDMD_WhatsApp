package com.example.pdmd_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pdmd_1.navigation.AppNavigation
import com.example.pdmd_1.ui.theme.PDMD_1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PDMD_1Theme {

                AppNavigation()
            }
        }
    }
}


