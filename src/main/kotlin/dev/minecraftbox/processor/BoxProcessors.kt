package dev.minecraftbox.processor

import dev.minecraftbox.processor.processors.annotations.AnnotationProcessor
import dev.minecraftbox.processor.processors.events.EventProcessor

object BoxProcessors {
    fun createAnnotationProcessorInstance(mappings: String = "/forge-annotations.csv") = AnnotationProcessor(mappings)

    fun createEventProcessorInstance(mappings: String = "/forge-events.csv") = EventProcessor(mappings)
}