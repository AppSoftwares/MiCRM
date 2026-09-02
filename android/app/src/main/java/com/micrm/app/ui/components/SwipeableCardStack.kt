package com.micrm.app.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun <T> SwipeableCardStack(
    items: List<T>,
    modifier: Modifier = Modifier,
    onSwipe: (T) -> Unit,
    cardContent: @Composable (T, Boolean) -> Unit
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    
    if (currentIndex >= items.size) return

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        // Show up to 3 cards in the stack
        for (i in (currentIndex + 2 downTo currentIndex)) {
            if (i >= items.size) continue
            
            val isFront = i == currentIndex
            val offsetVertical = (i - currentIndex) * 16
            
            if (isFront) {
                val offsetX = remember { Animatable(0f) }
                
                Box(
                    modifier = Modifier
                        .offset { IntOffset(offsetX.value.roundToInt(), offsetVertical) }
                        .graphicsLayer {
                            rotationZ = offsetX.value / 20
                        }
                        .pointerInput(Unit) {
                            detectHorizontalDragGestures(
                                onDragEnd = {
                                    if (kotlin.math.abs(offsetX.value) > 400) {
                                        scope.launch {
                                            offsetX.animateTo(
                                                targetValue = if (offsetX.value > 0) 1000f else -1000f,
                                                animationSpec = tween(300)
                                            )
                                            onSwipe(items[currentIndex])
                                            currentIndex++
                                            offsetX.snapTo(0f)
                                        }
                                    } else {
                                        scope.launch {
                                            offsetX.animateTo(0f, tween(300))
                                        }
                                    }
                                },
                                onHorizontalDrag = { change, dragAmount ->
                                    change.consume()
                                    scope.launch {
                                        offsetX.snapTo(offsetX.value + dragAmount)
                                    }
                                }
                            )
                        }
                ) {
                    cardContent(items[i], true)
                }
            } else {
                Box(
                    modifier = Modifier
                        .padding(top = offsetVertical.dp)
                        .graphicsLayer {
                            scaleX = 1f - (i - currentIndex) * 0.05f
                            scaleY = 1f - (i - currentIndex) * 0.05f
                        }
                ) {
                    cardContent(items[i], false)
                }
            }
        }
    }
}
