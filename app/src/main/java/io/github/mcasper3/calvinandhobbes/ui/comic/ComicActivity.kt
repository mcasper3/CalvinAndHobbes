package io.github.mcasper3.calvinandhobbes.ui.comic

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.TextView
import butterknife.bindView

import io.github.mcasper3.calvinandhobbes.R

class ComicActivity : AppCompatActivity() {
    val mDateOutline: TextView by bindView(R.id.comic_date_outline)
    val mDateFill: TextView by bindView(R.id.comic_date_fill)
    val mViewPager: ViewPager by bindView(R.id.comic_view_pager)
    lateinit var mAdapter: ComicPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic)

        val outline = Typeface.createFromAsset(assets, "fonts/CALVINO.TTF")
        val normal = Typeface.createFromAsset(assets, "fonts/CALVINN.TTF")

        mDateOutline.typeface = outline
        mDateFill.typeface = normal

        mAdapter = ComicPagerAdapter(supportFragmentManager)
        mViewPager.adapter = mAdapter
        mViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                updateDate(mAdapter.getDate(position))
            }

        })

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun updateDate(date: String) {
        mDateOutline.text = date
        mDateFill.text = date
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, ComicActivity::class.java)
        }
    }
}
