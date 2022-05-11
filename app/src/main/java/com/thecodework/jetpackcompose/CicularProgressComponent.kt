package com.thecodework.jetpackcompose

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.wear.tiles.material.CircularProgressIndicator

@Composable
fun CicularProgressComponent(
  canvasSize: Dp = 300.dp,
  indicatorValue: Int = 0,
  maxIndicatorValue: Int = 100,
  backgroundIndicatorColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
  foregroundIndicatorColor: Color = MaterialTheme.colors.primary,
  backgroundIndicatorStrokeWidth: Float = 100f,
  foregroundIndicatorStrokeWidth: Float = 100f
) {
  val animatedIndicatorValue = remember {
    Animatable(initialValue = 0f)
  }
  LaunchedEffect(key1 = indicatorValue) {
    animatedIndicatorValue.animateTo(indicatorValue.toFloat())
  }
  val percentage = (animatedIndicatorValue.value / maxIndicatorValue) * 100
  val sweepAngle by animateFloatAsState(
    targetValue = (2.4 * percentage).toFloat(),
    animationSpec = tween(1000))
  Column(modifier = Modifier
    .size(canvasSize)
    .drawBehind {
      val componentSize = size / 1.25f
      backgroundIndicator1(
        componentSize = componentSize,
        indicatorColor = backgroundIndicatorColor,
        indicatorStrokeWidth = backgroundIndicatorStrokeWidth
      )
      foregroundIndicator(
        sweepAngle = sweepAngle,
        componentSize = componentSize,
        indicatorColor = foregroundIndicatorColor,
        indicatorStrokeWidth = foregroundIndicatorStrokeWidth
      )
    }
    ) {

  }
}

fun DrawScope.backgroundIndicator1(
  componentSize: Size,
  indicatorColor: Color,
  indicatorStrokeWidth: Float
) {
  drawArc(
    size = componentSize,
    color = indicatorColor,
    startAngle = 150f,
    sweepAngle = 240f,
    useCenter = false,
    style = Stroke (
        width = indicatorStrokeWidth,
        cap = StrokeCap.Round
        ),
    topLeft = Offset (
      x = (size.width - componentSize.width) / 2f,
      y = (size.height - componentSize.height) / 2f
    )
  )
}

fun DrawScope.foregroundIndicator1(
  sweepAngle: Float,
  componentSize: Size,
  indicatorColor: Color,
  indicatorStrokeWidth: Float
) {
  drawArc(
    size = componentSize,
    color = indicatorColor,
    startAngle = 150f,
    sweepAngle = sweepAngle,
    useCenter = false,
    style = Stroke (
      width = indicatorStrokeWidth,
      cap = StrokeCap.Round
    ),
    topLeft = Offset (
      x = (size.width - componentSize.width) / 2f,
      y = (size.height - componentSize.height) / 2f
    )
  )
}

@Composable
@Preview(showBackground = true)
fun CircularProgressComponentPreview() {
  CicularProgressComponent()
}