package com.example.android.cactus.presentation.ui.category

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.cactus.R
import com.example.android.cactus.data.database.entities.CategoryDb
import com.example.android.cactus.data.database.entities.toDomainModel
import com.example.android.cactus.databinding.FragmentVocabularyNotebookBinding
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.presentation.ui.addCategory.AddCatDialog
import com.example.android.cactus.presentation.ui.words.WordsActivity
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.fragment.app.Fragment
import com.example.android.cactus.presentation.adapter.CategoryListAdapter
import com.example.android.cactus.presentation.viewmodel.CategoryViewModel

class VocabularyNotebookFragment : Fragment(R.layout.fragment_vocabulary_notebook), AddCatDialog.CategoryDialogListener,
        CategoryListAdapter.ItemClickListener,
        androidx.appcompat.widget.SearchView.OnQueryTextListener
    {
        private  val viewModel by viewModel<CategoryViewModel>()
        private var _binding: FragmentVocabularyNotebookBinding? = null
        private val binding get() = _binding!!
        private var listAdapter: CategoryListAdapter? = null
        private lateinit var catDialogFragment: DialogFragment
        private val CATEGORY = "category_arg"

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            _binding = FragmentVocabularyNotebookBinding.bind(view)

            lifecycle.addObserver(viewModel)

            initToolbar()
            initOnClick()
            initRecyclerView()
            initDialogFragment()
            observeCategories()
            observeTotalNumberOfWords()
        }

        private  fun initToolbar(){
            (activity as AppCompatActivity).setSupportActionBar(_binding?.topAppBar)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
        }

        private fun initOnClick(){
            with(binding){
                categoryAddButton.setOnClickListener{
                   showAddDialog()
                }
            }
        }

        private fun showAddDialog(){
          val catDialogFragment = AddCatDialog()
            catDialogFragment.setListener(object : AddCatDialog.CategoryDialogListener {
                override fun onDialogPositiveClick(name: String) {
                    val newCat = CategoryDb(0, name)
                    viewModel.addCategory(newCat)
                }
            })

           catDialogFragment.show(childFragmentManager, getString(R.string.cat_dialog))

        }

        private  fun initRecyclerView(){
            listAdapter = CategoryListAdapter(ArrayList(), this)

            with(binding){
                categoryRecyclerview.apply{
                    layoutManager = LinearLayoutManager(this.context)
                    itemAnimator = DefaultItemAnimator()
                    adapter = listAdapter
                }
            }
        }

        private  fun initDialogFragment(){
            catDialogFragment = AddCatDialog()
        }

        private  fun observeCategories(){
            viewModel.categories.observe(viewLifecycleOwner, { categories ->
                if (categories.isNullOrEmpty()){
                    listAdapter?.clear()
                } else{
                    listAdapter?.setData(categories)
                }

                showOrHideImage(categories)
            })
        }

        private fun showOrHideImage(categories: List<Category>){
            if(categories.isNullOrEmpty()){
                binding.categoryNoCategories.visibility = View.VISIBLE

            }
            else{
                binding.categoryNoCategories.visibility = View.INVISIBLE
            }
        }

            override fun onDialogPositiveClick(name: String) {
                val newCat = CategoryDb(0, name)
                viewModel.addCategory(newCat)
            }

        override fun onListItemClick(itemId: Long) {
            viewModel.categories.value?.find { it.id == itemId}?.let {
                startWordsActivity(it)
            }
        }

        private fun startWordsActivity(category: Category){
           val intent = Intent( requireContext(), WordsActivity ::class.java).apply {
               putExtra(CATEGORY, category)
           }
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left)

        }

        private  fun observeTotalNumberOfWords(){
            viewModel.totalOfWords.observe(viewLifecycleOwner, { totalNumberOfWords ->
                binding.topAppBar.title = "$totalNumberOfWords words"
            })
        }

        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            inflater.inflate(R.menu.menu_main, menu)
            val searchView = menu.findItem(R.id.action_search).actionView as SearchView
            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }
            })
            super.onCreateOptionsMenu(menu, inflater)
        }

        private fun searchDatabase(query: String){
            val searchQuery = "%$query%" // "%" required for custom sql query

            viewModel.searchDatabase(searchQuery).observe( this, {
                it.let{
                    listAdapter?.setData(it.toDomainModel())
                }
            })
        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            query?.let{ searchDatabase(query)}
            return true
        }

        override fun onQueryTextChange(query: String?): Boolean {
            query?.let { searchDatabase(query)}
            return true
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
}