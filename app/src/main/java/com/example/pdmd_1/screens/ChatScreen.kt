package com.example.pdmd_1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pdmd_1.R


@Composable
fun ChatScreen(navController: NavController, nombre :String?){
    ChatBody(navController, nombre)
}

@Composable
fun ChatBody(navController: NavController, nombre: String?){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.Fondo))

    ){

        Titulo(navController, nombre)

        Chat()

        Teclado()

    }
}

@Composable
fun Titulo(navController: NavController, nombre: String?){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.ColorTituloEscribir))
            .height(70.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .background(Color.Transparent)
                .size(20.dp)
                .clickable {
                    navController.popBackStack()
                },
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(40.dp)
        )
        Spacer(Modifier.width(5.dp))
        Text(
            text = nombre ?: "Contacto No agregado",
            fontSize = 18.sp,
            color = Color.White
        )
        Spacer(Modifier.width(175.dp))
        Icon(
            painter = painterResource(R.drawable.videocam_24dp_0000000_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            Modifier.size(30.dp),
            tint = Color.White
        )
        Spacer(Modifier.width(10.dp))
        Icon(
            imageVector = Icons.Default.Call ,
            contentDescription = null,
            Modifier.size(30.dp),
            tint = Color.White
        )
        Spacer(Modifier.width(5.dp))
        Icon(
            imageVector =  Icons.Default.MoreVert,
            contentDescription = null,
            Modifier.size(30.dp),
            tint = Color.White
        )
    }


}

@Composable
fun Teclado(){



    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(50.dp))
            ,
        verticalAlignment = Alignment.CenterVertically
    )
    {

        BarraParaEscribir()

        Spacer(Modifier.width(20.dp))

        BotonAudio()



    }


}


@Composable
fun BarraParaEscribir(){

    Row (

        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(40.dp)
            .background(colorResource(R.color.ColorTituloEscribir), RoundedCornerShape(30.dp))
            .width(300.dp)
            .padding(5.dp)

    ) {


        Icon(
            painter = painterResource(R.drawable.sentiment_satisfied_24dp_0000000_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier
                .size(20.dp)
        )

        Spacer(Modifier.width(10.dp))

        Text(text = "Mensaje", color = Color.White)
        Spacer(Modifier.width(140.dp))
        Icon(
            painter = painterResource(R.drawable.attach_file_24dp_0000000_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.width(5.dp))
        Icon(
            painter = painterResource(R.drawable.photo_camera_24dp_ffffff_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier.size(20.dp)
        )

    }

}

@Composable
fun BotonAudio(){

    Box(
        modifier = Modifier
            .size(40.dp)
            .background(colorResource(R.color.BotonAudio), RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(R.drawable.mic_24dp_0000000_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
    }

}

@Composable
fun Chat(){

    Column(
         modifier = Modifier
             .verticalScroll(rememberScrollState(0))
             .fillMaxWidth()
             .height(690.dp)
             .padding(5.dp)
             ,

    ) {

        MensajeEntrante("Hola")
        MensajeSaliente("Hola")
        MensajeEntrante("Q tal")
        MensajeSaliente("Bn")
        MensajeEntrante("Q haces")
        MensajeSaliente("Nada")

    }

}

@Composable
fun MensajeSaliente(mensaje: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Spacer(Modifier.width(230.dp))
        Box(

            modifier = Modifier
                .background(
                    colorResource(R.color.ColorMensajes),
                    RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp)
                )
                .width(150.dp)
                .height(60.dp)
                .padding(top = 10.dp, start = 10.dp, end = 5.dp, bottom = 5.dp)


        ){

            Column {
                Text(text = mensaje, color = Color.White, fontSize = 18.sp)
                EstadoMensaje(true)
            }


        }
    }
    Spacer(Modifier.height(5.dp))

}

@Composable
fun EstadoMensaje(saliente: Boolean){

    if (saliente) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
        ) {

            Text("20:19", color = Color.Black)
            Spacer(Modifier.width(2.dp))
            Icon(
                painter = painterResource(R.drawable.done_all_24dp_0000000_fill0_wght400_grad0_opsz24),
                contentDescription = null,
                modifier = Modifier
                    .size(15.dp)
            )

        }
    }
    else{
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {

            Text("20:19", color = Color.White, modifier = Modifier.fillMaxHeight())
        }
    }

}

@Composable
fun MensajeEntrante(mensaje: String){

    Row(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {

        Box(

            modifier = Modifier
                .background(
                    colorResource(R.color.boton),
                    RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomEnd = 20.dp)
                )
                .width(150.dp)
                .wrapContentHeight()
                .padding(top = 10.dp, start = 10.dp, end = 5.dp, bottom = 5.dp)


        ){

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(60.dp),
            ) {
                Text(text = mensaje, color = Color.White, fontSize = 18.sp, softWrap = true)
                EstadoMensaje(true)
            }


        }
    }
    Spacer(Modifier.height(5.dp))
}