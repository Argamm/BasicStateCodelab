package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.basicstatecodelab.viewModel.WellnessViewModel

@Composable
fun WellnessScreen(
    wellnessViewModel: WellnessViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Column {
        var count by rememberSaveable { mutableStateOf(0) }

        WaterCounter(increase = {count++}, decrease = {count--}, newCount = count)
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }
}