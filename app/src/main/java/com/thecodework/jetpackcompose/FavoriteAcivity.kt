package com.thecodework.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class FavoriteAcivity: ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
       TextCard()
    }
  }
  @Composable
  fun TextCard(){

    val paddingModifier = Modifier.padding(top = 30.dp)
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(
          text = "Favorite Page",
          modifier = paddingModifier
        )
//        Text(text = "Text with card custom color",
//          color = Color.Black,
//          modifier = paddingModifier)


    }
  }
}