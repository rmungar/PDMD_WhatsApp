package com.example.pdmd_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row



import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle

import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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

import com.example.pdmd_1.ui.theme.PDMD_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PDMD_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize().background(Color.Black)) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier) {
    Column(modifier = Modifier

        .fillMaxSize()
        .background(colorResource(R.color.Fondo))
    ){

        Cabecera()
        Lista()
        Footer()

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PDMD_1Theme {
        Greeting(modifier = Modifier)
    }
}


@Composable
fun Cabecera(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .wrapContentHeight()
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 20.dp)
        ) {
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

fun Lista(){
    Column (
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentWidth()
            .verticalScroll(state = ScrollState(0))
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.padding(start = 10.dp)
                .horizontalScroll(state = ScrollState(0))
                .background(Color.Transparent)
            ,

            ){
            Button(
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight()
                ,
                colors = ButtonColors(
                    containerColor = colorResource(R.color.boton),
                    contentColor = colorResource(R.color.colorLetrasFiltros),
                    disabledContentColor = colorResource(R.color.colorLetrasFiltros),
                    disabledContainerColor = colorResource(R.color.boton)
                ),
                onClick = {}
            ) {
                Text(text = stringResource(R.string.Todos))
            }
            Spacer(Modifier.width(2.dp))
            Button(
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight()
                ,
                colors = ButtonColors(
                    containerColor = colorResource(R.color.boton),
                    contentColor = colorResource(R.color.colorLetrasFiltros),
                    disabledContentColor = colorResource(R.color.colorLetrasFiltros),
                    disabledContainerColor = colorResource(R.color.boton)
                ),
                onClick = {}
            ) {
                Text(text = stringResource(R.string.Grupos))
            }
            Spacer(Modifier.width(2.dp))
            Button(
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight()
                ,
                colors = ButtonColors(
                    containerColor = colorResource(R.color.boton),
                    contentColor = colorResource(R.color.colorLetrasFiltros),
                    disabledContentColor = colorResource(R.color.colorLetrasFiltros),
                    disabledContainerColor = colorResource(R.color.boton)
                ),
                onClick = {}
            ) {
                Text(text = stringResource(R.string.No_Leídos))
            }
            Spacer(Modifier.width(2.dp))
            Button(
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight()
                ,
                colors = ButtonColors(
                    containerColor = colorResource(R.color.boton),
                    contentColor = colorResource(R.color.colorLetrasFiltros),
                    disabledContentColor = colorResource(R.color.colorLetrasFiltros),
                    disabledContainerColor = colorResource(R.color.boton)
                ),
                onClick = {}
            ) {
                Text(text = stringResource(R.string.Favoritos))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona1),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona2),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona3),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona4),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona5),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona1),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona2),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona3),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona4),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona5),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = colorResource(R.color.imagenesUsuarios),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(R.string.persona1),
                color = Color.White
            )
        }
    }
}


@Composable

fun Footer(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
        ,



    ){}
}