package dev.minecraftbox.processor.processors

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import dev.minecraftbox.processor.processors.annotations.FunctionType
import dev.minecraftbox.processor.utils.second
import java.io.InputStream

val reader = csvReader()

interface Processor {
    fun processToForge(boxType: String, functionType: FunctionType?): String?

    fun processToBox(forgeType: String): String?

    fun InputStream.processFile() = reader
        .readAll(this)
        .map { it[0] to it[1] }
}