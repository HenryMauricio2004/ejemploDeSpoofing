package com.pdmproyecto.bancoagricolafake.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdmproyecto.bancoagricolafake.R
import com.pdmproyecto.bancoagricolafake.ui.assets.QrIcon
import com.pdmproyecto.bancoagricolafake.ui.components.CuentaTarjeta
import com.pdmproyecto.bancoagricolafake.ui.components.MiQrButton

@Preview
@Composable
fun Menu() {

    Box(
        modifier = Modifier.background(color = Color.White).fillMaxSize()
    ){

        Image(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .graphicsLayer(
                    scaleX = 0.75f,
                    scaleY = 0.75f,
                    transformOrigin = TransformOrigin(0f, 1f) // esquina inferior izquierda
                )
                .padding(bottom = 150.dp),
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = ""
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
        ){

            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(Icons.Default.Notifications, contentDescription = "notificacion", tint = Color.Black)

                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo Banco Agrícola",
                        modifier = Modifier
                            .weight(1f)
                            .heightIn(max = 80.dp)
                            .padding(vertical = 8.dp)
                    )

                    MiQrButton({},
                        modifier =
                        Modifier
                            .weight(1f)
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .height(45.dp))
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(Icons.Default.Add, contentDescription = "más", tint = Color.Black)
                    Text(text = "Tienes productos disponibles", color = Color.Black)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text( modifier = Modifier.padding(15.dp),text = "Cuetas", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Box(modifier = Modifier.fillMaxWidth().height(2.dp).background(color = Color.Yellow))
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(modifier = Modifier.padding(15.dp),text = "Tarjetas", fontSize = 20.sp, fontWeight = FontWeight.Light)
                        Box(modifier = Modifier.fillMaxWidth().height(2.dp).background(color = Color.Black))
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(modifier = Modifier.padding(15.dp),text = "Metas", fontSize = 20.sp, fontWeight = FontWeight.Light)
                        Box(modifier = Modifier.fillMaxWidth().height(2.dp).background(color = Color.Black))
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth().padding(15.dp)
                ) {
                    CuentaTarjeta();
                }

            }



        }

        Box(
            modifier = Modifier
                .padding(20.dp)
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.Yellow)
                .align(Alignment.BottomEnd)
                ,
            contentAlignment = Alignment.Center
        ){
            QrIcon()
        }

    }



}