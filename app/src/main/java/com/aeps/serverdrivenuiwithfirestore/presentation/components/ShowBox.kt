package com.aeps.serverdrivenuiwithfirestore.presentation.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LifecycleCoroutineScope
import com.aeps.serverdrivenuiwithfirestore.domain.model.Data
import com.aeps.serverdrivenuiwithfirestore.presentation.ServerDrivenUiViewModel
import com.aeps.serverdrivenuiwithfirestore.presentation.SetViewInUI

@Composable
fun ShowBox(
    value: Data,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {
        SetViewInUI(
            data = value.children,
            applicationContext = applicationContext,
            viewModel = viewModel,
            lifecycleScope = lifecycleScope
        )
    }
}