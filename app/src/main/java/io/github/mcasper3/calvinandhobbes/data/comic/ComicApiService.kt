package io.github.mcasper3.calvinandhobbes.data.comic

import io.github.mcasper3.calvinandhobbes.data.api.CalvinAndHobbesApi
import io.reactivex.Observable
import java.io.BufferedReader

class ComicApiService(val calvinAndHobbesApi: CalvinAndHobbesApi) : ComicDataSource {
    override fun getComic(year: String, month: String, day: String): Observable<String> {
        return calvinAndHobbesApi.getComic(year, month, day)
                .flatMap {
                    val content = it.byteStream()
                            .bufferedReader()
                            .use(BufferedReader::readText)

                    val imageIndex = content.indexOf("item-comic-image")
                    val srcIndex = content.indexOf("src=", imageIndex)
                    val firstQuoteIndex = content.indexOf('"', srcIndex)
                    val secondQuoteIndex = content.indexOf('"', firstQuoteIndex + 1)
                    val url = content.substring(firstQuoteIndex + 1, secondQuoteIndex)

                    Observable.just(url)
                }
    }

}