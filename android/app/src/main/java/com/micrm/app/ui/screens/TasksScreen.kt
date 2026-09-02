package com.micrm.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.micrm.app.data.entity.TaskEntity
import com.micrm.app.ui.components.SwipeableCardStack
import com.micrm.app.ui.theme.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TasksScreen(tasks: List<TaskEntity>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PureBlack)
            .padding(24.dp)
    ) {
        Text(
            text = "Tareas",
            style = MaterialTheme.typography.headlineMedium,
            color = PureWhite
        )
        
        Spacer(modifier = Modifier.height(40.dp))
        
        SwipeableCardStack(
            items = tasks,
            onSwipe = { /* Mark as completed or just move */ }
        ) { task, isFront ->
            TaskCard(task, isFront)
        }
    }
}

@Composable
fun TaskCard(task: TaskEntity, isFront: Boolean) {
    val backgroundColor = if (isFront) PureWhite else DarkSurface
    val contentColor = if (isFront) PureBlack else PureWhite
    val secondaryColor = if (isFront) PureBlack.copy(alpha = 0.6f) else AppleGrey
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = task.titulo,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = contentColor
                )
                Text(
                    text = task.fechaVencimiento.format(DateTimeFormatter.ofPattern("dd MMM")),
                    style = MaterialTheme.typography.labelSmall,
                    color = secondaryColor
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Seguimiento con el cliente sobre la propuesta enviada el lunes.",
                style = MaterialTheme.typography.bodyMedium,
                color = secondaryColor
            )
            
            if (isFront) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { /* Mark completed */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PureBlack),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(text = "✓ Tarea realizada", color = PureWhite, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
