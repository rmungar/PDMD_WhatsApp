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


/**
 * Pantalla principal del chat.
 *
 * @param navController Controlador de navegación utilizado para manejar la navegación entre pantallas.
 * @param nombre Nombre del usuario que se mostrará en el título del chat (puede ser nulo).
 */
@Composable
fun ChatScreen(navController: NavController, nombre: String?) {
    // Llama al cuerpo principal de la pantalla de chat.
    ChatBody(navController, nombre)
}

/**
 * Estructura principal de la pantalla de chat.
 *
 * @param navController Controlador de navegación utilizado para manejar la navegación entre pantallas.
 * @param nombre Nombre del usuario que se mostrará en el título del chat (puede ser nulo).
 *
 * Este composable organiza los siguientes componentes en una columna:
 * - [Titulo]: Muestra el encabezado con el nombre del usuario y navegación.
 * - [Chat]: Muestra la lista de mensajes del chat.
 * - [Teclado]: Incluye el área para escribir y enviar mensajes.
 */
@Composable
fun ChatBody(navController: NavController, nombre: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.Fondo))
    ) {
        // Encabezado del chat con el nombre del usuario.
        Titulo(navController, nombre)

        // Muestra el contenido principal del chat.
        Chat()

        // Campo de entrada de texto y botón para enviar mensajes.
        Teclado()
    }
}


/**
 * Encabezado de la pantalla de chat.
 *
 * @param navController Controlador de navegación utilizado para regresar a la pantalla anterior.
 * @param nombre Nombre del usuario con el que se está chateando (puede ser nulo).
 *
 * Este composable organiza los siguientes elementos en una fila:
 * - Un botón de retroceso para regresar a la pantalla anterior.
 * - Un ícono de perfil del usuario.
 * - El nombre del contacto o un texto por defecto si el nombre es nulo.
 * - Íconos de opciones adicionales (videollamada, llamada y menú).
 */
@Composable
fun Titulo(navController: NavController, nombre: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.ColorTituloEscribir))
            .height(70.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Botón de retroceso con ícono.
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .background(Color.Transparent)
                .size(20.dp)
                .clickable {
                    navController.popBackStack() // Regresa a la pantalla anterior.
                },
        )
        Spacer(modifier = Modifier.width(5.dp))

        // Ícono de perfil del usuario.
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(40.dp)
        )
        Spacer(Modifier.width(5.dp))

        // Texto con el nombre del usuario o un texto predeterminado.
        Text(
            text = nombre ?: "Contacto No agregado", // Muestra el nombre o un texto por defecto si es nulo.
            fontSize = 18.sp,
            color = Color.White
        )

        Spacer(Modifier.width(175.dp)) // Espaciador para alinear los íconos de opciones adicionales.

        // Ícono de videollamada.
        Icon(
            painter = painterResource(R.drawable.videocam_24dp_0000000_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            Modifier.size(30.dp),
            tint = Color.White
        )
        Spacer(Modifier.width(10.dp))

        // Ícono de llamada.
        Icon(
            imageVector = Icons.Default.Call,
            contentDescription = null,
            Modifier.size(30.dp),
            tint = Color.White
        )
        Spacer(Modifier.width(5.dp))

        // Ícono de menú.
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            Modifier.size(30.dp),
            tint = Color.White
        )
    }
}


/**
 * Barra inferior del chat que incluye un campo de texto y un botón de audio.
 *
 * Este composable organiza los elementos en una fila que ocupa el ancho completo
 * - [BarraParaEscribir]: Campo para que el usuario escriba mensajes.
 * - [BotonAudio]: Botón para enviar mensajes de voz.
 */
@Composable
fun Teclado() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(50.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Campo para escribir mensajes.
        BarraParaEscribir()


        Spacer(Modifier.width(20.dp))

        // Botón para grabar o enviar mensajes de voz.
        BotonAudio()
    }
}



/**
 * Barra de entrada de texto dentro del teclado del chat.
 *
 * Este composable organiza los elementos en una fila con un diseño estilizado que incluye:
 * - Un ícono de emoji a la izquierda.
 * - Un texto de marcador de posición ("Mensaje") que simula un campo de entrada.
 * - Íconos para adjuntar archivos y tomar fotos.
 */
