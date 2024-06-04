package com.nhinhnguyenuit.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nhinhnguyenuit.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(name: String, modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.avatar),
                contentScale = ContentScale.Fit
            )
            .background(color = Color.Gray)
    ) {
        items(10){

        canvas2()
            Box(
            modifier = Modifier
                .offset(x = 100.dp, y = 50.dp)
                .size(width = 150.dp, height = 140.dp)
                .background(color = Color.Cyan)

        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { count++ }) {
            Text(text = "Increase")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "$count",
            fontSize = 40.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            style = MaterialTheme.typography.titleLarge,

        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { count--}) {
            Text(text = "Decrease")
        }
        }

    }
}

@Composable
private fun canvas2() {
    Canvas(
        modifier = Modifier.size(100.dp),
        onDraw = {
            drawCircle(color = Color.Blue)
        }
    )
    Canvas(modifier = Modifier.size(200.dp),
        onDraw = {
            drawRoundRect(
                color = Color.Red,
                cornerRadius = CornerRadius(100f, 50f)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MainScreen("Android")
    }
}