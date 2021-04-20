package com.akanbi.chucknorris.domain.converter

import com.akanbi.chucknorris.domain.model.response.FactListResponse
import com.akanbi.chucknorris.domain.model.response.FactResponse
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ListFactConverterTest {

    private val converter: ListFactConverter = ListFactConverter()

    @Nested
    @DisplayName("When do convert factListResponse to List facts")
    inner class DoConvert {

        @Test
        fun `should convert factListResponse to List facts with three elements`() {
            val responseToConvert = FactListResponse(arrayListOf(buildFactResponse("1"), buildFactResponse("2"), buildFactResponse("3")))
            val result = converter.convert(responseToConvert)

            assertNotNull(result)
            assertEquals(3, result.size)
            assertEquals("fact 1", result[0].factDescription)
            assertEquals("fact 2", result[1].factDescription)
            assertEquals("fact 3", result[2].factDescription)
        }

        @Test
        fun `should convert factListResponse to List facts with zero elements`() {
            val responseToConvert = FactListResponse(arrayListOf())
            val result = converter.convert(responseToConvert)

            assertNotNull(result)
            assertTrue(result.isEmpty())
        }

        private fun buildFactResponse(value: String): FactResponse =
                FactResponse(id = value, fact = "fact $value", iconUrl = "iconUrl $value", url = "url $value")

    }

}