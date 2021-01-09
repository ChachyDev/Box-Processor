package dev.minecraftbox.processor.tests

import dev.minecraftbox.processor.BoxProcessors
import dev.minecraftbox.processor.processors.annotations.FunctionType
import org.junit.Test

class ProcessorTests {
    @Test
    fun `Test Annotation Processor to Box`() {
        val processor = BoxProcessors.createAnnotationProcessorInstance()
        val annotation = processor.processToBox("Mod.EventHandler")
        println(annotation)
        assert(annotation == "InvokeEvent")
    }

    @Test
    fun `Test Event Processor To Box`() {
        val processor = BoxProcessors.createEventProcessorInstance()
        val event = processor.processToBox("FMLInitializationEvent")
        println(event)
        assert(event == "InitializationEvent")
    }

    @Test
    fun `Test Annotation Processor to Forge`() {
        val processor = BoxProcessors.createAnnotationProcessorInstance()
        val annotation = processor.processToOtherModloader("InvokeEvent", null)
        println(annotation)
        assert(annotation == "SubscribeEvent")
    }

    @Test
    fun `Test Event Processor To Forge`() {
        val processor = BoxProcessors.createEventProcessorInstance()
        val event = processor.processToOtherModloader("InitializationEvent", null)
        println(event)
        assert(event == "FMLInitializationEvent")
    }

    @Test
    fun `Test Annotation Processor to Forge with ModEventHandler`() {
        val processor = BoxProcessors.createAnnotationProcessorInstance()
        val annotation = processor.processToOtherModloader("InvokeEvent", FunctionType.ModEventHandler)
        println(annotation)
        assert(annotation == "Mod.EventHandler")
    }
}