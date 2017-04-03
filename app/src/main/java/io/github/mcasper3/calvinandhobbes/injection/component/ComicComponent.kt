package io.github.mcasper3.calvinandhobbes.injection.component

import dagger.Subcomponent
import io.github.mcasper3.calvinandhobbes.injection.module.ComicModule
import io.github.mcasper3.calvinandhobbes.ui.comic.ComicFragment

@Subcomponent(modules = arrayOf(ComicModule::class))
interface ComicComponent {
    fun inject(target: ComicFragment)
}