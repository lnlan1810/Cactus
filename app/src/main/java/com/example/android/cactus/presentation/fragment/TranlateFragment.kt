package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentTranlateBinding
import com.example.android.cactus.presentation.translate.TranslateScreen
import com.example.android.cactus.presentation.translate.WordEditScreen
import com.example.android.cactus.presentation.ui.theme.DictionaryTheme
import com.example.android.cactus.presentation.viewmodel.translate.WordInfoViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TranlateFragment : Fragment() {

    private val viewModel: WordInfoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                DictionaryTheme {
                    val systemUiController = rememberSystemUiController()
                    systemUiController.setSystemBarsColor(color = MaterialTheme.colors.background)
                    WordEditScreen(viewModel)
                }
            }
        }
    }
}