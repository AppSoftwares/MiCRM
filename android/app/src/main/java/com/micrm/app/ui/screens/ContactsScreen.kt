package com.micrm.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.micrm.app.ui.theme.*

@Composable
fun ContactsScreen() {
    val categories = listOf(
        "Leads" to 12,
        "Comunicados" to 8,
        "Interesados" to 15,
        "Seguimientos" to 5,
        "Ventas" to 42
    )

    Scaffold(
        containerColor = PureBlack,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add contact */ },
                containerColor = PureWhite,
                contentColor = PureBlack,
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "Añadir contacto")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Contactos",
                    style = MaterialTheme.typography.headlineLarge,
                    color = PureWhite
                )
                IconButton(onClick = { /* Search */ }) {
                    Icon(Icons.Default.Search, contentDescription = "Buscar", tint = PureWhite)
                }
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(categories) { category ->
                    CategoryCard(category.first, category.second)
                }
            }
        }
    }
}

@Composable
fun CategoryCard(name: String, count: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Navigate to detail */ },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = name, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold, color = PureWhite)
                Text(text = "$count contactos", style = MaterialTheme.typography.labelSmall, color = AppleGrey)
            }
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = AppleGrey)
        }
    }
}
