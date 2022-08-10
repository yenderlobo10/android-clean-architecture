package co.mergedev.domain.model

import co.mergedev.domain.model.IImage

/**
 * Images are represented as a partial path and an extension.
 *
 * @param path The directory path of to the image.
 * @param extension The file extension for the image.
 */
data class Image(

    override val path: String?,
    override val extension: String?
) : IImage