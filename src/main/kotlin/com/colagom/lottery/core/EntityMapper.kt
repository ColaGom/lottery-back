package com.colagom.lottery.core

import org.modelmapper.ModelMapper

val mapper by lazy { ModelMapper() }
inline fun <reified T> Any.toggleModel(): T = mapper.map(this, T::class.java)