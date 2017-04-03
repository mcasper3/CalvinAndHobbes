package io.github.mcasper3.calvinandhobbes.injection

import dagger.Subcomponent
import io.github.mcasper3.calvinandhobbes.ui.comic.ComicActivity

@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(target: ComicActivity)
}