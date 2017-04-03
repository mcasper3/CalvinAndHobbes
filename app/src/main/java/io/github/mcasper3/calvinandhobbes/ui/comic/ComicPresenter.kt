package io.github.mcasper3.calvinandhobbes.ui.comic

import android.util.Log
import io.github.mcasper3.calvinandhobbes.data.comic.ComicDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ComicPresenter(val comicDataSource: ComicDataSource, private var comicView: ComicView?) {
    fun setView(view: ComicView) {
        comicView = view
    }

    fun getComic(year: String, month: String, day: String) {
        comicDataSource.getComic(year, month, day)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { url -> comicView?.showComic(url) },
                        { e -> Log.e("ComicPresenter", e?.message, e) }
                )
    }
}