package com.example.android.cactus.presentation.ui.words

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.R
import com.example.android.cactus.databinding.ActivityWordsBinding
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.domain.model.Word
import com.example.android.cactus.presentation.adapter.CategoryListAdapter
import com.example.android.cactus.presentation.adapter.WordListAdapter
import com.example.android.cactus.presentation.ui.addCategory.AddCatDialog
import com.example.android.cactus.presentation.ui.addWord.AddWordActivity
import com.example.android.cactus.presentation.ui.learn.LearnActivity
import com.example.android.cactus.presentation.viewmodel.WordsViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList


class WordsActivity : AppCompatActivity(), WordListAdapter.ItemClickListener,
    AddCatDialog.CategoryDialogListener {

    private var textToSpeech: TextToSpeech? = null
    private var _binding: ActivityWordsBinding? = null
    private  val binding get() = _binding!!
    private val viewModel by viewModel<WordsViewModel>()
    private var listAdapter: WordListAdapter? = null
    private var fragmentManager: FragmentManager? = null
    private var catDialogFragment: DialogFragment? = null
    private var recyclerView: RecyclerView? = null
    private val CATEGORY = "category_arg"
    private val WORD = "word_arg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWordsBinding.inflate(layoutInflater)
        lifecycle.addObserver(viewModel)

        initToolbar()
        getCategoryFromIntent()
        initOnClick()
        initRecyclerView()
        initDialogFragment()
        observeWords()
        observeCategory()
        setRecyclerViewItemTouchListener()
        initTextToSpeech()

        setContentView(binding!!.root)
    }

    private fun initToolbar() {
        setSupportActionBar(binding?.wordsToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    private fun observeCategory() {
        viewModel.category.observe(this, { category ->
            binding?.wordsCategory?.text  = category.name
        })
    }

    private fun getCategoryFromIntent() {
        val category: Category? = intent.getParcelableExtra(CATEGORY)

        category?.run {
            viewModel.setSelectedCategory(this)
            binding?.wordsCategory?.text  = category.name
        }
    }

    private fun initOnClick() {

        binding?.apply {
            wordsAddBtn.setOnClickListener {
                viewModel.category.value?.let {
                    startAddWordActivity(category = it, null)
                }
            }

            wordsStartBtn.setOnClickListener {
                viewModel.category.value?.let {
                    startLearnActivity(category = it)
                }
            }

            wordsCatEdit.setOnClickListener {
                showCatPopUp(binding!!.wordsCatEdit)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        startCategoryActivity()

        return super.onSupportNavigateUp()
    }

    private fun showCatPopUp(view: View) {
        PopupMenu(this, view).apply {
            inflate(R.menu.menu_category)
            show()

            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_cat_delete -> {
                        viewModel.deleteCategory()
                        finish()
                    }
                    R.id.menu_cat_rename -> showRenameDialog()
                }
                true
            }
        }
    }

    private fun initRecyclerView() {
       // listAdapter = WordListAdapter(ArrayList(), this)
        listAdapter = WordListAdapter(this).apply {
            submitList(ArrayList<Word>()) // hoặc submitList(emptyList())
        }

        recyclerView = binding?.wordsRecyclerview?.apply {
            layoutManager = LinearLayoutManager(this.context)
            itemAnimator = DefaultItemAnimator()
            adapter = listAdapter
        }
    }

    private fun initDialogFragment() {
        fragmentManager = supportFragmentManager
        catDialogFragment = AddCatDialog()
    }

    private fun observeWords() {
        viewModel.wordsOfCategory.observe(this, { words ->
            if (words.isNullOrEmpty()) {
                binding?.wordsAddImage?.visibility = View.VISIBLE
                        binding?.wordsAddText?.visibility = View.VISIBLE
                binding?.wordsNumber?.text = getString(R.string.zero_words)
            } else {
                renderUI(listItems = words)
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun renderUI(listItems: List<Word>) {
        listAdapter?.setData(listItems)

        binding?.apply {

            wordsStartBtn.apply {
                wordsStartBtn.visibility = View.VISIBLE
                wordsStartBtn.isEnabled = true
                wordsStartBtn.isClickable = true
            }

            wordsNumber.text =
                "(" + listItems.filter { it.goodWord == 1 }.count()
                    .toString() + " /" + listItems.count()
                    .toString() + ")"

            wordsAddImage.visibility = View.INVISIBLE
            wordsAddText.visibility = View.INVISIBLE
        }
    }

    private fun startLearnActivity(category: Category) {
        startActivity(Intent(this, LearnActivity::class.java).apply {
            putExtra(CATEGORY, category)
        })
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
    }

    private fun startAddWordActivity(category: Category, word: Word?) {
        startActivity(Intent(this, AddWordActivity::class.java).apply {
            putExtra(CATEGORY, category)
            putExtra(WORD, word)
        })
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.hold)
    }

    private fun startCategoryActivity() {
        finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onItemClick(position: Int) {
        val word = viewModel.wordsOfCategory.value?.get(position)
        viewModel.category.value?.let { startAddWordActivity(it, word) }
    }

    override fun onListeningClick(position: Int) {
        val word = viewModel.wordsOfCategory.value?.get(position)?.translation
        word?.let { speakWord(it) }
    }

    private fun initTextToSpeech() {
        textToSpeech = TextToSpeech(this) { status ->
            if (status != TextToSpeech.ERROR) {
                textToSpeech?.language = Locale.forLanguageTag("ru")
            }
        }
    }

    private fun speakWord(word: String) {
        textToSpeech?.speak(word, TextToSpeech.QUEUE_FLUSH, null)
    }

    override fun onDialogPositiveClick(name: String) {

        viewModel.updateCategory(name)
        binding?.wordsCategory?.text = name
        catDialogFragment?.dismiss()
    }

    private fun showRenameDialog() {
        fragmentManager?.let { catDialogFragment?.show(it, getString(R.string.cat_dialog)) }
    }

    private fun setRecyclerViewItemTouchListener() {

        val itemTouchCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                viewHolder1: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition

                viewModel.deleteWord(position)
            }
        }

        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(recyclerView)
    }
}