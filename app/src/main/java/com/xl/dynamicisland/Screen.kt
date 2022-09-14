package com.xl.dynamicisland

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateSize
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * @Author : wyl
 * @Date : 2022/9/14
 * Desc :
 */

private enum class IslandState {
    PHONE, AIRPODS, FACE, DEFAULT
}

@Preview(showBackground = true)
@ExperimentalAnimationApi
@Composable
fun mainScreen() {

    var isLandState by remember { mutableStateOf(IslandState.DEFAULT) }

    val transition = updateTransition(
        targetState = isLandState, label = "Island Transition"
    )


    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (btn, btnHeadSet, btnFace, btnDefault, box) = createRefs()

        val size by transition.animateSize(label = "Size") { state ->
            when (state) {
                IslandState.PHONE -> Size(400.dp.value, 70.dp.value)
                IslandState.AIRPODS -> Size(230.dp.value, 35.dp.value)
                IslandState.FACE -> Size(180.dp.value, 180.dp.value)
                IslandState.DEFAULT -> Size(80.dp.value, 22.dp.value)
            }
        }

        Box(modifier = Modifier.size(size.width.dp, size.height.dp).constrainAs(box) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top, margin = 10.dp)
        }) {
            when (isLandState) {
                IslandState.PHONE -> phoneIsLand(size)
                IslandState.AIRPODS -> headsetIsland(size)
                IslandState.FACE -> faceIsland(size)
                IslandState.DEFAULT -> defaultIsland(size)
            }
        }




        Button(onClick = {
            isLandState = IslandState.DEFAULT
        }, modifier = Modifier.constrainAs(btnDefault) {
            start.linkTo(parent.start)
            end.linkTo(btn.start)
            bottom.linkTo(parent.bottom, margin = 10.dp)
        }) {
            Text("默认")
        }



        Button(onClick = {
            isLandState = IslandState.PHONE
        }, modifier = Modifier.constrainAs(btn) {
            start.linkTo(btnDefault.end)
            end.linkTo(btnHeadSet.start)
            bottom.linkTo(parent.bottom, margin = 10.dp)
        }) {
            Text("来电")
        }

        Button(onClick = {
            isLandState = IslandState.AIRPODS
        }, modifier = Modifier.constrainAs(btnHeadSet) {
            start.linkTo(btn.end)
            end.linkTo(btnFace.start)
            bottom.linkTo(parent.bottom, margin = 10.dp)
        }) {
            Text("耳机")
        }

        Button(onClick = {
            isLandState = IslandState.FACE
        }, modifier = Modifier.constrainAs(btnFace) {
            start.linkTo(btnHeadSet.end)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom, margin = 10.dp)
        }) {
            Text("Face")
        }
    }
}
