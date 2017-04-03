package io.github.mcasper3.calvinandhobbes.data.comic

import io.reactivex.Observable

interface ComicDataSource {
    fun getComic(year: String, month: String, day: String) : Observable<String>
}