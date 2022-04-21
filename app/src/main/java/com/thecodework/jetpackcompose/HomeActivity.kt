package com.thecodework.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.thecodework.jetpackcomposefirstapp.Data.ItemData
import com.thecodework.jetpackcomposefirstapp.Data.ItemName
import android.R
import android.view.View
import android.widget.Toast

import androidx.annotation.NonNull
import androidx.compose.ui.input.key.Key.Companion.Home

import com.google.android.material.bottomnavigation.BottomNavigationView




class HomeActivity: ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      ScaffoldWithBottomMenu()
     HomeContent()

    }
  }
  @Composable
  fun TopBar() {
//    TopAppBar(
//      title = {
//                Image(painter = painterResource(id = R.drawable.ic_arr), contentDescription ="Icon" )
//        Text(text = stringResource(R.string.app_name), fontSize = 18.sp)
//              },
//      backgroundColor = colorResource(id = R.color.purple_500),
//      contentColor = Color.White
//    )
  }
  @Composable
  fun ScaffoldWithBottomMenu() {
    Scaffold(
      bottomBar = {BottomBar()},
      topBar = {TopBar()}

    ) {
      //content area
      Box(modifier = Modifier
        .background(Color(0xff546e7a))
        .fillMaxSize())
    }
  }

  @Composable
  fun HomeContent() {
    LazyColumn(
     // contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ) {
      items(items = ItemData.list, itemContent = { ItemName ->
        ItemCard(ItemName)

      })
    }
  }
  @Composable
  private fun ItemCard(itemName: ItemName) {
    Card(
      modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .fillMaxWidth(),
      elevation = 2.dp,
      shape = RoundedCornerShape(16.dp),
      backgroundColor = Color.White,
      //modifier = Modifier.padding(10.dp).width(180.dp)
    ) {
      Row {
        Image(
          painter = painterResource(id = itemName.image),
          contentDescription = null,
          modifier = Modifier.size(100.dp),
        )
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        ) {

          Row(modifier = Modifier.padding(top = 20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = itemName.name,
                style = TextStyle(
                  color = Color.Gray,
                  fontSize = 16.sp
                )
              )
              Text(
                text = itemName.price,
                style = TextStyle(
                  color = Color.Gray,
                  fontSize = 16.sp
                )
              )
            }
            IconButton(
              onClick = { },
              modifier = Modifier.background(
                color = Color.Blue,
                shape = RoundedCornerShape(10.dp)
              )
            ) {
              Icon(Icons.Default.Add, tint = Color.White, contentDescription = null)
            }
          }
        }
      }
        }
      }

  @Composable
  fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp) {

      BottomNavigationItem(icon = {
        Icon(imageVector = Icons.Default.Home,"")
      },
        label = { Text(text = "Home") },
        selected = (selectedIndex.value == 0),
        onClick = {
          selectedIndex.value = 0
          Toast.makeText(this@HomeActivity,"This is Home page",Toast.LENGTH_LONG).show()
        })

      BottomNavigationItem(icon = {
        Icon(imageVector = Icons.Default.Favorite,"")
      },
        label = { Text(text = "Favorite") },
        selected = (selectedIndex.value == 1),
        onClick = {
          selectedIndex.value = 1
          Toast.makeText(this@HomeActivity,"This is favorite page",Toast.LENGTH_LONG).show()
//          val intent = Intent(this@HomeActivity, FavoriteAcivity::class.java)
//          startActivity(intent)
//          finish()
        })

      BottomNavigationItem(icon = {
        Icon(imageVector = Icons.Default.Person,"")
      },
        label = { Text(text = "Profile") },
        selected = (selectedIndex.value == 2),
        onClick = {
          selectedIndex.value = 2
          val intent = Intent(this@HomeActivity, HomeActivity::class.java)
          startActivity(intent)
          finish()
          Toast.makeText(this@HomeActivity,"This is profile page",Toast.LENGTH_LONG).show()
        })

      }
    }
}

