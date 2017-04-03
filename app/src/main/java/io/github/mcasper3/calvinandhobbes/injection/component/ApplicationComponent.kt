package io.github.mcasper3.calvinandhobbes.injection.component

import dagger.Component
import io.github.mcasper3.calvinandhobbes.injection.module.ComicModule
import io.github.mcasper3.calvinandhobbes.injection.module.ApiModule
import io.github.mcasper3.calvinandhobbes.injection.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ApiModule::class))
interface ApplicationComponent {
    fun plus(comicModule: ComicModule): ComicComponent
}