package com.example.android.cactus.homeScreen.presentation.fragment

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
import com.example.android.cactus.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
   // private var a: String = ""

    private lateinit var epicDialog: Dialog
    private lateinit var btnxPopUP: ImageButton
    private lateinit var btnLearnX: Button
    private lateinit var btnLearnX2: Button
    private lateinit var btnLearnX3: Button

    /*
    companion object {
        var b: String = ""
    }
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        epicDialog = Dialog(requireContext())

        with(binding){
            buttonlearn.setOnClickListener {
                epicDialog.setContentView(R.layout.basicdialog)
                btnxPopUP = epicDialog.findViewById(R.id.button_xlearn)

                btnLearnX = epicDialog.findViewById(R.id.button_hand)
                btnLearnX.setOnClickListener {

                 val bundle = Bundle()
                   findNavController().navigate(R.id.action_homeFragment2_to_handwritingFragment3, bundle)

                   epicDialog.dismiss()
                }
                btnLearnX2 = epicDialog.findViewById(R.id.button_num)
                btnLearnX2.setOnClickListener {

                    val bundle = Bundle()
                    findNavController().navigate(R.id.action_homeFragment2_to_numberFragment, bundle)

                    epicDialog.dismiss()
                   /*
                    requireActivity().overridePendingTransition(
                        R.anim.slide_out_right,
                        R.anim.slide_in_left
                    )

                    */
                }

                btnLearnX3 = epicDialog.findViewById(R.id.button_day)
                btnLearnX3.setOnClickListener {
                    val bundle = Bundle()
                    findNavController().navigate(R.id.action_homeFragment2_to_dayFragment, bundle)

                    epicDialog.dismiss()
                }

                btnxPopUP.setOnClickListener {
                    epicDialog.dismiss()
                }
                epicDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                epicDialog.show()
            }

        }

        with(binding){
            buttoncommon.setOnClickListener{
                epicDialog.setContentView(R.layout.commonwordsdialog)
                btnxPopUP = epicDialog.findViewById(R.id.button_xlearn)

                btnLearnX = epicDialog.findViewById(R.id.button_nouns)
                btnLearnX.setOnClickListener {
                  //  a = "noun"
                    val bundle = Bundle()
                    findNavController().navigate(R.id.action_homeFragment2_to_nounsFragment2, bundle)
                    epicDialog.dismiss()

                    /*
                    requireActivity().overridePendingTransition(
                        R.anim.slide_out_right,
                        R.anim.slide_in_left
                    )

                     */
                }
                btnLearnX2 = epicDialog.findViewById(R.id.button_verb)
                btnLearnX2.setOnClickListener {
                    val bundle = Bundle()
                    findNavController().navigate(R.id.action_homeFragment2_to_verbFragment, bundle)
                    epicDialog.dismiss()

                    /*
                    requireActivity().overridePendingTransition(
                        R.anim.slide_out_right,
                        R.anim.slide_in_left
                    )

                     */
                }

                btnLearnX3 = epicDialog.findViewById(R.id.button_adj)
                btnLearnX3.setOnClickListener {
                    val bundle = Bundle()
                    findNavController().navigate(R.id.action_homeFragment2_to_adjFragment, bundle)
                    epicDialog.dismiss()

                    requireActivity().overridePendingTransition(
                        R.anim.slide_out_right,
                        R.anim.slide_in_left
                    )
                }

                btnxPopUP.setOnClickListener {
                    epicDialog.dismiss()
                }
                epicDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                epicDialog.show()
            }
        }

        with(binding){
            buttonHelp.setOnClickListener(){
                epicDialog.setContentView(R.layout.menudialog)
                btnxPopUP = epicDialog.findViewById(R.id.button_xhelp)

                btnLearnX = epicDialog.findViewById(R.id.feedback)
                btnLearnX.setOnClickListener {
                    /*
                   val emailIntent = Intent(Intent.ACTION_SEND,
                   Uri.fromParts("mailto","cactus@gmail.com", null))
                    startActivity(Intent.createChooser(emailIntent,"Send email..."))

                     */

                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:example@email.com")
                    startActivity(Intent.createChooser(intent,"Send email..."))
                }

                btnLearnX2 = epicDialog.findViewById(R.id.rate)
                btnLearnX2.setOnClickListener{
                    val appPackageName = "com.example.cactus" //Provide the package name of Google Play Store app
                    try {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
                    } catch (anfe: ActivityNotFoundException) {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
                    }

                }

                btnxPopUP.setOnClickListener {
                    epicDialog.dismiss()
                }

                epicDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                epicDialog.show()

            }
        }

        with(binding){
            buttoconver.setOnClickListener{
                val bundle = Bundle()
                findNavController().navigate(R.id.action_homeFragment2_to_converListFragment, bundle)
            }
        }

        with(binding){
            ivTopic.setOnClickListener{
                val bundle = Bundle()
                findNavController().navigate(R.id.action_homeFragment2_to_vocabTopicsFragment, bundle)
            }
        }

       // HomeFragment.b =a
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    /*
    fun getA(): String {
        return a
    }
     */
}

