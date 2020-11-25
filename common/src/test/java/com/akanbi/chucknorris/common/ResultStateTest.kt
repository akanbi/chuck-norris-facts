package com.akanbi.chucknorris.common

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Given ResultState")
internal class ResultStateTest {

    @Nested
    @DisplayName("When create flow Success")
    inner class Success {

        @Test
        fun `should create flow Success with string content`() {
            val result = ResultState.Success("isSuccess")

            assertEquals("isSuccess", result.data)
        }

        @Test
        fun `should create flow Success with boolean`() {
            val result = ResultState.Success(true)

            assertTrue(result.data)
        }

    }

    @Nested
    @DisplayName("When create flow Error")
    inner class Error {
        @Test
        fun `should create flow error with null pointer exception`() {
            val result = ResultState.Error(NullPointerException("NullPointerException"))

            assertTrue(result.exception is NullPointerException)
            assertEquals("NullPointerException", result.exception.message)
        }
    }

}