package com.micrm.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.micrm.app.data.entity.EtapaPipeline
import com.micrm.app.ui.theme.*

@Composable
fun PipelineScreen() {
    val etapas = EtapaPipeline.values()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PureBlack)
            .padding(top = 24.dp)
    ) {
        Text(
            text = "Pipeline",
            style = MaterialTheme.typography.headlineMedium,
            color = PureWhite,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(etapas) { etapa ->
                PipelineColumn(etapa)
            }
        }
    }
}

@Composable
fun PipelineColumn(etapa: EtapaPipeline) {
    Column(
        modifier = Modifier
            .width(280.dp)
            .fillMaxHeight()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = etapa.name,
                style = MaterialTheme.typography.labelMedium,
                color = PureWhite
            )
            Spacer(modifier = Modifier.width(8.dp))
            Badge(containerColor = DarkSurface, contentColor = AppleGrey) {
                Text("2")
            }
        }
        
        // Placeholder cards
        DealCard("Proyecto Alpha", "Empresa X", "$12,000")
        Spacer(modifier = Modifier.height(12.dp))
        DealCard("Servicio Web", "Cliente Y", "$5,500")
    }
}

@Composable
fun DealCard(titulo: String, empresa: String, monto: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = titulo, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = PureWhite)
            Text(text = empresa, style = MaterialTheme.typography.labelSmall, color = AppleGrey)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = monto, color = PureWhite, fontWeight = FontWeight.Bold)
                Badge(containerColor = PureWhite.copy(alpha = 0.1f), contentColor = PureWhite) {
                    Text("70%")
                }
            }
        }
    }
}
