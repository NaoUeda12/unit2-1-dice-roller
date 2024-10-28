package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Composable
fun DiceRollerApp() {
    DiceRollButtonAndImage()
}

@Composable
fun DiceRollButtonAndImage(modifier: Modifier = Modifier) {
    var diceResult = remember { mutableStateOf(1) }
    val diceImage =
        when (diceResult.value) {
            1 -> painterResource(R.drawable.dice_1)
            2 -> painterResource(R.drawable.dice_2)
            3 -> painterResource(R.drawable.dice_3)
            4 -> painterResource(R.drawable.dice_4)
            5 -> painterResource(R.drawable.dice_5)
            else -> painterResource(R.drawable.dice_6)
        }
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(top = 240.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = diceImage,
            contentDescription = "Dice Roll Result",
            modifier = modifier,
        )
        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = { diceResult.value = (1..6).random() },
        ) {
            Text(
                text = stringResource(R.string.roll),
                fontSize = 24.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerAppPreview() {
    DiceRollerApp()
}
