package com.jesil.animequest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jesil.animequest.R

val Andika = FontFamily(
    Font(
       resId = R.font.andika,
       weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.andika_bold,
        weight = FontWeight.SemiBold
    ),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = Andika,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Andika,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
)