package com.jzarsuelo.pokedex.util

sealed class Message(val message: String) {
    class ErrorMessage(message: String) : Message(message)
    class NormalMessage(message: String) : Message(message)
    class None() : Message("")
}