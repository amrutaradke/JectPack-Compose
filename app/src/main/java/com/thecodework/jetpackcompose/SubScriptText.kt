package com.thecodework.jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit

@Composable
fun SubScriptText(
  normalText: String,
  normalTextFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
  superText: String,
  superTextFontSize: TextUnit = MaterialTheme.typography.overline.fontSize,
  superTextFontWeight: FontWeight = FontWeight.Normal

) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White),
    contentAlignment = Alignment.Center
  ){
    Text(text = buildAnnotatedString{
      withStyle(
        style = SpanStyle(
          fontSize = normalTextFontSize
        )
      ) {
        append(normalText)
      }
      withStyle(
        style = SpanStyle(
          fontSize = superTextFontSize,
          fontWeight = superTextFontWeight,
          baselineShift = BaselineShift.Subscript
        )
      ) {
        append(superText)
      }
    })

  }
}

@Composable
@Preview
fun SubScriptTextPreview() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White)
  ) {
    SubScriptText(normalText = "Amruta",  superText = "Radke" )
  }
}