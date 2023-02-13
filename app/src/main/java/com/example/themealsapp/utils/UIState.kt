package com.example.themealsapp.utils


sealed class UIState<T>(val data: T? = null, val message: String? = null) {
    class LOADING<T>(data: T? = null): UIState<T>(data)
    class SUCCESS<T>(data: T): UIState<T>()
    class ERROR<T>(data: T? = null, message: String): UIState<T>(data, message)
}
