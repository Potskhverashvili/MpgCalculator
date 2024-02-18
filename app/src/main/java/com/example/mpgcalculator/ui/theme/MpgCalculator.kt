package com.example.mpgcalculator.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mpgcalculator.R

@Composable
fun MpgCalculatorApp() {
    var inputValue by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var inputConvert by remember { mutableStateOf("MPG") }
    var outputConvert by remember { mutableStateOf("L/100KM") }
    var mpgOrLit by remember { mutableStateOf("MPG") }
    var firstButtonTextSz by remember { mutableIntStateOf(17) }
    var secondButtonTextSz by remember { mutableIntStateOf(17) }

    Box {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        // ------------------- Head Column --------------------
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // ---------------- Head -----------------
            Spacer(modifier = Modifier.padding(30.dp))
            Text(text = "Convert", color = Color.White, fontSize = 45.sp)
            Spacer(modifier = Modifier.padding(7.dp))
            Text(
                text = "$inputValue $inputConvert = $result $outputConvert ",
                color = Color.White,
                fontSize = 25.sp
            )
        }

        // ----------------- Body Column ---------------
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.padding(15.dp))
            // It shows selected convert type
            Text(
                text = "$inputConvert to $outputConvert",
                fontSize = 25.sp,
                color = Color.Blue
            )

            // ---------------------------- Input Value -----------------------------
            Spacer(modifier = Modifier.padding(8.dp))
            OutlinedTextField(
                value = inputValue,
                onValueChange = { inputValue = it },
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Enter $mpgOrLit",
                        fontWeight = FontWeight.Bold
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(fontSize = 20.sp),

                )
            Spacer(modifier = Modifier.padding(20.dp))
            // ---------------------------- Buttons -----------------------------------
            Column {
                // ----------- First Button -----------
                Button(
                    onClick = {
                        mpgOrLit = "MPG"
                        inputConvert = "MPG"
                        outputConvert = "L/100KM"
                        firstButtonTextSz = 20
                        secondButtonTextSz = 17
                    },

                    modifier = Modifier
                        .size(width = 230.dp, height = 70.dp)

                ) {
                    Text(text = "MPG to L/100KM", fontSize = firstButtonTextSz.sp)
                }

                // ----------- Second Button -----------
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        mpgOrLit = "Liter"
                        inputConvert = "L/100KM"
                        outputConvert = "MPG"
                        firstButtonTextSz = 17
                        secondButtonTextSz = 20
                    },
                    modifier = Modifier.size(width = 230.dp, height = 70.dp)
                ) {
                    Text(text = "L/100KM to MPG", fontSize = secondButtonTextSz.sp)
                }
            }

            if (inputValue.isNotEmpty()) {
                when (inputConvert) {
                    "MPG" -> result = mpgToKm(inputValue.toDouble()).toString()
                    "L/100KM" -> result = kmToMpg(inputValue.toDouble()).toString()
                }
            }
        }
    }
}