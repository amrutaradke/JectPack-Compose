package com.thecodework.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.tiles.material.Button
import com.thecodework.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
     // Title()
      UserCard()
    }
//    setContent {
//      JetPackComposeTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(color = MaterialTheme.colors.background) {
//          Greeting("Android")
//        }
//      }
//    }
  }
}
//
//@Composable
//fun Greeting(name: String) {
//  Surface(modifier = Modifier.fillMaxSize()){
//    Text(text = "Hello $name!")
//  }
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//  JetPackComposeTheme {
//    Greeting("Amruta")
//  }
@Composable
fun UserCard(){
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .padding(12.dp)
      .border(width = 1.dp, color = Color.Gray)
      .padding(12.dp)
  ) {
    Image(
      painter = painterResource(id = R.drawable.ic_baseline_self_improvement_24),
      contentDescription = "",
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .size(120.dp)
        .clip(CircleShape)
    )
    Column {
      Text(text = stringResource(id = R.string.dummy_data))
      Button(onClick = {

      }) {
        Text(text = "View Profile")
      }
    }
  }
}
@Composable
fun Title(){
  var context = LocalContext.current
  Text(text = "Simplified Coding",
  fontSize = 32.sp,
    fontFamily = FontFamily.Cursive,
  color = colorResource(id = R.color.purple_700),
  modifier = Modifier.clickable {
    Toast.makeText(context, "Title Clickable", Toast.LENGTH_LONG)
  })
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
  Surface(Modifier.fillMaxSize()) {
    //Title()
    UserCard()
  }

}









