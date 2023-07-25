package org.reactormonk.robolectricnorecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import org.reactormonk.robolectricnorecompose.ui.theme.RobolectricNoRecomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobolectricNoRecomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BugTesting()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BugTesting() {
    val someVar by produceState(1) {
        delay(100)
        value = 2
        Log.d("Testing", "Set value to $value")
        delay(100)
        value = 3
        Log.d("Testing", "Set value to $value")
        delay(100)
        value = 4
        Log.d("Testing", "Set value to $value")
        delay(100)
        value = 5
        Log.d("Testing", "Set value to $value")
    }
    Log.d("Testing", "Var: $someVar")
    Column {
        Text("Var: $someVar", color = Color.Red)
    }
}
