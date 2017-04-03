package io.github.mcasper3.calvinandhobbes.ui

import android.app.Application
import io.github.mcasper3.calvinandhobbes.injection.*

class CalvinAndHobbesApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    lateinit var activityComponent: ActivityComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = createApplicationComponent()
    }

    private fun createApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
                .apiModule(ApiModule())
                .applicationModule(ApplicationModule(this)).build()
    }

    fun createActivityComponent(): ActivityComponent {
        activityComponent = applicationComponent.plus(ActivityModule())
        return activityComponent
    }
}