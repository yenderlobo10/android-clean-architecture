package co.mergedev.marvelcharacters.data.model

import co.mergedev.marvelcharacters.data.model.common.ImageUrlBuilder
import com.squareup.moshi.Json

/**
 * Images are represented as a partial path and an extension.
 *
 * @param path The directory path of to the image.
 * @param extension The file extension for the image.
 */
data class Image(

    val path: String?,
    val extension: String?
) {

    @Json(ignore = true)
    val urlBuilder: ImageUrlBuilder = ImageUrlBuilder(this)
}