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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pdmd_1.R
import com.example.pdmd_1.navigation.AppScreens

/**
 * Pantalla principal de la aplicación que contiene la estructura general de la interfaz.
 *
 * La pantalla principal incluye la cabecera, la lista de chats y el pie de página.
 * Además, esta pantalla utiliza un `NavController` para navegar entre diferentes pantallas.
 *
 * @param navController El controlador de navegación utilizado para gestionar la navegación entre pantallas.
 */
@Composable
fun MainScreen(navController: NavController) {
    MainBody(navController)
}

/**
 * Cuerpo principal de la pantalla que contiene los diferentes componentes.
 *
 * La función organiza la interfaz con una cabecera, una lista de chats y un pie de página, dentro de una columna
 * con un fondo personalizado.
 *
 * @param navController El controlador de navegación utilizado para gestionar la navegación entre pantallas.
 */
@Composable
fun MainBody(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.Fondo))
    ) {
        Cabecera()
        Lista(navController)
        Footer()
    }
}

/**
 * Representa un mensaje en la lista de chats, contiene un nombre y el mensaje asociado.
 *
 * @param name El nombre del usuario que envió el mensaje.
 * @param msg El contenido del mensaje.
 */
data class Mensaje(val name: String, val msg: String)

/**
 * Lista de mensajes predeterminados para mostrar en la interfaz.
 */
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

/**
 * Lista de botones de filtrado que se pueden seleccionar en la interfaz.
 */
private val botones = listOf("Todos", "Favoritos", "No Leidos", "Grupos")

/**
 * Cabecera de la pantalla principal que contiene el título de la app y los iconos de opciones.
 *
 * Incluye el nombre de la app y botones de cámara, búsqueda y opciones.
 */
@Composable
fun Cabecera() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.07f)
        .background(colorResource(R.color.ColorTituloEscribir))
    ) {
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
            Spacer(Modifier.width(190.dp))
            Image(
                painter = painterResource(R.drawable.photo_camera_24dp_ffffff_fill0_wght400_grad0_opsz24),
                contentDescription = null,
                modifier = Modifier.size(23.dp)
            )
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = stringResource(R.string.options),
                tint = Color.White
            )
            Spacer(Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = stringResource(R.string.options),
                tint = Color.White,
                modifier = Modifier.height(24.dp)
            )
        }
    }
}

/**
 * Lista de chats que incluye los filtros y los mensajes.
 *
 * Muestra los botones de filtrado y luego la lista de chats con sus respectivos mensajes.
 *
 * @param navController El controlador de navegación utilizado para gestionar la navegación entre pantallas.
 */
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

/**
 * Muestra los chats en la interfaz.
 *
 * Itera sobre la lista de mensajes para mostrar cada uno en un `Chat` individual, el cual es clickable.
 *
 * @param navController El controlador de navegación utilizado para gestionar la navegación entre pantallas.
 */
@Composable
fun MisChats(navController: NavController) {
    Column(
        Modifier.fillMaxWidth()
            .verticalScroll(rememberScrollState(0))
    ) {
        mensajes.forEach {
            Chat(it, navController)
        }
    }
}

/**
 * Componente para mostrar la información básica de un chat, como el nombre y el mensaje.
 *
 * @param mensaje El objeto `Mensaje` que contiene el nombre del usuario y el contenido del mensaje.
 */
@Composable
fun MisTextos(mensaje: Mensaje) {
    Column(
        modifier = Modifier.fillMaxHeight()
            .width(70.dp)
    ) {
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

/**
 * Componente para cada chat en la lista. Muestra un icono de usuario, el mensaje y la hora del mensaje.
 * Al hacer clic en el chat, se navega a la pantalla de chat individual.
 *
 * @param mensaje El objeto `Mensaje` que contiene los datos del chat.
 * @param navController El controlador de navegación utilizado para gestionar la navegación entre pantallas.
 */
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
        Text(text = "20:20", color = Color.Gray, modifier = Modifier.align(Alignment.Top))
    }
    Spacer(modifier = Modifier.height(20.dp))
}

/**
 * Componente para los botones de filtrado en la interfaz principal, como "Favoritos", "No Leídos", etc.
 *
 * @param texto El texto que se mostrará en el botón de filtrado.
 */
@Composable
fun BotonesFiltrado(texto: String) {
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

/**
 * Muestra los botones de filtrado de la interfaz principal (como "Todos", "Favoritos").
 */
@Composable
fun MisBotones() {
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

/**
 * Pie de página de la pantalla principal con los botones de navegación (Chats, Estados, Comunidades, Llamadas).
 */
@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
            .background(colorResource(R.color.ColorTituloEscribir))
            .padding(top = 1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Cada columna representa un ícono con su nombre correspondiente.
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
            // Repetir columnas para cada botón de navegación (Estados, Comunidades, Llamadas).
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



