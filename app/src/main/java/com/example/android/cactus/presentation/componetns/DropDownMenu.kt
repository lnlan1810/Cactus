package com.example.android.cactus.presentation.componetns

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.android.cactus.presentation.viewmodel.translate.WordInfoViewModel


@Composable
fun DropDownMenu(
    viewModel: WordInfoViewModel,
) {
    Column {
        TopAppBar(backgroundColor = Color(0x00000000), elevation = 0.dp) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

            }
        }
    }
}
