package io.github.mcasper3.calvinandhobbes.ui.comic

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import butterknife.bindView

import io.github.mcasper3.calvinandhobbes.R
import io.github.mcasper3.calvinandhobbes.ui.CalvinAndHobbesApplication
import javax.inject.Inject

class ComicActivity : AppCompatActivity(), ComicView {
    @Inject lateinit var presenter: ComicPresenter

    val mDateOutline: TextView by bindView(R.id.comic_date_outline)
    val mDateFill: TextView by bindView(R.id.comic_date_fill)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as CalvinAndHobbesApplication).createActivityComponent().inject(this)

        setContentView(R.layout.activity_comic)
        presenter.setView(this)
        presenter.getComic("2017", "04", "03")

        val outline = Typeface.createFromAsset(assets, "fonts/CALVINO.TTF")
        val normal = Typeface.createFromAsset(assets, "fonts/CALVINN.TTF")

        mDateOutline.typeface = outline
        mDateFill.typeface = normal

        mDateOutline.text = "10/12/2014"
        mDateFill.text = "10/12/2014"
    }

    override fun showComic(url: String) {
        Log.i("Comic", url)
    }

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, ComicActivity::class.java)
        }
    }
}
