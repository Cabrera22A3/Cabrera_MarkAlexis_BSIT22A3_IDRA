package com.example.cabrera_markalexis_bsit22a3_idra

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cabrera_markalexis_bsit22a3_idra.ui.theme.Cabrera_MarkAlexis_BSIT22A3_IDRATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cabrera_MarkAlexis_BSIT22A3_IDRATheme {
                DiceRollerAppContent()
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceRollerAppContent(modifier: Modifier = Modifier){
    Text(
        text = "Press the 'ROLL' button to roll!",
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        lineHeight = 50.sp,
        modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.TopCenter).padding(top = 60.dp)
    )
}

@Composable
fun DiceRollerApp(modifier: Modifier = Modifier) {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource), contentDescription = result.toString()
        )
        Button(
            onClick = {
                result = (1..6).random()
            }
        ) {
            Text(stringResource(R.string.roll))
        }
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
    }

}