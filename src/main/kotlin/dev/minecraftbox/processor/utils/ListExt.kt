package dev.minecraftbox.processor.utils

fun <T> List<T>.second() : T? = try {
    get(1)
} catch (e: ArrayIndexOutOfBoundsException) {
    null
}