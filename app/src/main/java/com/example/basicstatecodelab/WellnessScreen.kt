package com.example.basicstatecodelab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }

    WaterCounter(increase = {count++}, decrease = {count--}, newCount = count, clearCount = {count = 0})
}