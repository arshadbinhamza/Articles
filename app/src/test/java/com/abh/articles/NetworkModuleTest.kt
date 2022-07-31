package com.abh.articles

import org.junit.Assert
import org.junit.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.Charset

class NetworkModuleTest {

        @Test
        fun testAvailability() {

            var isSuccess = false

            try {

                val connection = URL("https://run.mocky.io/v3/bd74f149-ee6f-466e-a602-dc6b0c780513").openConnection()
                val response = connection.getInputStream()
                val buffer = StringBuffer()
                BufferedReader(InputStreamReader(response, Charset.defaultCharset())).use { reader ->

                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        buffer.append(line)
                    }
                }

                isSuccess = buffer.isNotEmpty()
            }
            catch (ignored: Exception) {

            }

            Assert.assertEquals(true, isSuccess)
        }

    }