package io.github.mcasper3.calvinandhobbes.ui

import android.app.Application
import io.github.mcasper3.calvinandhobbes.injection.*
import io.github.mcasper3.calvinandhobbes.injection.component.ApplicationComponent
import io.github.mcasper3.calvinandhobbes.injection.component.ComicComponent
import io.github.mcasper3.calvinandhobbes.injection.component.DaggerApplicationComponent
import io.github.mcasper3.calvinandhobbes.injection.module.ApiModule
import io.github.mcasper3.calvinandhobbes.injection.module.ApplicationModule
import io.github.mcasper3.calvinandhobbes.injection.module.ComicModule

class CalvinAndHobbesApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    lateinit var comicComponent: ComicComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = createApplicationComponent()
    }

    private fun createApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
                .apiModule(ApiModule())
                .applicationModule(ApplicationModule(this))
                .build()
    }

    fun createActivityComponent(): ComicComponent {
        comicComponent = applicationComponent.plus(ComicModule())
        return comicComponent
    }
}