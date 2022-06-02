package com.example.material_3.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.material_3.R
import com.example.material_3.databinding.FragmentViewPagerBinding

class ViewPagerFragment:Fragment(R.layout.fragment_view_pager) {

    companion object {
        fun newInstance() = ViewPagerFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentViewPagerBinding.bind(view)
        val pager = binding.viewPager
        pager.adapter = PagerAdapter(this)
        pager.setPageTransformer(ZoomOutPageTransformer())
        binding.indicator.setViewPager(pager)
    }

}

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment =
         NasaPictureFragment.newInstance(position)
}