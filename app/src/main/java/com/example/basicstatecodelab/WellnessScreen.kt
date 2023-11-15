package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.model.WellnessTask
import com.example.basicstatecodelab.viewModel.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {


    Column {
        var count by rememberSaveable {
            mutableStateOf(0)
        }

        WaterCounter(increase = {count++}, decrease = {count--}, newCount = count)
//        StatefulCounter(modifier)

        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }



}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
