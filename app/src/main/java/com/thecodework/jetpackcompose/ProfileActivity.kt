package com.thecodework.jetpackcompose


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

  @Composable
  fun ProfileActivity() {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray),
      contentAlignment = Alignment.Center
    ) {
      var value by remember {
        mutableStateOf(0)
      }
      
      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        CicularProgressComponent(indicatorValue = value)

        TextField(
          value = value.toString(),
          onValueChange = {
            value = if (it.isNotEmpty()) {
              it.toInt()
            } else {
              0
            }
          },
          keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
          )
        )
      }
    }
  }
@Preview
@Composable
fun DefaultProfilePreview() {
  ProfileActivity()

}