package com.ashehata.bosta_task.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ashehata.bosta_task.modules.profile.presentation.ProfileScreen
import com.ashehata.bosta_task.ui.theme.AppTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                ProfileScreen()
            }
        }
    }
}