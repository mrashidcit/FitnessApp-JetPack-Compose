package com.rashidsaleem.fitnessapp.core.domain.useCases

/**
 *
 * Used for input validated e.g. Password or Email TextField etc.
 * Or For any king of operation
 */
interface UseCase<out T, in U> {

    fun execute(params: U): T
}


/**
 *
 * Used for network operation or any kind of background processing
 */
interface SuspendableUseCase<out T, in U> {

    suspend fun execute(params: U): T
}

