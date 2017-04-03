package io.github.mcasper3.calvinandhobbes.injection

import dagger.Module
import dagger.Provides
import io.github.mcasper3.calvinandhobbes.data.api.CalvinAndHobbesApi
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideCalvinAndHobbesApi(): CalvinAndHobbesApi {
        return CalvinAndHobbesApi.Creator.create()
    }
}