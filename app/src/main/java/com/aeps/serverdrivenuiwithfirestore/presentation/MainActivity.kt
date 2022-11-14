package com.aeps.serverdrivenuiwithfirestore.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.aeps.serverdrivenuiwithfirestore.component.DataState
import com.aeps.serverdrivenuiwithfirestore.domain.model.Data
import com.aeps.serverdrivenuiwithfirestore.domain.model.ServerDrivenUiEntity
import com.aeps.serverdrivenuiwithfirestore.domain.model.Type
import com.aeps.serverdrivenuiwithfirestore.presentation.components.*
import com.aeps.serverdrivenuiwithfirestore.presentation.theme.ui.ServerDrivenUiWithFireStoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val sduiViewModel: ServerDrivenUiViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServerDrivenUiWithFireStoreTheme {
                when (val sduiResponse = sduiViewModel.sduiResponse) {
                    is DataState.Loading -> {
                    }
                    is DataState.Success -> {
                        val data: List<ServerDrivenUiEntity> = sduiResponse.data
                        data.forEach {
                            val newData = it.data
                            SetViewInUI(
                                data = newData,
                                applicationContext = applicationContext,
                                viewModel = sduiViewModel,
                                lifecycleScope = lifecycleScope
                            )
                            Log.d("firedata", newData.toString())
                        }

                    }
                    is DataState.Error -> {

                    }
                }
            }
        }
    }
}

@Composable
fun SetViewInUI(
    data: List<Data>,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {
    data.forEach { value ->
        CheckUiType(value, applicationContext, viewModel, lifecycleScope)
    }
}

@Composable
fun CheckUiType(
    value: Data,
    applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {
    when (value.type) {
//        Type.SCAFFOLD -> showScaffold(value = value, applicationContext, viewModel, lifecycleScope)
        Type.TEXT -> ShowText(value = value, applicationContext, viewModel, lifecycleScope)
        Type.TOPBAR -> TopActionBar(value = value, applicationContext, viewModel, lifecycleScope)
        Type.SURFACE -> ShowSurface(value = value, applicationContext, viewModel, lifecycleScope)
//        Type.IMAGE -> ImageView(value = value, applicationContext, viewModel, lifecycleScope)
//        Type.VERTICAL_LIST -> verticalList(
//            value = value,
//            applicationContext,
//            viewModel,
//            lifecycleScope
//        )
//        Type.HORIZONTAL_LIST -> horizontalList(
//            value = value,
//            applicationContext,
//            viewModel,
//            lifecycleScope
//        )
        Type.ROW -> ShowRow(value = value, applicationContext, viewModel, lifecycleScope)
        Type.ICONBUTTON -> ShowIconButton(
            value = value,
            applicationContext,
            viewModel,
            lifecycleScope
        )
        Type.BOX -> ShowBox(value = value, applicationContext, viewModel, lifecycleScope)
        Type.COLUMN -> columnView(value = value, applicationContext, viewModel, lifecycleScope)
        Type.EDIT_TEXT -> ShowEditText(value = value, applicationContext, viewModel, lifecycleScope)
        Type.BUTTON -> ShowButton(value = value, applicationContext, viewModel, lifecycleScope)
        Type.UNKNOWN -> Spacer(modifier = Modifier.requiredSize(0.dp))
    }
}

@Composable
private fun showText(
    value: Data, applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {
    Text(
        text = "${value.value}",
    )
}

@Composable
private fun columnView(
    value: Data, applicationContext: Context,
    viewModel: ServerDrivenUiViewModel,
    lifecycleScope: LifecycleCoroutineScope
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        SetViewInUI(
            data = value.children,
            applicationContext = applicationContext,
            viewModel = viewModel,
            lifecycleScope = lifecycleScope
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ServerDrivenUiWithFireStoreTheme {

    }
}