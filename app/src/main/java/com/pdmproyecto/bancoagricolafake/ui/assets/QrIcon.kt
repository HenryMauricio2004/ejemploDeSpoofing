package com.pdmproyecto.bancoagricolafake.ui.assets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pdmproyecto.bancoagricolafake.R

@Composable
fun QrIcon() {
    Image(
        painter = painterResource(id = R.drawable.qr_icon),
        contentDescription = "QR Icon",
        modifier = Modifier.size(48.dp)
    )
}