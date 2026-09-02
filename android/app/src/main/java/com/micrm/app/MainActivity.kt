package com.micrm.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.getcapacitor.BridgeActivity
import com.micrm.app.ui.components.PillBottomNavBar
import com.micrm.app.ui.screens.DashboardScreen
import com.micrm.app.ui.theme.MiCRMTheme
import com.micrm.app.ui.theme.PureBlack

class MainActivity : BridgeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // We set content using Compose for the Premium UI
        // Capacitor bridge is still available in the background if needed for other features
        setContent {
            MiCRMTheme {
                Scaffold(
                    bottomBar = { PillBottomNavBar() },
                    containerColor = PureBlack
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                        DashboardScreen()
                    }
                }
            }
        }
    }
}
