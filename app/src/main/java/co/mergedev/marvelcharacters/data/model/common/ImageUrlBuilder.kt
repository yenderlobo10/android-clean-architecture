package co.mergedev.marvelcharacters.data.model.common

import co.mergedev.marvelcharacters.data.model.Image
import co.mergedev.marvelcharacters.data.model.interfaces.ImageFullVariant
import co.mergedev.marvelcharacters.data.model.interfaces.ImageLandscapeVariant
import co.mergedev.marvelcharacters.data.model.interfaces.ImagePortraitVariant
import co.mergedev.marvelcharacters.data.model.interfaces.ImageUrlBuilderBase

/**
 * TODO: document
 */
class ImageUrlBuilder(img: Image) : ImageUrlBuilderBase {

    override val portrait = ImagePortraitVariant(

        small = buildUrl(img, "portrait_small"),
        large = buildUrl(img, "portrait_large"),
        incredible = buildUrl(img, "portrait_incredible")
    )

    override val landscape = ImageLandscapeVariant(

        small = buildUrl(img, "landscape_small"),
        large = buildUrl(img, "landscape_large"),
        incredible = buildUrl(img, "landscape_incredible")
    )

    override val full = ImageFullVariant(

        detail = buildUrl(img, "detail"),
        original = buildUrl(img, null)
    )


    private fun buildUrl(
        img: Image,
        suffix: String? = null
    ): String {

        suffix?.let {
            return "${img.path}/$suffix.${img.extension}"
        }

        return "${img.path}.${img.extension}"
    }
}