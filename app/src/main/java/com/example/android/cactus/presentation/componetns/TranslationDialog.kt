package com.example.android.cactus.presentation.componetns

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.android.cactus.domain.model.entity.WordTranslationState
import com.example.android.cactus.presentation.translate.WordTranslateEvent
import com.example.android.cactus.presentation.ui.theme.SecondaryTextColor
import com.google.accompanist.flowlayout.FlowRow


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TranslationDialog(
    translationState: State<WordTranslationState>,
    // selectedTranslations: SnapshotStateList<String>,
    onEvent: (WordTranslateEvent) -> Unit
) {
    Dialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        onDismissRequest = {
            onEvent(WordTranslateEvent.OnHideTranslationDialog)
        },
        content = {
            Box {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .width(250.dp),
                    backgroundColor = MaterialTheme.colors.surface,
                    elevation = 0.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .wrapContentHeight()
                    ) {
                        if (translationState.value.isLoading) {
                            Box(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                            }
                        } else {
                            translationState.value.translation?.let {
                                for (word in it.words) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = word.word,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(modifier = Modifier.padding(2.dp, 0.dp))
                                        Text(
                                            text = "[${word.type}]",
                                            color = SecondaryTextColor,
                                            fontSize = 10.sp,
                                        )
                                    }
                                    FlowRow(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .wrapContentHeight(),
                                    ) {
                                        for (trans in word.translation) {
                                            Box(
                                                modifier = Modifier
                                                    .padding(2.dp)
                                                    .background(
                                                        color = Color(0xffE1ECFB),
                                                        shape = RoundedCornerShape(50)
                                                    )

                                            ) {
                                                Text(
                                                    modifier = Modifier.padding(8.dp, 3.dp),
                                                    text = trans,
                                                    color = Color(0xff000000),
                                                    /* color = if (!selectedTranslations.contains(trans))
                                                         MaterialTheme.colors.onBackground
                                                     else MaterialTheme.colors.onPrimary,*/
                                                    maxLines = 1
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.padding(10.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(onClick = { onEvent(WordTranslateEvent.OnHideTranslationDialog) }) {
                                    Text(text = "Cancel")
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}