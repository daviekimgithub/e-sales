package com.josephnganga.eshop.navigation // ktlint-disable package-name

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.josephnganga.eshop.ui.screens.auth.SignInRoute
import com.josephnganga.eshop.ui.screens.auth.SignUpRoute
import com.josephnganga.eshop.ui.screens.cart.CartRoute
import com.josephnganga.eshop.ui.screens.detail.DetailRoute
import com.josephnganga.eshop.ui.screens.favorite.FavoriteRoute
import com.josephnganga.eshop.ui.screens.home.HomeRoute
import com.josephnganga.eshop.ui.screens.payment.PaymentRoute
import com.josephnganga.eshop.ui.screens.profile.ProfileRoute
import com.josephnganga.eshop.ui.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onBadgeCountChange: (Int) -> Unit
) {
    NavHost(navController = navController, startDestination = Splash.route, modifier = modifier) {
        composable(Splash.route) {
            SplashScreen(
                navigateToHomeScreen = {
                    navController.navigate(SignIn.route)
                },
            )
        }

        composable(Home.route) {
            HomeRoute(
                onProductClicked = {
                    val route = "${ProductDetail.route}/${it.id}"
                    navController.navigate(route = route)
                },
            )
        }
        composable(ProductDetail.routeWithArgs, arguments = ProductDetail.arguments) {
            DetailRoute(
                onBadgeCountChange = onBadgeCountChange,
            )
        }
        composable(Cart.route) {
            CartRoute(
                onClickedBuyNowButton = {
                    navController.navigate(Payment.route)
                },
                onCartClicked = {
                    val route = "${ProductDetail.route}/${it.productId}"
                    navController.navigate(route = route)
                },
                onBadgeCountChange = onBadgeCountChange,
            )
        }
        composable(Profile.route) {
            ProfileRoute(
                logout = {
                    navController.navigate(SignIn.route) {
                        popUpTo(SignIn.route) {
                            inclusive = true
                        }
                    }
                },
            )
        }
        composable(SignIn.route) {
            SignInRoute(
                onGoSignUpButtonClicked = {
                    navController.navigate(SignUp.route)
                },
                navigateToHomeScreen = {
                    navController.navigate(Home.route)
                },
            )
        }
        composable(SignUp.route) {
            SignUpRoute(
                navigateToSignInScreen = {
                    navController.navigate(SignIn.route)
                },
            )
        }
        composable(Favorite.route) {
            FavoriteRoute(
                onProductClicked = {
                    val route = "${ProductDetail.route}/${it.productId}"
                    navController.navigate(route = route)
                },
            )
        }
        composable(Payment.route) {
            PaymentRoute()
        }
    }
}
