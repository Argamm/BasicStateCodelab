package com.example.basicstatecodelab

import androidx.compose.foundation.background
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier,
    increase: () -> Unit,
    decrease: () -> Unit,
    clearCount: () -> Unit,
    newCount: Int
) {
    Column(modifier = modifier.padding(16.dp)) {

        if (newCount > 0) {

            var showTask by remember {
                mutableStateOf(true)
            }

            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    onClose = { showTask = false },
                    modifier = Modifier.background(Color.Gray)
                )
            }

            Text(
                text = "You've had $newCount glasses.",
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = increase,
                modifier = Modifier.padding(top = 8.dp),
                enabled = newCount < 10
            ) {
                Text(text = "Add one")

            }
            Button(
                onClick = decrease,
                modifier = Modifier.padding(top = 8.dp),
                enabled = newCount > 0
            ) {
                Text(text = "delete")

            }

            Button(
                onClick = clearCount,
                Modifier.padding(start = 8.dp)) {
                Text("Clear")
            }
        }
    }

}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun WaterCounterPreview() {
    var count by rememberSaveable {
        mutableStateOf(0)
    }

    WaterCounter(increase = { count++ }, decrease = { count-- }, newCount = count, clearCount = {count = 0})
}