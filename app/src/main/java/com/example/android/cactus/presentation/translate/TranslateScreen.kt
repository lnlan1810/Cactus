package com.example.android.cactus.presentation.translate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android.cactus.presentation.componetns.DropDownMenu
import com.example.android.cactus.presentation.componetns.TranslationDialog
import com.example.android.cactus.presentation.viewmodel.translate.WordInfoViewModel

@Composable
fun WordEditScreen(
    viewModel: WordInfoViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            DropDownMenu(viewModel)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            if (viewModel.showTranslationDialog.value) {
                TranslationDialog(
                    translationState = viewModel.state,
                    onEvent = viewModel::onEvent
                )
            }
            if (viewModel.editState.value) {
                TranslateScreen(viewModel = viewModel)
            } else {
            }
        }
    }
}

@Composable
fun TranslateScreen(viewModel: WordInfoViewModel  = hiltViewModel(),) {
    val focusManager = LocalFocusManager.current

    Column(Modifier.padding(10.dp)) {
        TextField(
            value = viewModel.newTerm.value,
            onValueChange = { viewModel.onEvent(WordTranslateEvent.OnTermChange(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp),
            label = { Text(text = "Term") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
            ),
            trailingIcon = {
                Row{
                    IconButton(
                        onClick = {
                            viewModel.onEvent(WordTranslateEvent.OnShowTranslationDialog)
                            focusManager.clearFocus()
                        }) {
                        Icon(
                            Icons.Default.Send,
                            contentDescription = "Edit",
                            tint = MaterialTheme.colors.primary
                        )
                    }
                }
            }
        )
    }
}