package io.github.mcasper3.calvinandhobbes.injection

import dagger.Module
import dagger.Provides
import io.github.mcasper3.calvinandhobbes.data.api.CalvinAndHobbesApi
import io.github.mcasper3.calvinandhobbes.data.comic.ComicApiService
import io.github.mcasper3.calvinandhobbes.data.comic.ComicDataSource
import io.github.mcasper3.calvinandhobbes.ui.comic.ComicPresenter

@Module
class ActivityModule {
    @Provides
    fun provideComicPresenter(comicDataSource: ComicDataSource): ComicPresenter {
        return ComicPresenter(comicDataSource, null)
    }

    @Provides
    fun provideComicDataSource(api: CalvinAndHobbesApi): ComicDataSource {
        return ComicApiService(api)
    }
}