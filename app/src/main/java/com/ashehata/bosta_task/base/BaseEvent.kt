package com.ashehata.bosta_task.base

import androidx.compose.runtime.MutableState

interface BaseEvent

interface BaseState

interface BaseViewState {
    val isRefreshing: MutableState<Boolean>
    val networkError: MutableState<Boolean>
}