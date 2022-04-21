package com.thecodework.jetpackcompose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thecodework.jetpackcomposefirstapp.Data.ItemData

@Composable
  fun HomeScreen() {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(Color.Green),
      contentAlignment = Alignment.Center
    ) {
//      Text(
//        text = "Home Page",
//        fontSize = MaterialTheme.typography.h3.fontSize,
//        fontWeight = FontWeight.Bold,
//        color = Color.White
//      )
      val itemRepository = ItemData
      val getAllData = itemRepository.list

      LazyColumn(contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)){
        itemsIndexed(items = getAllData){
            index,itemName ->
          Log.d("MainActivity", index.toString())
          ItemCard(itemName = itemName)
        }
      }
    }
  }
  @Preview
  @Composable
  fun DefaultHomePreview() {
    HomeScreen()

  }
