package io.github.mcasper3.calvinandhobbes.injection

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ApiModule::class))
interface ApplicationComponent {
    fun plus(activityModule: ActivityModule): ActivityComponent
}