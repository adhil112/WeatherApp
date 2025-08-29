package com.test.weatherappliaction.data.local

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject
@ActivityRetainedScoped
class LocalRepository@Inject constructor(private val localDataSource: LocalDataSource)  {
}