@Composable
fun BarraParaEscribir() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(40.dp)
            .background(
                color = colorResource(R.color.ColorTituloEscribir),
                shape = RoundedCornerShape(30.dp)
            )
            .width(300.dp)
            .padding(5.dp)
    ) {

        // Ícono de emoji.
        Icon(
            painter = painterResource(R.drawable.sentiment_satisfied_24dp_0000000_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier.size(20.dp)
        )

        Spacer(Modifier.width(10.dp))

        // Texto de marcador de posición que simula un campo de entrada.
        Text(
            text = "Mensaje",
            color = Color.White
        )

        Spacer(Modifier.width(140.dp))

        // Ícono para adjuntar archivos.
        Icon(
            painter = painterResource(R.drawable.attach_file_24dp_0000000_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier.size(20.dp)
        )

        Spacer(Modifier.width(5.dp))

        // Ícono para tomar fotos.
        Icon(
            painter = painterResource(R.drawable.photo_camera_24dp_ffffff_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier.size(20.dp)
        )
    }
}


/**
 * Botón de audio para grabar o enviar mensajes de voz.
 *
 * Este composable crea un botón redondeado con un ícono de micrófono en su interior.
 * - El botón tiene un tamaño fijo y un color de fondo personalizado.
 * - El ícono del micrófono se encuentra centrado dentro del botón.
 */
@Composable
fun BotonAudio() {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                color = colorResource(R.color.BotonAudio),
                shape = RoundedCornerShape(20.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        // Ícono de micrófono.
        Icon(
            painter = painterResource(R.drawable.mic_24dp_0000000_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
    }
}


/**
 * Componente que muestra el historial de mensajes en el chat.
 *
 * Este composable crea una columna que contiene una lista de mensajes, que pueden ser entrantes o salientes.
 * - Los mensajes entrantes y salientes se representan por los composables [MensajeEntrante] y [MensajeSaliente].
 * - La columna es desplazable verticalmente para ver los mensajes anteriores.
 * - El tamaño de la columna está limitado a una altura fija de 690.dp y un ancho completo de la pantalla.
 */
@Composable
fun Chat() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .height(690.dp)
            .padding(5.dp)
    ) {
        // Mensajes de ejemplo.
        MensajeEntrante("Hola")
        MensajeSaliente("Hola")
        MensajeEntrante("Q tal")
        MensajeSaliente("Bn")
        MensajeEntrante("Q haces")
        MensajeSaliente("Nada")
    }
}


/**
 * Componente que representa un mensaje saliente en el chat.
 *
 * Este composable crea un mensaje que se alinea a la derecha de la pantalla con un fondo de color personalizado.
 * - El mensaje se muestra en un cuadro con bordes redondeados y un tamaño fijo.
 * - El mensaje tiene un texto y un estado que indica si fue enviado correctamente (en este caso, siempre `true`).
 * - El cuadro que contiene el mensaje tiene un relleno interno para alinear el texto y el estado correctamente.
 *
 * @param mensaje El texto del mensaje saliente que se mostrará.
 */
@Composable
fun MensajeSaliente(mensaje: String) {
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
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )
                .width(150.dp)
                .height(60.dp)
                .padding(
                    top = 10.dp,
                    start = 10.dp,
                    end = 5.dp,
                    bottom = 5.dp
                )
        ) {
            Column {

                Text(text = mensaje, color = Color.White, fontSize = 18.sp)

                EstadoMensaje(true)
            }
        }
    }
    Spacer(Modifier.height(5.dp)) // Espaciador para separar los mensajes.
}


/**
 * Muestra el estado de un mensaje, incluyendo la hora de envío y el estado de entrega (si es saliente).
 *
 * Este composable muestra la hora de envío del mensaje y un ícono de estado que indica si el mensaje fue entregado o leído.
 * - Para los mensajes salientes, se muestra un ícono de "entregado" o "leído" junto con la hora.
 * - Para los mensajes entrantes, solo se muestra la hora.
 *
 * @param saliente Si es `true`, muestra el estado de un mensaje saliente; de lo contrario, muestra solo la hora para los mensajes entrantes.
 */
@Composable
fun EstadoMensaje(saliente: Boolean) {

    if (saliente) {
        // Para mensajes salientes, muestra la hora y un ícono de estado.
        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
        ) {
            // Hora de envío del mensaje.
            Text("20:19", color = Color.Black)


            Spacer(Modifier.width(2.dp))

            // Ícono que indica que el mensaje fue entregado (icono de "hecho").
            Icon(
                painter = painterResource(R.drawable.done_all_24dp_0000000_fill0_wght400_grad0_opsz24),
                contentDescription = null,
                modifier = Modifier.size(15.dp)
            )
        }
    } else {
        // Para mensajes entrantes, solo muestra la hora.
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {

            Text("20:19", color = Color.White, modifier = Modifier.fillMaxHeight())
        }
    }
}


/**
 * Componente que representa un mensaje entrante en el chat.
 *
 * Este composable crea un mensaje que se alinea a la izquierda de la pantalla con un fondo de color personalizado.
 * - El mensaje se muestra en un cuadro con bordes redondeados y un tamaño fijo.
 * - El mensaje tiene un texto y un estado que indica si fue recibido correctamente.
 * - El cuadro que contiene el mensaje tiene un relleno interno para alinear el texto y el estado correctamente.
 *
 * @param mensaje El texto del mensaje entrante que se mostrará.
 */
@Composable
fun MensajeEntrante(mensaje: String) {

    Row(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {

        Box(
            modifier = Modifier
                .background(
                    colorResource(R.color.boton),
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .width(150.dp)
                .wrapContentHeight()
                .padding(
                    top = 10.dp,
                    start = 10.dp,
                    end = 5.dp,
                    bottom = 5.dp
                )
        ) {

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(60.dp),
            ) {
                // Muestra el texto del mensaje entrante.
                Text(text = mensaje, color = Color.White, fontSize = 18.sp, softWrap = true)
                // Muestra el estado del mensaje .
                EstadoMensaje(false)
            }
        }
    }
    Spacer(Modifier.height(5.dp))
}
