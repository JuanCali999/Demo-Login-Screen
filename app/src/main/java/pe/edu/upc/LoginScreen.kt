package pe.edu.upc.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    val username = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember { mutableStateOf(false)}

    Scaffold { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)) {
            OutlinedTextField(
                modifier = modifier.fillMaxWidth().padding(8.dp),
                placeholder = { Text("Username") },
                value = username.value,
                trailingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "null")
                },
                onValueChange = {
                    username.value = it
                }
            )
            OutlinedTextField(
                modifier = modifier.fillMaxWidth().padding(8.dp),
                placeholder = {
                    Text("Password")
                },
                value = password.value,
                onValueChange = {password.value = it},
                visualTransformation = if (passwordVisible.value) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible.value) Icons.Default.VisibilityOff
                    else Icons.Default.Visibility
                    IconButton(onClick = {
                        passwordVisible.value = !passwordVisible.value
                    }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                    Icon(Icons.Default.Visibility, contentDescription = null)
                },

            )
            Button(
                onClick = {
                }
            ) {
                Text("Login")
            }
        }
    }
}
