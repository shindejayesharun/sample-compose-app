package com.shindejayesharun.samplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shindejayesharun.samplecompose.ui.theme.SampleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    //Text(text = "Hello $name!")
    var counter = remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Compose App")
            })
        }, floatingActionButton = {
            FloatingActionButton(onClick = { counter.value++; }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text("You have pushed the button this many times")
                Text("${counter.value}", style = MaterialTheme.typography.h4)
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleComposeTheme {
        Greeting("Android")
    }
}