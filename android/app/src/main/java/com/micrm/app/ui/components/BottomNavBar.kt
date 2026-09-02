package com.micrm.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.micrm.app.ui.theme.PureBlack
import com.micrm.app.ui.theme.PureWhite
import com.micrm.app.ui.theme.AppleGrey
import com.micrm.app.ui.theme.DarkSurface

@Composable
fun PillBottomNavBar() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .clip(RoundedCornerShape(50))
                .background(PureBlack)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            NavItem(Icons.Default.Home, "Inicio", selectedIndex == 0) { selectedIndex = 0 }
            NavItem(Icons.Default.Person, "Contactos", selectedIndex == 1) { selectedIndex = 1 }
            NavItem(Icons.Default.CheckCircle, "Tareas", selectedIndex == 2) { selectedIndex = 2 }
            NavItem(Icons.Default.Settings, "Ajustes", selectedIndex == 3) { selectedIndex = 3 }
        }
    }
}

@Composable
fun NavItem(icon: ImageVector, label: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(if (isSelected) PureWhite else Color.Transparent)
            .clickable { onClick() }
            .padding(horizontal = if (isSelected) 16.dp else 12.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (isSelected) PureBlack else AppleGrey,
                modifier = Modifier.size(24.dp)
            )
            if (isSelected) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = label,
                    color = PureBlack,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}
