package dev.minecraftbox.processor.processors.events

import dev.minecraftbox.processor.processors.Processor
import dev.minecraftbox.processor.processors.annotations.FunctionType
import dev.minecraftbox.processor.utils.second

class EventProcessor(mappings: String) : Processor {
    private val events = this::class.java
            .getResourceAsStream(mappings)
            .processFile()

    override fun processToOtherModloader(boxType: String, functionType: FunctionType?) =  events.find { it.second == boxType }?.first

    override fun processToBox(forgeType: String) =  events.find { it.first == forgeType }?.second
}