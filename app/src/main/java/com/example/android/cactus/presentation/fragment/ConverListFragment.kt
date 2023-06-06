package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentConverListBinding
import com.example.android.cactus.presentation.ui.SpaceItemDecorator
import com.example.android.cactus.domain.repository.ConversationRepository
import com.example.android.cactus.presentation.adapter.ConversatioAdapter


class ConverListFragment : Fragment() {
    private var _binding: FragmentConverListBinding? = null
    private val binding get() = _binding!!

    private var conversationAdapter: ConversatioAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConverListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val decorator = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        val spacing = SpaceItemDecorator(requireContext())

       /* conversationAdapter = ConversatioAdapter(ConversationRepository.conversations){
            showSelectedConversation(it)
        }*/

        conversationAdapter = ConversatioAdapter({ selectedPosition ->
            showSelectedConversation(selectedPosition)
        }).apply {
            submitList(ConversationRepository.conversations)
        }

        with(binding) {
            buttonback.setOnClickListener {
                activity?.onBackPressed()
            }
        }
        binding.rvConver.run{
            adapter = conversationAdapter
            addItemDecoration(decorator)
            addItemDecoration(spacing)

        }

    }
    private fun showSelectedConversation(idConversation: Int){
        val bundle= Bundle().apply {
            putInt("idConversation", idConversation)
        }
        findNavController().navigate(R.id.action_converListFragment_to_conversationFragment, bundle)
    }
}