package dev.minecraftbox.processor

import dev.minecraftbox.processor.processors.annotations.AnnotationProcessor
import dev.minecraftbox.processor.processors.events.EventProcessor

object BoxProcessors {
    fun createAnnotationProcessorInstance() = AnnotationProcessor()

    fun createEventProcessorInstance() = EventProcessor()
}