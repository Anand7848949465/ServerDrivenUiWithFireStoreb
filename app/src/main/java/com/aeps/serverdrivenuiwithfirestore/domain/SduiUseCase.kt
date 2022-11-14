package com.aeps.serverdrivenuiwithfirestore.domain

import com.aeps.serverdrivenuiwithfirestore.domain.repository.ServerDrivenUiRepository
import javax.inject.Inject

class SduiUseCase @Inject constructor(
    private val serverDrivenUiRepository: ServerDrivenUiRepository
) {
    suspend operator fun invoke()=serverDrivenUiRepository.getServerDrivenUiData()
}