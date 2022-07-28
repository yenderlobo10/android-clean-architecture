package co.mergedev.marvelcharacters.data.model.interfaces

/**
 * TODO: document
 */
interface ImageUrlBuilderBase {

    val portrait: ImagePortraitVariant
    val landscape: ImageLandscapeVariant
    val full: ImageFullVariant
}

/**
 * TODO: document
 */
data class ImagePortraitVariant(

    val small: String,
    val large: String,
    val incredible: String
)

/**
 * TODO: document
 */
data class ImageLandscapeVariant(

    val small: String,
    val large: String,
    val incredible: String
)

/**
 * TODO: document
 */
data class ImageFullVariant(

    val detail: String,
    val original: String
)