package com.example.pdmd_1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pdmd_1.R
import com.example.pdmd_1.navigation.AppScreens

@Composable

fun MainScreen(navController: NavController){
    MainBody(navController)
}

@Composable
fun MainBody(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.Fondo))
    ){

        Cabecera()

        Lista(navController)

        Footer()


    }
}

data class Mensaje(val name:String, val msg: String)

private val mensajes = listOf(
    Mensaje("Juan", "Hola"),
    Mensaje("Pepe", "Hola"),
    Mensaje("Fran", "Hola"),
    Mensaje("Paco", "Hola"),
    Mensaje("Jose", "Hola"),
    Mensaje("Luis", "Hola"),
    Mensaje("Alex", "Hola"),
    Mensaje("Pepa", "Hola"),
    Mensaje("Alberto", "Hola"),
    Mensaje("Cesar", "Hola"),
    Mensaje("Julio", "Hola"),
    Mensaje("J.J.", "Hola")
)

private val botones = listOf("Todos", "Favoritos", "No Leidos", "Grupos")


@Composable
fun Cabecera(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.07f)
        .background(colorResource(R.color.ColorTituloEscribir))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(10.dp))
            Text(
                color = Color.White,
                text = stringResource(R.string.whatsapp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

            )
            Spacer(Modifier.width(190.dp) )
            Image(
                painter = painterResource(R.drawable.photo_camera_24dp_ffffff_fill0_wght400_grad0_opsz24),
                contentDescription = null,
                modifier = Modifier.size(23.dp)
            )
            Spacer(Modifier.width(10.dp) )
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = stringResource(R.string.options),
                tint = Color.White
            )
            Spacer(Modifier.width(10.dp) )
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = stringResource(R.string.options),
                tint = Color.White,
                modifier = Modifier.height(24.dp)
            )
        }

    }
}

@Composable
fun Lista(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(695.dp)
            .wrapContentWidth()

    ) {
        Spacer(modifier = Modifier.height(10.dp))
        MisBotones()
        Spacer(modifier = Modifier.height(20.dp))
        MisChats(navController)
    }
}

@Composable
fun MisChats(navController: NavController){
    Column(
        Modifier.fillMaxWidth()
            .verticalScroll(rememberScrollState(0))
    ) {
        mensajes.forEach {
            Chat(it, navController)
        }
    }
}

@Composable
fun MisTextos(mensaje: Mensaje) {
    Column (
        modifier = Modifier.fillMaxHeight()
            .width(70.dp)
    ){
        Text(
            text = mensaje.name,
            color = Color.White,
            fontSize = 18.sp
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = mensaje.msg,
            color = colorResource(R.color.boton),
            fontSize = 14.sp
        )
    }
}

@Composable
fun Chat(mensaje: Mensaje, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable {
                navController.navigate(AppScreens.ChatScreen.route + "/${mensaje.name}")
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            tint = colorResource(R.color.imagenesUsuarios),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        MisTextos(mensaje)
        Spacer(Modifier.fillMaxWidth(0.80f))
        Text(text = "20:20", color = Color.Gray ,modifier = Modifier.align(Alignment.Top))

    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun BotonesFiltrado(texto: String){
    Button(
        modifier = Modifier
            .wrapContentSize()
            .wrapContentHeight(),
        colors = ButtonColors(
            containerColor = colorResource(R.color.boton),
            contentColor = colorResource(R.color.colorLetrasFiltros),
            disabledContentColor = colorResource(R.color.colorLetrasFiltros),
            disabledContainerColor = colorResource(R.color.boton)
        ),
        onClick = {}
    ) {
        Text(text = texto)
    }
    Spacer(Modifier.width(5.dp))
}

@Composable
fun MisBotones(){

    Row(
        modifier = Modifier.horizontalScroll(ScrollState(0))
            .padding(start = 5.dp)
            .wrapContentWidth()
    ) {
        botones.forEach {
            BotonesFiltrado(it)
        }
    }
}

@Composable
fun Footer(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
            .background(colorResource(R.color.ColorTituloEscribir))
            .padding(top = 1.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth()
        ){

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.chat_24dp_0000000_fill0_wght400_grad0_opsz24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text("Chats", color = Color.White, fontSize = 16.sp)
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.33f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.track_changes_24dp_0000000_fill0_wght400_grad0_opsz24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text("Estados", color = Color.White, fontSize = 16.sp)
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.groups_24dp_0000000_fill0_wght400_grad0_opsz24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text("Comunidades", color = Color.White, fontSize = 16.sp)
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text("Llamadas", color = Color.White, fontSize = 16.sp)
            }


        }
    }
}


