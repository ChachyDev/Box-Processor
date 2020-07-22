package dev.minecraftbox.processor.processors.annotations

import dev.minecraftbox.processor.processors.Processor
import dev.minecraftbox.processor.utils.second


class AnnotationProcessor : Processor {
    private val annotations = this::class.java
            .getResourceAsStream("/annotations.bmap")
            .processFile()

    override fun processToForge(boxType: String, functionType: FunctionType?) : String? {
        val annotations = annotations.filter { it.second == boxType }

        if (annotations.size > 1) {
            return if ((functionType ?: FunctionType.Normal) == FunctionType.Normal) {
                annotations.firstOrNull()?.first
            } else {
                annotations.second()?.first
            }
        }
        return annotations.firstOrNull()?.first
    }

    override fun processToBox(forgeType: String) =  annotations.find { it.first == forgeType }?.second
}

enum class FunctionType {
    ModEventHandler,
    Normal
}