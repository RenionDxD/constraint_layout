package com.example.constraint_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.constraint_layout.ui.theme.Constraint_layoutTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Constraint_layoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var boxColor by remember { mutableStateOf(Color.White) }


    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(boxColor)
                .padding(16.dp)
        ) {
            Text(
                text = "Box One",
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp),
                color = if (boxColor == Color.White) Color.Black else Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .background(boxColor)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Box Two",
                    modifier = Modifier
                        .align(Alignment.Center),
                    color = if (boxColor == Color.White) Color.Black else Color.White
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(boxColor)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Box Three",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(8.dp),
                        color = if (boxColor == Color.White) Color.Black else Color.White
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(boxColor)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Box Four",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(8.dp),
                        color = if (boxColor == Color.White) Color.Black else Color.White
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(boxColor)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Box Five",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(8.dp),
                        color = if (boxColor == Color.White) Color.Black else Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)) {
                    append("This is a game: ")
                }
                withStyle(style = SpanStyle(fontSize = 16.sp, color = Color.Gray)) {
                    append("tap the screen and buttons")
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )






        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { boxColor = Color.Red },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = "Rojo")
            }

            Button(
                onClick = { boxColor = Color.Yellow },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(text = "Amarillo")
            }

            Button(
                onClick = { boxColor = Color.Green },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(text = "Verde")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Constraint_layoutTheme {
        Greeting("Android")
    }
}