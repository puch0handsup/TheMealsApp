package com.example.themealsapp.utils

class NullResponse(message: String = "Meals response is null. Check Your Internet Connection"): Exception(message)
class FailureResponse(message: String?): Exception(message)