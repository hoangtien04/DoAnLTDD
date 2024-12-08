package com.example.doanltdd

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.doanltdd.Screen.HomePageScreen
import com.example.doanltdd.Screen.ProductDetailScreen

sealed class NavRoute(val route:String){
    object HOMEPAGE_SCREEN:NavRoute("homepage")
    object PRODUCTDETAIL_SCREEN:NavRoute("productdetail")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    val productList = listOf(
        Product(com.example.doanltdd.R.drawable.product_image_1, "Áo len nam", "Thời trang thu đông"),
        Product(com.example.doanltdd.R.drawable.product_image_2, "Áo hoodie", "Phong cách trẻ trung"),
        Product(com.example.doanltdd.R.drawable.product_image_3, "Áo khoác dạ", "Thời thượng và ấm áp"),
        Product(com.example.doanltdd.R.drawable.product_image_4, "Áo sơ mi", "Lịch sự, sang trọng")
    )

    NavHost(
        navController = navController,
        startDestination = NavRoute.HOMEPAGE_SCREEN.route
    ) {
        composable(NavRoute.HOMEPAGE_SCREEN.route) {
            HomePageScreen(navController = navController)
        }
        composable(
            NavRoute.PRODUCTDETAIL_SCREEN.route + "?id={id}",
            arguments = listOf(navArgument("id") { nullable = true })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (id != null) {
                ProductDetailScreen(navController, product = productList[id])
            }
        }
    }
}