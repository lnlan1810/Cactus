package com.example.android.cactus.presentation.ui.addWord

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.cactus.R
import com.example.android.cactus.databinding.ActivityAddWordBinding
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.domain.model.Word
import com.example.android.cactus.presentation.viewmodel.AddWordViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class AddWordActivity : AppCompatActivity() {

    private var binding: ActivityAddWordBinding? = null
    private val viewModel by viewModel<AddWordViewModel>()
    private val CATEGORY = "category_arg"
    private val WORD = "word_arg"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddWordBinding.inflate(layoutInflater)

        initToolbar()
        getDataFromIntent()
        initOnClick()
        observeSelectedWord()
        observeInputData()

        setContentView(binding!!.root)
    }

    private fun initToolbar() {
        setSupportActionBar(binding?.addToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        overridePendingTransition(R.anim.hold, R.anim.slide_out_bottom)
        return super.onSupportNavigateUp()
    }

    private fun getDataFromIntent() {

        val category: Category? = intent.getParcelableExtra(CATEGORY)
        val word: Word? = intent.getParcelableExtra(WORD)

        category?.let { viewModel.setSelectedCategory(it) }
        word?.let { viewModel.setSelectedWord(it) }
    }

    private fun initOnClick() {

        binding?.addWordBtn?.setOnClickListener {
            viewModel.addOrUpdate(
                name = binding!!.addWordName.text.toString(),
                translation = binding!!.addWordTrans.text.toString()
            )
        }
    }

    private fun observeInputData() {
        viewModel.dataIsValid.observe(this, { dataIsValid ->
            if (!dataIsValid) {
                binding?.let {
                    Snackbar.make(
                        it.root,
                        getString(R.string.input_invalid_error_message),
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }
            } else {
                finish()
                overridePendingTransition(R.anim.hold, R.anim.slide_out_bottom)
            }
        })
    }

    private fun observeSelectedWord() {
        viewModel.word.observe(this, { word ->
            word?.let {
                binding?.apply {
                    addWordName.setText(word.name)
                    addWordTrans.setText(word.translation)
                }
            }
        })
    }
}




















