package dev.minecraftbox.processor.tests

import dev.minecraftbox.processor.BoxProcessors
import dev.minecraftbox.processor.processors.annotations.FunctionType
import org.junit.Test

class ProcessorTests {
    @Test
    fun `Test Annotation Processor to Box`() {
        val processor = BoxProcessors.createAnnotationProcessorInstance()
        val annotation = processor.processToBox("Mod.EventHandler")
        assert(annotation == "InvokeEvent")
    }

    @Test
    fun `Test Event Processor To Box`() {
        val processor = BoxProcessors.createEventProcessorInstance()
        val event = processor.processToBox("FMLInitializationEvent")
        assert(event == "InitializationEvent")
    }

    @Test
    fun `Test Annotation Processor to Forge`() {
        val processor = BoxProcessors.createAnnotationProcessorInstance()
        val annotation = processor.processToForge("InvokeEvent", null)
        assert(annotation == "SubscribeEvent")
    }

    @Test
    fun `Test Event Processor To Forge`() {
        val processor = BoxProcessors.createEventProcessorInstance()
        val event = processor.processToForge("InitializationEvent", null)
        assert(event == "FMLInitializationEvent")
    }

    @Test
    fun `Test Annotation Processor to Forge with FMLINIT`() {
        val processor = BoxProcessors.createAnnotationProcessorInstance()
        val annotation = processor.processToForge("InvokeEvent", FunctionType.ModEventHandler)
        assert(annotation == "Mod.EventHandler")
    }
}