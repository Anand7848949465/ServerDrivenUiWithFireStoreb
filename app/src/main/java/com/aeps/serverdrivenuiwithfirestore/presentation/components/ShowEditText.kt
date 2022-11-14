package com.aeps.serverdrivenuiwithfirestore.presentation.components

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.lifecycle.LifecycleCoroutineScope
import com.aeps.serverdrivenuiwithfirestore.domain.model.Data
import com.aeps.serverdrivenuiwithfirestore.presentation.ServerDrivenUiViewModel
import com.aeps.serverdrivenuiwithfirestore.presentation.SetViewInUI

@Composable
fun ShowEditText(
    value: Data,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope,
) {

    val tag = value.TAG

    var text = ""
    if (tag == "1") {
        text = viewModel.aadharNo.value
    } else if (tag == "2") {
        text = viewModel.vidNo.value
    }

    OutlinedTextField(value = text, onValueChange = {
        if (tag == "1") {
            viewModel.updateAadharNo(it)
        } else if (tag == "2") {
            viewModel.updateVid(it)
        }
    })

}

@Composable
fun ShowButton(
    value: Data,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope,
) {
    Button(onClick = {
        if (value.TAG == "1") {
            Toast.makeText(applicationContext, viewModel.aadharNo.value, Toast.LENGTH_SHORT).show()
        } else if (value.TAG == "2") {
            Toast.makeText(applicationContext, viewModel.vidNo.value, Toast.LENGTH_SHORT).show()
        }
    }) {
        SetViewInUI(
            data = value.children,
            applicationContext = applicationContext,
            viewModel = viewModel,
            lifecycleScope = lifecycleScope
        )
    }

}

fun ff(key: Int = 0, applicationContext: Context) {
    if (key == 0) {
        jj()
    } else if (key == 1) {
        Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
    }
}

fun jj() {

}