package tv.rings.domain.commands

interface Command<out T> {
    fun execute(): T
}