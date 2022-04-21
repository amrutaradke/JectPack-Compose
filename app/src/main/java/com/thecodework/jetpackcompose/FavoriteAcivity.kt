package com.thecodework.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

  @Composable
  fun FavoriteAcivity(){
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(Color.Red),
        contentAlignment = Alignment.Center) {
      Text(
        text = "Favorite Page",
        fontSize = MaterialTheme.typography.h3.fontSize,
        fontWeight = FontWeight.Bold,
        color = Color.White
      )
    }

}
@Preview
@Composable
fun DefaultFavoritePreview() {
  FavoriteAcivity()

}