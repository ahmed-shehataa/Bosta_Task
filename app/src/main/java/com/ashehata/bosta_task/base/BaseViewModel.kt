package com.ashehata.bosta_task.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : BaseEvent, ViewState : BaseViewState, State : BaseState>
    : ViewModel() {

    private val initialState: State? by lazy { createInitialState() }

    private val initialViewState: ViewState? by lazy { createInitialViewState() }

    val viewStates: ViewState? by lazy {
        createInitialViewState()
    }

    private val _state = MutableStateFlow(initialState)
    val state get() = _state.asStateFlow().filterNotNull()

    private val _event = MutableSharedFlow<Event>()
    private val event get() = _event.asSharedFlow()


    init {
        subscribeEvents()
    }

    /**
     * Start listening to Event
     */
    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvents(it)
            }
        }
    }

    /**
     * Set new Event
     */
    fun setEvent(event: Event) {
        viewModelScope.launch {

            Log.d("MVI_Practice", "setEvent subscriptionCount: ${_event.subscriptionCount.value}")
            _event.emit(event)
        }
    }

    /**
     * Set new Ui State
     */
    private fun setState(builder: () -> State?) {
        viewModelScope.launch {
            _state.emit(builder())
        }
    }

    open fun createInitialState(): State? {
        return null
    }

    open fun createInitialViewState(): ViewState? {
        return null
    }

    open fun resetViewStates() {}

    abstract fun handleEvents(event: Event)
    fun consumeState() {
        setState { null }
    }

}
