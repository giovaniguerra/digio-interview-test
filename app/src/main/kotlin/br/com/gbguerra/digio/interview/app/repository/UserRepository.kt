package br.com.gbguerra.digio.interview.app.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class UserRepository {

    fun getUser(): Flow<String> = flowOf(FAKE_USER_NAME)

    companion object {
        private const val FAKE_USER_NAME = "Maria"
    }

}