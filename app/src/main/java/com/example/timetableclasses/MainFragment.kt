package com.example.timetableclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.timetableclasses.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.bottomNavigation?.setOnItemSelectedListener {
            selectTab(it.itemId)
            true
        }

        selectTab(R.id.day)
    }

    private fun selectTab(@IdRes id: Int){
        val navHostId = binding?.navHost?.id
        navHostId ?: return
        val transaction = childFragmentManager.beginTransaction()
        when (id) {
            R.id.day ->
                transaction.replace(navHostId, DayFragment.newInstance())

            R.id.week ->
                transaction.replace(navHostId, WeekFragment.newInstance())
        }
        transaction.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {

            }
    }

}