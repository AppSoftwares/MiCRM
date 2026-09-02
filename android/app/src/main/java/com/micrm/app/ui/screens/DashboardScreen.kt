package com.micrm.app.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.micrm.app.ui.theme.*

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PureBlack)
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
            text = "KPIs",
            style = MaterialTheme.typography.labelSmall,
            color = AppleGrey
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        KPICards()
        
        Spacer(modifier = Modifier.height(40.dp))
        
        RevenueChartSection()
        
        Spacer(modifier = Modifier.height(40.dp))
        
        ContactSummarySection()
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(DarkSurface)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Row {
                Text(text = "Hola, ", color = PureWhite, style = MaterialTheme.typography.bodyLarge)
                Text(text = "Vendedor", color = PureWhite, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
            }
            Text(text = "Mi cartera", color = AppleGrey, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
fun KPICards() {
    // This would use SwipeableCardStack in a real implementation
    // For now, showing the primary card style
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BrushedMetalGradient)
                .padding(24.dp)
        ) {
            Column(modifier = Modifier.align(Alignment.BottomStart)) {
                Text(text = "TOTAL VENTAS", style = MaterialTheme.typography.labelSmall, color = AppleGrey)
                Text(text = "$125,400.00", style = MaterialTheme.typography.headlineLarge, color = PureWhite)
                Text(text = "12 cerradas", style = MaterialTheme.typography.labelSmall, color = AppleGrey)
            }
        }
    }
}

@Composable
fun RevenueChartSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(DarkSurface)
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Ingresos", color = PureWhite, style = MaterialTheme.typography.labelMedium)
            Text(text = "Últimos 6 meses", color = AppleGrey, style = MaterialTheme.typography.labelSmall)
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        MinimalistLineChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )
    }
}

@Composable
fun MinimalistLineChart(modifier: Modifier) {
    Canvas(modifier = modifier) {
        val path = Path().apply {
            moveTo(0f, size.height * 0.8f)
            quadraticTo(size.width * 0.2f, size.height * 0.7f, size.width * 0.4f, size.height * 0.4f)
            quadraticTo(size.width * 0.6f, size.height * 0.2f, size.width * 0.8f, size.height * 0.5f)
            lineTo(size.width, size.height * 0.3f)
        }
        
        val fillPath = Path().apply {
            addPath(path)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        
        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(PureWhite.copy(alpha = 0.2f), Color.Transparent)
            )
        )
        
        drawPath(
            path = path,
            color = PureWhite,
            style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
        )
    }
}

@Composable
fun ContactSummarySection() {
    Column {
        Text(text = "Resumen de contactos", style = MaterialTheme.typography.labelSmall, color = AppleGrey)
        Spacer(modifier = Modifier.height(16.dp))
        
        // Placeholder for categories card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = DarkSurface)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                ContactCategoryItem("Leads", 12)
                ContactCategoryItem("Interesados", 8)
                ContactCategoryItem("Ventas", 45)
            }
        }
    }
}

@Composable
fun ContactCategoryItem(label: String, count: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(PureWhite))
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = label, color = PureWhite, style = MaterialTheme.typography.bodyMedium)
        }
        Text(text = count.toString(), color = PureWhite, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
    }
}
