package com.example.android.cactus.presentation.fragment

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.android.cactus.R
import com.example.android.cactus.databinding.BasicdialogBinding
import com.example.android.cactus.databinding.CommonwordsdialogBinding
import com.example.android.cactus.databinding.FragmentHomeBinding
import com.example.android.cactus.databinding.MenudialogBinding
import kotlinx.android.synthetic.main.basicdialog.*
import kotlinx.android.synthetic.main.basicdialog.button_xlearn
import kotlinx.android.synthetic.main.commonwordsdialog.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.menudialog.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var epicDialog: Dialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        epicDialog = Dialog(requireContext())

        with(binding) {
            buttonlearn.setOnClickListener {
                val dialogBinding = BasicdialogBinding.inflate(layoutInflater)
                epicDialog.setContentView(dialogBinding.root)

                epicDialog.button_hand.setOnClickListener {

                    val bundle = Bundle()
                    findNavController().navigate(
                        R.id.action_homeFragment2_to_handwritingFragment3,
                        bundle
                    )

                    epicDialog.dismiss()
                }

                epicDialog.button_num.setOnClickListener {

                    val bundle = Bundle()
                    findNavController().navigate(
                        R.id.action_homeFragment2_to_mainNumberFragment,
                        bundle
                    )

                    epicDialog.dismiss()
                }

                epicDialog.button_day.setOnClickListener {
                    val bundle = Bundle()
                    findNavController().navigate(R.id.action_homeFragment2_to_dayFragment, bundle)

                    epicDialog.dismiss()
                }

                epicDialog.button_xlearn.setOnClickListener {
                    epicDialog.dismiss()
                }
                epicDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                epicDialog.show()
            }
        }

        with(binding) {
            buttoncommon.setOnClickListener {
                val dialogBinding = CommonwordsdialogBinding.inflate(layoutInflater)
                epicDialog.setContentView(dialogBinding.root)

                epicDialog.button_nouns.setOnClickListener {
                    //  a = "noun"
                    val bundle = Bundle()
                    findNavController().navigate(
                        R.id.action_homeFragment2_to_nounsFragment2,
                        bundle
                    )
                    epicDialog.dismiss()

                }
                epicDialog.button_verb.setOnClickListener {
                    val bundle = Bundle()
                    findNavController().navigate(R.id.action_homeFragment2_to_verbFragment, bundle)
                    epicDialog.dismiss()
                }

                epicDialog.button_adj.setOnClickListener {
                    val bundle = Bundle()
                    findNavController().navigate(R.id.action_homeFragment2_to_adjFragment, bundle)
                    epicDialog.dismiss()

                }

                epicDialog.button_xlearn.setOnClickListener {
                    epicDialog.dismiss()
                }
                epicDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                epicDialog.show()
            }
        }

        with(binding) {
            buttonHelp.setOnClickListener() {
                val dialogBinding = MenudialogBinding.inflate(layoutInflater)
                epicDialog.setContentView(dialogBinding.root)

                epicDialog.feedback.setOnClickListener {

                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:example@email.com")
                    startActivity(Intent.createChooser(intent, "Send email..."))
                }

                epicDialog.rate.setOnClickListener {
                    val appPackageName =
                        "com.example.cactus" //Provide the package name of Google Play Store app
                    try {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=$appPackageName")
                            )
                        )
                    } catch (anfe: ActivityNotFoundException) {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                            )
                        )
                    }
                }

                epicDialog.button_x.setOnClickListener {
                    epicDialog.dismiss()
                }

                epicDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                epicDialog.show()

            }
        }

        with(binding) {
            buttoconver.setOnClickListener {
                val bundle = Bundle()
                findNavController().navigate(
                    R.id.action_homeFragment2_to_converListFragment,
                    bundle
                )
            }
        }

        with(binding) {
            ivTopic.setOnClickListener {
                val bundle = Bundle()
                findNavController().navigate(
                    R.id.action_homeFragment2_to_vocabTopicsFragment,
                    bundle
                )
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}