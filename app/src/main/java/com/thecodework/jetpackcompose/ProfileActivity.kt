package com.thecodework.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class ProfileActivity: ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TextCard()
      BackPressHandler() {

      }
    }
  }
  @Composable
  fun BackPressHandler(
    backPressedDispatcher: OnBackPressedDispatcher? =
      LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
    onBackPressed: () -> Unit
  ) {
    val currentOnBackPressed by rememberUpdatedState(newValue = onBackPressed)

    val backCallback = remember {
      object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
          currentOnBackPressed()
        }
      }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
      backPressedDispatcher?.addCallback(backCallback)

      onDispose {
        backCallback.remove()
      }
    }
  }
  @Composable
  fun DetailTopAppBar(onBack: () -> Unit) {
    TopAppBar(
      title = { Text(text = stringResource(id = R.string.profile)) },
      navigationIcon = {
        IconButton(onClick = onBack) {
          Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back),
          )
        }
      }
    )
  }
  @Composable
  fun TextCard(){

    val paddingModifier = Modifier.padding(top = 30.dp)
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
      Text(
        text = "Profile Page",
        modifier = paddingModifier
      )

//        Text(text = "Text with card custom color",
//          color = Color.Black,
//          modifier = paddingModifier)


    }
  }
}