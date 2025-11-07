package org.example.project.ui.screen.login.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(viewModel: LoginViewModel = LoginViewModel()){
    val state = viewModel.state
    val messages = when{
        state.loggerIn -> "Success"
        state.errorMessages != null -> state.errorMessages
        else -> null
    }

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            isError = messages != null,
            singleLine = true, //Limita el texto a una sola linea
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, //muestra @ en el teclado
                imeAction = ImeAction.Next // cuando pongo enter salta al siguiente campo
            )
        )
        var isPasswordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            isError = messages != null,
            visualTransformation = if (isPasswordVisible)
                VisualTransformation.None else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector =
                            if(isPasswordVisible)
                                Icons.Default.VisibilityOff
                            else Icons.Default.Visibility,
                        contentDescription =
                            if (isPasswordVisible)
                                "Hide password"
                            else "Show password")
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions {
                viewModel.login(username, password)
            }
        )
        Button(onClick = { viewModel.login(username, password) }) {
            Text("Login")
        }
    }
}