/*
 * Copyright 2018 Dmitriy Ponomarenko
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor
 * license agreements. See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership. The ASF licenses this
 * file to you under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.dimowner.goodweather.dagger.application

import android.content.Context
import com.dimowner.goodweather.data.Prefs
import com.dimowner.goodweather.data.remote.RestClient
import com.dimowner.goodweather.data.repository.Repository
import com.dimowner.goodweather.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created on 20.01.2018.
 * @author Dimowner
 */
@Module
class AppModule(
		var appContext: Context
	) {

	@Provides
	@Singleton
	internal fun provideContext(): Context {
		return appContext
	}

	@Provides
	@Singleton
	internal fun providePrefs(context: Context): Prefs {
		return Prefs(context)
	}

	@Provides
	@Singleton
	internal fun provideRestClient(): RestClient{
		return RestClient()
	}

	@Provides
	@Singleton
	internal fun provideRepository(restClient: RestClient): Repository {
		return RepositoryImpl(restClient.weatherApi)
	}
}
