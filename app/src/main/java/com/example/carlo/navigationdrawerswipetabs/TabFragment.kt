package com.example.carlo.navigationdrawerswipetabs

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TabFragment : Fragment() {
    @SuppressLint("InflateParams")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val x =  inflater.inflate(R.layout.tab_layout,null)
        tabLayout = x.findViewById(R.id.tabs) as TabLayout
        viewPager = x.findViewById(R.id.viewpager) as ViewPager

        viewPager.adapter = MyAdapter(childFragmentManager)
        tabLayout.post {tabLayout.setupWithViewPager(viewPager)}


        return x
    }

    internal inner class MyAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
            return when(position) {
                0 -> FirstFragment()
                1 -> SecondFragment()
                2 -> ThirdFragment()
                else -> {
                    null
                }
            }
        }

        override fun getCount(): Int {
            return int_items
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position) {
                0 -> "First Fragment"
                1 -> "Second Fragment"
                2 -> "Third Fragment"
                else -> {
                    null
                }
            }
        }

    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var tabLayout : TabLayout
        @SuppressLint("StaticFieldLeak")
        lateinit var viewPager : ViewPager
        var int_items = 3
    }
}