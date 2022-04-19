package com.thecodework.jetpackcompose

import android.content.Intent
import android.graphics.Color
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay

class LoginScreen : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      loginScreen()
      }
    }

  @Composable
  fun loginScreen(){
    Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colors.background){
      Column (modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        TitleText()
        LoginImage()
        text_field(InputType = KeyboardType.Email,"E-mail address",IconImage = painterResource(id = R.drawable.ic_email))
        SignIn()
        ForgotPasswordText()
      }
    }
  }
  @Composable
  fun TitleText(){
    Text(text = "Login",
      color = Blue,
      fontSize = 25.sp,
      modifier = Modifier.padding(top = 40.dp)
    )
  }
  @Composable
  fun LoginImage(){
    Image(painter = painterResource(id = R.drawable.ic_baseline_self), contentDescription = "welcome",
      modifier = Modifier.size(300.dp))
  }

  @Composable
  fun text_field(InputType : KeyboardType, placeholder : String, IconImage : Painter){
    var TextFieldEmailState = remember{mutableStateOf("")}

    TextField(value = TextFieldEmailState.value,
      onValueChange = { newInput -> TextFieldEmailState.value = newInput },
      leadingIcon = {
        Image(painter = painterResource(id =  R.drawable.ic_email), contentDescription = "email")
      },
      label = {Text(text = "E-mail address",color = MaterialTheme.colors.onPrimary)},
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
      modifier = Modifier
        .padding(top = 25.dp)
        .background(color = MaterialTheme.colors.background)
    )
    var TextFieldPasswordState = remember{mutableStateOf("")}
    TextField(value = TextFieldPasswordState.value,
      onValueChange = { newInput -> TextFieldPasswordState.value = newInput },
      leadingIcon = {Image(painter = painterResource(id = R.drawable.ic_password), contentDescription = "password")},
      label = {Text(text = "Password",color = MaterialTheme.colors.onPrimary)},
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
      modifier = Modifier
        .padding(top = 25.dp)
        .background(color = MaterialTheme.colors.background)
    )
  }
  @Composable
  fun SignIn(){
    Button(onClick = {
      val intent = Intent(this@LoginScreen, DummyActivity::class.java)
      startActivity(intent)
      finish()

    },modifier = Modifier
      .padding(top = 25.dp)
      .requiredWidth(277.dp)){
      Text(text = "Sign In")
    }
  }
  @Composable
  fun ForgotPasswordText(){
    Text(text = "Forgot Password ?",color = Blue,
      modifier = Modifier.padding(top = 70.dp))
  }
  @Preview(showBackground = true)
  @Composable
  fun DefaultPreview() {
      loginScreen()

  }
}