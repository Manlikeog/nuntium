package com.example.nuntium

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.example.nuntium.databinding.FragmentLoginBinding

import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager2.adapter = OnBoardingViewAdapter()
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position -> }.attach()
    }

 class OnBoardingViewAdapter : RecyclerView.Adapter<OnBoardingViewAdapter.MyViewHolder>(){
        class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
            var image: ImageView
            init {

                image = view.findViewById(R.id.onBoarding_image)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.login_onboarding, parent, false)
            return MyViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.itemView.run {
            with(holder) {
                if (position == 0) {
                    image.setImageResource(R.drawable.login)

                }
                if (position == 1) {
                    image.setImageResource(R.drawable.sports)
                }
                if (position == 2) {
                    image.setImageResource(R.drawable.animal)
                }
            }
        }

        override fun getItemCount(): Int = MAX_STEP
    }


    companion object {
        const val MAX_STEP = 3
    }
}