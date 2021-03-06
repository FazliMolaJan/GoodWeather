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

package com.dimowner.goodweather.data

import io.reactivex.Flowable

interface Prefs {

	fun isFirstRun(): Boolean

	fun firstRunExecuted()

	fun isInitialSettingApplied(): Boolean

	fun applyInitialSettings()

	fun isLocationSelected(): Boolean

	fun setLocationSelected()

	fun switchTimeFormat(): Int

	fun switchWindFormat(): Int

	fun switchPressureFormat(): Int

	fun switchTempFormat(): Int

	fun getTempFormat(): Int

	fun getWindFormat(): Int

	fun subscribePreferenceChanges(): Flowable<String>

	fun getPressureFormat(): Int

	fun getTimeFormat(): Int

	fun saveCity(city: String)

	fun getCity(): String

	fun isWeatherByCoordinates(): Boolean

	fun setWeatherByCoordinates(b: Boolean)

	fun saveLatitude(lat: Double)

	fun getLatitude(): Double

	fun saveLongitude(lng: Double)

	fun getLongitude(): Double
}
