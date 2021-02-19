package io.kamel.image

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.ImageBitmap
import io.kamel.core.ExperimentalKamelApi
import io.kamel.core.Resource
import io.kamel.core.config.ResourceConfig
import io.kamel.core.config.ResourceConfigBuilder
import io.kamel.core.utils.loadImageResource
import io.kamel.image.config.LocalKamelConfig
import io.ktor.http.*

/**
 * Loads an image resource asynchronously.
 * @param data Can be anything such as [String], [Url] or a [File].
 * @param block configuration for [ResourceConfig].
 * @return [ImageBitmap] resource that can be used to display an Image.
 * @see KamelImage
 * @see LocalKamelConfig
 */
@OptIn(ExperimentalKamelApi::class)
@Composable
public inline fun lazyImageResource(data: Any, block: ResourceConfigBuilder.() -> Unit = {}): Resource<ImageBitmap> {

    var resource by remember(data) { mutableStateOf<Resource<ImageBitmap>>(Resource.Loading) }

    val resourceConfig = ResourceConfigBuilder().apply(block).build()

    val kamelConfig = LocalKamelConfig.current

    LaunchedEffect(data, resourceConfig) {
        resource = kamelConfig.loadImageResource(data, resourceConfig)
    }

    return resource
}
