package com.aeps.serverdrivenuiwithfirestore.domain.model

import androidx.compose.material.MaterialTheme
import java.util.ArrayList

class ServerDrivenUiEntity {
    val data: ArrayList<Data> = ArrayList()
}

data class Data(
    val children: ArrayList<Data> = ArrayList(),
//    val topBar: ArrayList<Data> = ArrayList(),
    var type: Type = Type.UNKNOWN,
    var value: String = "",
    var input: String = "",
    val size: Int = 14,
    val action: Action? = null,
    val TAG: String? = "",
)

data class Action(
    var url: String = "",
    var method: String = "",
    val bodies: ArrayList<String> = ArrayList(),
    val queries: ArrayList<String> = ArrayList(),
)

enum class Type {
    SCAFFOLD,
    TEXT,
    TOPBAR,
    IMAGE,
    VERTICAL_LIST,
    HORIZONTAL_LIST,
    ROW,
    COLUMN,
    EDIT_TEXT,
    SURFACE,
    ICONBUTTON,
    UNKNOWN,
    BOX,
    BUTTON
}
