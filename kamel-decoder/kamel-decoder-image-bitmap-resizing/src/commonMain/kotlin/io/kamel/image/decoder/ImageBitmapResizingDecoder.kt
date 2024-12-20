package io.kamel.image.decoder

import androidx.compose.ui.graphics.ImageBitmap
import io.kamel.core.ExperimentalKamelApi
import io.kamel.core.decoder.Decoder

/**
 * Decodes and transfers [ByteReadChannel] to [ImageBitmap].
 */
internal expect val ImageBitmapResizingDecoder: Decoder<ImageBitmap>