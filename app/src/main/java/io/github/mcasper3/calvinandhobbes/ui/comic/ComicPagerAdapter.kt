package io.github.mcasper3.calvinandhobbes.ui.comic

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.text.SimpleDateFormat
import java.util.*

class ComicPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val startDate: Date
    private val sdf: SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.US)

    init {
        startDate = sdf.parse("2007/01/01")
    }

    override fun getItem(position: Int): Fragment {
        val itemDate = Calendar.getInstance()
        itemDate.time = startDate
        itemDate.add(Calendar.DAY_OF_YEAR, position)

        val date = sdf.format(itemDate.time)

        return ComicFragment.createInstance(date)
    }

    fun getDate(position: Int): String {
        val itemDate = Calendar.getInstance()
        itemDate.time = startDate
        itemDate.add(Calendar.DAY_OF_YEAR, position)

        return sdf.format(itemDate.time)
    }

    override fun getCount(): Int {
        return 3696
    }
}