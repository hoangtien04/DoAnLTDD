package com.example.doanltdd.Screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.doanltdd.NavRoute
import com.example.doanltdd.Product

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePageScreen(navController: NavHostController) {
    val productList = listOf(
        Product(com.example.doanltdd.R.drawable.product_image_1, "Áo len nam", "Thời trang thu đông"),
        Product(com.example.doanltdd.R.drawable.product_image_2, "Áo hoodie", "Phong cách trẻ trung"),
        Product(com.example.doanltdd.R.drawable.product_image_3, "Áo khoác dạ", "Thời thượng và ấm áp"),
        Product(com.example.doanltdd.R.drawable.product_image_4, "Áo sơ mi", "Lịch sự, sang trọng")
    )

    val pagerState = rememberPagerState { productList.size }

    Box(modifier = Modifier.fillMaxSize()) {
        VerticalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) { page ->
            val product = productList[page]
            // Bọc ProductCard bằng clickable để điều hướng
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.White)
                    .clip(CircleShape)
                    .border(1.dp, Color.Black, CircleShape)
                    .clickable {
                        navController.navigate("${NavRoute.PRODUCTDETAIL_SCREEN.route}?id=$page")
                    }
            ) {
                ProductCard(product)
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 48.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Handle home button click */ },
                modifier = Modifier
                    .size(48.dp)
                    .shadow(4.dp, CircleShape)
                    .border(1.dp, color = Color.Black, shape = CircleShape)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(32.dp),
                )
            }
            Spacer(modifier = Modifier.width(60.dp))
            IconButton(
                onClick = { /* Handle home button click */ },
                modifier = Modifier
                    .size(68.dp)
                    .shadow(4.dp, CircleShape)
                    .border(1.dp, color = Color.Black, shape = CircleShape)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                Icon(Icons.Filled.Search, contentDescription = "Search", modifier = Modifier.size(32.dp))
            }
            Spacer(modifier = Modifier.width(60.dp))
            IconButton(
                onClick = { /* Handle home button click */ },
                modifier = Modifier
                    .size(48.dp)
                    .shadow(4.dp, CircleShape)
                    .border(1.dp, color = Color.Black, shape = CircleShape)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                Icon(Icons.Filled.Person, contentDescription = "Profile", modifier = Modifier.size(32.dp))
            }
        }
    }
}