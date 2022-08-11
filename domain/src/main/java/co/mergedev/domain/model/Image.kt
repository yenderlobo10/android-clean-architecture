package co.mergedev.domain.model

/**
 * Images are represented as a partial path and an extension.
 *
 * @param path The directory path of to the image.
 * @param extension The file extension for the image.
 */
data class Image(

    val path: String?,
    val extension: String?
)