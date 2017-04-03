package io.github.mcasper3.calvinandhobbes.ui.comic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.bindView
import com.squareup.picasso.Picasso
import io.github.mcasper3.calvinandhobbes.R
import io.github.mcasper3.calvinandhobbes.ui.CalvinAndHobbesApplication
import javax.inject.Inject

class ComicFragment : Fragment(), ComicView {
    @Inject lateinit var presenter: ComicPresenter

    val mComic: ImageView by bindView(R.id.comic)

    private lateinit var date: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context.applicationContext as CalvinAndHobbesApplication).createActivityComponent().inject(this)
        date = arguments.getString(ARG_DATE)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_comic, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)

        val dateParts = date.split("/")
        presenter.getComic(dateParts[0], dateParts[1], dateParts[2])
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun showComic(url: String) {
        Picasso.with(context)
                .load(url)
                .fit()
                .into(mComic)
    }

    companion object {
        private val ARG_DATE = "arg_date"

        fun createInstance(date: String): ComicFragment {
            val args = Bundle()
            args.putString(ARG_DATE, date)

            val fragment = ComicFragment()
            fragment.arguments = args

            return fragment
        }
    }
}