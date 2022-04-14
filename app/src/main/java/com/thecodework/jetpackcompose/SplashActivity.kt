package com.thecodework.jetpackcompose

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      lifecycleScope.launchWhenCreated {
        delay(3000)

        val intent = Intent(this@SplashActivity, LoginScreen::class.java)
        startActivity(intent)
        finish()
      }
      setContent {
        ScreenSplash()
      }
    }


  @Composable
  fun ScreenSplash() {
    val context = LocalContext.current
    Column() {
      Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Image(modifier = Modifier.padding(bottom = 40.dp),
          painter = painterResource(id = R.drawable.ic_baseline_local_grocery_store_24),
          contentDescription = "Logo"
        )
        Text(modifier = Modifier.padding(top = 40.dp),
          text = "Welcome to Grocery Shop",
          fontSize = 32.sp,
          fontFamily = FontFamily.Cursive,
          color = colorResource(id = R.color.purple),
        )

       // context.startActivity(Intent(context, MainActivity::class.java))
      }

    }
  }


  @Preview(showBackground = true)
  @Composable
  fun DefaultPreview() {
      Surface(
        Modifier.fillMaxSize()
      ) {
        ScreenSplash()
      }
      //Greeting("to Grocery Shop")

  }
}