package com.micrm.app.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush

// Obsidian Monolith Palette
val PureBlack = Color(0xFF000000)
val PureWhite = Color(0xFFFFFFFF)
val AppleGrey = Color(0xFF8E8E93)
val DarkSurface = Color(0xFF141414)
val MetalStart = Color(0xFF2A2A2E)
val MetalEnd = Color(0xFF101012)

val BrushedMetalGradient = Brush.radialGradient(
    colors = listOf(MetalStart, MetalEnd)
)

val CardBackground = Color(0xFF141414)
val BottomNavBackground = Color(0xFF000000)
val InactiveGrey = Color(0xFFC7C7CC)
