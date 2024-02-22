package net.firestaff.mcp.mobiquityhomework.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import net.firestaff.mcp.mobiquityhomework.services.transformImageUrl

@Composable
fun ProductImage(url: String, productName: String) {
    if (url.isNotEmpty()) {
        val painter = rememberImagePainter(
            request = ImageRequest.Builder(LocalContext.current)
                .data(transformImageUrl(url))
                .build()
        )

        Image(
            painter = painter,
            contentDescription = "Product Image for $productName",
            modifier = Modifier.size(64.dp)
        )
    } else {
        Box(
            modifier = Modifier
                .size(64.dp)
        )
    }
}
