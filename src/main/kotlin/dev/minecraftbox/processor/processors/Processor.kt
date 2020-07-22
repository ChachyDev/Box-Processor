package dev.minecraftbox.processor.processors

import dev.minecraftbox.processor.processors.annotations.FunctionType
import dev.minecraftbox.processor.utils.second
import java.io.InputStream

interface Processor {
    fun processToForge(boxType: String, functionType: FunctionType?): String?

    fun processToBox(forgeType: String): String?

    fun InputStream.processFile() =
            this
                    .bufferedReader()
                    .readText()
                    .split("\n")
                    .filter { it.isNotEmpty() }
                    .map { it.split(" ") }
                    .map { it.first() to (it.second() ?: error("Could not find value for ${it.first()}")) }
}