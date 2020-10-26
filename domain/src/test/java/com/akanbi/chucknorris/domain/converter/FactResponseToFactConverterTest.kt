package com.akanbi.chucknorris.domain.converter

import com.akanbi.chucknorris.data.model.FactResponse
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Given FactRespondeToFactConverter")
internal class FactResponseToFactConverterTest {

    private val converter: FactResponseToFactConverter = FactResponseToFactConverter()

    @Nested
    @DisplayName("When do convert factResponse to fact")
    inner class DoConvert {
        @Test
        fun `should converter model factResponse to fact with all fields filleds`() {
            val responseToConvert = FactResponse(id = "1", fact = "fact description", iconUrl = "iconUrl", url = "url")
            val result = converter.convert(responseToConvert)

            assertNotNull(result)
            assertEquals("fact description", result.factDescription)
            assertEquals("iconUrl", result.icon)
        }

        @Test
        fun `should converter model factResponse to fact with only field factDescription filled`() {
            val responseToConvert = FactResponse(id = "1", fact = "fact description", iconUrl = "", url = "url")
            val result = converter.convert(responseToConvert)

            assertNotNull(result)
            assertEquals("fact description", result.factDescription)
            assertTrue(result.icon.isBlank())
        }

        @Test
        fun `should converter model factResponse to fact with only field icon filled`() {
            val responseToConvert = FactResponse(id = "1", fact = "", iconUrl = "iconUrl", url = "url")
            val result = converter.convert(responseToConvert)

            assertNotNull(result)
            assertTrue(result.factDescription.isBlank())
            assertEquals("iconUrl", result.icon)
        }
    }
}