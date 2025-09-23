package com.pdmproyecto.bancoagricolafake.ui.pages


import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmproyecto.bancoagricolafake.API.ApiService
import com.pdmproyecto.bancoagricolafake.API.RetrofitInstance
import com.pdmproyecto.bancoagricolafake.R
import com.pdmproyecto.bancoagricolafake.models.LoginRequest
import com.pdmproyecto.bancoagricolafake.ui.components.UnderlinedTextField
import kotlinx.coroutines.launch


@Composable
fun LogIn(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    var checked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(Icons.Default.Call, contentDescription = "Teléfono", tint = Color.Black)

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Banco Agrícola",
                modifier = Modifier
                    .heightIn(max = 80.dp)
                    .padding(vertical = 8.dp)
            )

            Icon(Icons.Default.Email, contentDescription = "Mensaje", tint = Color.Black)
        }

        Text(
            text = "Bienvenido a la aplicación de Bancoagrícola",
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            textAlign = TextAlign.Center,
        )

        Column(
            modifier = Modifier.weight(1f).padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Usuario", color = Color.Black, fontWeight = FontWeight.Medium)
                UnderlinedTextField(
                    value = username,
                    onValueChange = { username = it }
                )

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = checked,
                        onCheckedChange = {checked != checked},
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Black,
                            uncheckedColor = Color.Black,
                            checkmarkColor = Color.Black
                        )
                    )
                    Text(text = "Recordar Usuario")
                }


                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Clave",color = Color.Black, fontWeight = FontWeight.Medium)
                UnderlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    isPassword = true
                )
            }

            Spacer(modifier = Modifier.height(45.dp))

            Button(
                onClick = {
                    scope.launch {
                        try {
                            val api = RetrofitInstance.retrofit.create(ApiService::class.java)
                            val response = api.login(
                                LoginRequest(
                                    usuario = username,
                                    clave = password
                                )
                            )
                        } catch (e: Exception) {
                        }

                        navController.navigate("menu") {
                            popUpTo("login") { inclusive = true } // borra login del backstack
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFD740),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text("CONTINUAR", fontWeight = FontWeight.Bold)
            }
        }


        Button(
            onClick = { /*instrucciones de clave dinamica (no importan para esta demo asi que no hay nada aca)*/},
            modifier = Modifier
                .fillMaxWidth()
                .height(84.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            shape = RectangleShape
        ) {
            Icon(Icons.Default.Lock, contentDescription = "Clave dinámica")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Clave Dinámica", fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Ir")
        }
    }
}
