package com.example.authscreenwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authscreenwithcompose.ui.theme.AuthScreenWithComposeTheme

class MainActivity : ComponentActivity() {

    private lateinit var emailState: MutableState<String>
    private lateinit var passwordState: MutableState<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            emailState = remember {
                mutableStateOf("")
            }
            passwordState = remember {
                mutableStateOf("")
            }
            AuthScreenWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        scaffoldState = scaffoldState,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        MainLoginScreen(emailState.value, passwordState.value)
                    }
                }
            }
        }
    }
}

@Composable
fun MainLoginScreen(emailState: String = "", passwordState: String = "") {
    val rotation by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = InfiniteRepeatableSpec(
            animation = TweenSpec(
                durationMillis = 5000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Image(
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
                .rotate(rotation),
            painter = painterResource(
                id = R.drawable.compose_logo
            ),
            contentDescription = "Compose Logo"
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = emailState,
            label = {
                Text(text = "example@gmail.com")
            },
            onValueChange = { }
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = passwordState,
            label = {
                Text(text = "Password")
            },
            onValueChange = { }
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { }
        ) {
            Text(text = "Login")
        }
    }
}

@Composable
fun showProgressBar() {
    CircularProgressIndicator(
        modifier = Modifier.size(width = 50.dp, height = 50.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AuthScreenWithComposeTheme {
        MainLoginScreen()
    }
}