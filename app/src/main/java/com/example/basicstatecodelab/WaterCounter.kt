package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable {
            mutableStateOf(0)
        }
        Text(
            text = "You've had $count glasses.",
            modifier = modifier.fillMaxWidth().padding(16.dp),
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Button(
                onClick = { count++ },
                modifier = Modifier.padding(top = 8.dp),
                enabled = count < 10
            ) {
                Text(text = "Add one")

            }
            Button(
                onClick = { count-- },
                modifier = Modifier.padding(top = 8.dp),
                enabled = count > 0
            ) {
                Text(text = "delete")

            }
        }
    }

}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun WaterCounterPreview() {
    WaterCounter()
}