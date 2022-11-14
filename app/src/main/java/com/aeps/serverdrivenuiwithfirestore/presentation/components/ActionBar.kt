package com.aeps.serverdrivenuiwithfirestore.presentation.components

import android.content.Context
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import com.aeps.serverdrivenuiwithfirestore.domain.model.Data
import com.aeps.serverdrivenuiwithfirestore.presentation.ServerDrivenUiViewModel
import com.aeps.serverdrivenuiwithfirestore.presentation.SetViewInUI

@Composable
fun TopActionBar(
    value: Data,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {
    SetViewInUI(
        data = value.children,
        applicationContext = applicationContext,
        viewModel = viewModel,
        lifecycleScope = lifecycleScope
    )
}

@Composable
fun ShowSurface(
    value: Data,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = Color.White
    ) {
        SetViewInUI(
            data = value.children,
            applicationContext = applicationContext,
            viewModel = viewModel,
            lifecycleScope = lifecycleScope
        )
    }
}

@Composable
fun ShowRow(
    value: Data,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SetViewInUI(
            data = value.children,
            applicationContext = applicationContext,
            viewModel = viewModel,
            lifecycleScope = lifecycleScope
        )
    }
}

@Composable
fun ShowText(
    value: Data,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {

    Text(
        text = value.value,
        fontSize = value.size.sp
    )
}

@Composable
fun ShowIconButton(
    value: Data,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back icon")
    }
}