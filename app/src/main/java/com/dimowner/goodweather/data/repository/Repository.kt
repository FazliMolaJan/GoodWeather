/*
 * Copyright 2019 Dmitriy Ponomarenko
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

package com.dimowner.goodweather.data.repository

import com.dimowner.goodweather.data.remote.model.WeatherResponse
import com.dimowner.goodweather.data.local.room.WeatherEntity
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created on 21.01.2018.
 * @author Dimowner
 */
interface Repository {
	fun getWeather(): Single<WeatherResponse>

	fun getWeatherToday(city: String): Single<WeatherEntity>

	fun subscribeWeatherToday(city: String): Flowable<WeatherEntity>

	fun subscribeWeatherTwoWeeks(city: String): Flowable<List<WeatherEntity>>

	fun cacheWeather(entity: WeatherEntity)

	fun cacheWeather(entity: List<WeatherEntity>)
}