package com.akanbi.chucknorris.domain.exception

import java.lang.Exception

class FactEmptyException(override val message: String) : Exception(message) {
}