package com.xl.dynamicisland

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @Author : wyl
 * @Date : 2022/9/14
 * Desc :
 */


private enum class BoxState {
    PHONE, AIRPODS, FACE
}

@Composable
fun anmiTest() {
    var boxState by remember { mutableStateOf(BoxState.PHONE) }

    val transition = updateTransition(
        targetState = boxState, label = "Box Transition"
    )

    val color by transition.animateColor(label = "Color") { state ->
        when (state) {
            BoxState.PHONE -> Blue
            BoxState.AIRPODS -> Red
            BoxState.FACE -> Yellow
        }
    }
    val size by transition.animateSize(label = "Size") { state ->
        when (state) {
            BoxState.PHONE -> Size(400.dp.value, 70.dp.value)
            BoxState.AIRPODS -> Size(230.dp.value, 35.dp.value)
            BoxState.FACE -> Size(180.dp.value, 180.dp.value)
        }
    }

    Box(modifier = Modifier.background(color).size(size.width.dp, size.height.dp)) {

    }

}

@Preview(showBackground = true)
@Composable
fun showAnim() {

    var size by remember { mutableStateOf(100f) }

    val value by animateFloatAsState(
        targetValue = size, animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium
        )
    )

    Box(modifier = Modifier.size(value.dp).background(Color.Green)) {

    }

    Button(onClick = {
        size = if (size == 100f) 200f else 100f
    }) {
        Text("按钮")
    }


}
