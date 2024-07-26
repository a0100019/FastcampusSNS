package com.example.presentation.main.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog

@Composable
fun UsernameDialog(
    visible : Boolean,
    username : String,
    onUsernameChange : (String) -> Unit,
    onDismissRequest : () -> Unit,
) {
    if(visible) {
        Dialog(onDismissRequest = onDismissRequest) {

            Surface {
                Column(modifier = Modifier.fillMaxWidth(0.8f)) {

                }
            }
        }
    }
}