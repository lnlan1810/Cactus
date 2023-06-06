package com.example.android.cactus.presentation.ui.addCategory

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.android.cactus.databinding.DialogCategoryBinding

class AddCatDialog : DialogFragment() {

    private  var listener: CategoryDialogListener? = null
    private var binding: DialogCategoryBinding? = null
    interface CategoryDialogListener {
        fun onDialogPositiveClick(name: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = DialogCategoryBinding.inflate(LayoutInflater.from(context)).apply {

            catAddBtn.setOnClickListener {

                val categoryName = binding?.catName?.text.toString()
                listener?.onDialogPositiveClick(categoryName)
                dialog?.dismiss()
            }
        }

        val builder = AlertDialog.Builder(context).apply {
            setView(binding!!.root)
        }

        return builder.create()
    }

    fun setListener(listener: CategoryDialogListener) {
        this.listener = listener
    }

    interface Callbacks {
        fun onCategoryAdded(categoryName: String)
    }
}












