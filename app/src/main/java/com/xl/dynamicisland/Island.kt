package com.xl.dynamicisland

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * @Author : wyl
 * @Date : 2022/9/14
 * Desc :
 */
@Composable
fun defaultIsland(size: Size) {
    ConstraintLayout(
        modifier = Modifier.height(size.height.dp).width(size.width.dp)
            .background(Color.Black, shape = RoundedCornerShape(50.dp))
    ) {
        val island = createRef()
        Image(painter = painterResource(R.drawable.island),
            contentDescription = null,
            modifier = Modifier.constrainAs(island) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })
    }
}


@Composable
fun phoneIsLand(size: Size) {


    ConstraintLayout(
        modifier = Modifier.height(size.height.dp).width(size.width.dp)
            .background(Color.Black, shape = RoundedCornerShape(50.dp))
    ) {

        val (head, name, type, answer, hangup) = createRefs()

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.constrainAs(head) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }.padding(start = 10.dp).size(50.dp).clip(CircleShape)
        )

        Text("android", modifier = Modifier.constrainAs(type) {
            start.linkTo(head.end, margin = 5.dp)
            bottom.linkTo(head.bottom, 5.dp)
            top.linkTo(head.top)
        }, style = TextStyle(color = Color.LightGray))

        Text("Android开发那点事儿", modifier = Modifier.constrainAs(name) {
            start.linkTo(head.end, margin = 5.dp)
            bottom.linkTo(head.bottom)
        }, style = TextStyle(color = Color.White))


        Image(
            painter = painterResource(R.drawable.hangup),
            contentDescription = null,
            contentScale = ContentScale.None,
            modifier = Modifier.constrainAs(hangup) {
                end.linkTo(answer.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }.padding(start = 10.dp).size(50.dp).clip(CircleShape).background(Color.White)
        )


        Image(
            painter = painterResource(R.drawable.answer),
            contentDescription = null,
            contentScale = ContentScale.None,
            modifier = Modifier.constrainAs(answer) {
                end.linkTo(parent.end, margin = 10.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }.padding(start = 10.dp).size(50.dp).clip(CircleShape).background(Color.White)
        )
    }
}


@Composable
fun headsetIsland(size: Size) {
    ConstraintLayout(
        modifier = Modifier.height(size.height.dp).width(size.width.dp)
            .background(Color.Black, shape = RoundedCornerShape(50.dp))
    ) {

        val (airpods, electric) = createRefs()

        Image(painter = painterResource(R.drawable.airpods),
            contentDescription = null,
            contentScale = ContentScale.None,
            modifier = Modifier.constrainAs(airpods) {
                top.linkTo(parent.top, 5.dp)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start, 5.dp)
            })


        Image(painter = painterResource(R.drawable.electric),
            contentDescription = null,
            modifier = Modifier.constrainAs(electric) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end, margin = 10.dp)
            })
    }
}

@Composable
fun faceIsland(size: Size) {
    ConstraintLayout(
        modifier = Modifier.height(size.height.dp).width(size.width.dp)
            .background(Color.Black, shape = RoundedCornerShape(40.dp))
    ) {
        val (face) = createRefs()
        Image(painter = painterResource(R.drawable.face),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.constrainAs(face) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })
    }
}



