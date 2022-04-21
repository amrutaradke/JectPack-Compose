package com.thecodework.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.tiles.LayoutElementBuilders
import com.thecodework.jetpackcomposefirstapp.Data.ItemData
import com.thecodework.jetpackcomposefirstapp.Data.ItemName

@Composable
fun CustomItem(itemName: ItemName){
  Row(
    modifier = Modifier
      .background(Color.LightGray)
      .fillMaxWidth()
      .padding(24.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    Text(
      text = "itemName.name",
      color = Color.Black,
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold
    )
    Text(
      text = "${itemName.price}",
      color = Color.Black,
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold
    )
    IconButton(
      onClick = { },
      modifier = Modifier.background(
        color = Color.Blue,
        shape = RoundedCornerShape(10.dp))
      ){
        Icon(Icons.Default.Add, tint = Color.White, contentDescription = null)
      }
  }
}
@Composable
fun ItemCard(itemName: ItemName) {
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