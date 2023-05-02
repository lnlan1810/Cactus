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
    private var epicDialog: Dialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        epicDialog = Dialog(requireContext())

        with(binding) {
            buttonlearn.setOnClickListener {
                val dialogBinding = BasicdialogBinding.inflate(layoutInflater)
                epicDialog!!.setContentView(dialogBinding.root)

                epicDialog!!.button_hand.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_homeFragment2_to_handwritingFragment3,
                    )
                    epicDialog!!.dismiss()
                }

                epicDialog!!.button_num.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_homeFragment2_to_mainNumberFragment
                    )

                    epicDialog!!.dismiss()
                }

                epicDialog!!.button_day.setOnClickListener {
                    findNavController().navigate(R.id.action_homeFragment2_to_dayFragment)
                    epicDialog!!.dismiss()
                }

                epicDialog!!.button_xlearn.setOnClickListener {
                    epicDialog!!.dismiss()
                }
                epicDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                epicDialog!!.show()
            }
        }

        with(binding) {
            buttoncommon.setOnClickListener {
                val dialogBinding = CommonwordsdialogBinding.inflate(layoutInflater)
                epicDialog!!.setContentView(dialogBinding.root)

                epicDialog!!.button_nouns.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_homeFragment2_to_nounsFragment2,
                    )
                    epicDialog!!.dismiss()

                }
                epicDialog!!.button_verb.setOnClickListener {
                    findNavController().navigate(R.id.action_homeFragment2_to_verbFragment)
                    epicDialog!!.dismiss()
                }

                epicDialog!!.button_adj.setOnClickListener {
                    findNavController().navigate(R.id.action_homeFragment2_to_adjFragment)
                    epicDialog!!.dismiss()

                }

                epicDialog!!.button_xlearn.setOnClickListener {
                    epicDialog!!.dismiss()
                }
                epicDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                epicDialog!!.show()
            }
        }

        with(binding) {
            buttonHelp.setOnClickListener() {
                val dialogBinding = MenudialogBinding.inflate(layoutInflater)
                epicDialog!!.setContentView(dialogBinding.root)

                epicDialog!!.feedback.setOnClickListener {

                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:example@email.com")
                    startActivity(Intent.createChooser(intent, "Send email..."))
                }

                epicDialog!!.rate.setOnClickListener {
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

                epicDialog!!.button_x.setOnClickListener {
                    epicDialog!!.dismiss()
                }

                epicDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                epicDialog!!.show()

            }
        }

        with(binding) {
            buttoconver.setOnClickListener {
                findNavController().navigate(
                    R.id.action_homeFragment2_to_converListFragment,
                )
            }
        }

        with(binding) {
            ivTopic.setOnClickListener {
                findNavController().navigate(
                    R.id.action_homeFragment2_to_vocabTopicsFragment,
                )
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}