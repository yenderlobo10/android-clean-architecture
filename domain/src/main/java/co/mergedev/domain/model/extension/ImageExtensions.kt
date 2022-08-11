package co.mergedev.domain.model.extension

import co.mergedev.domain.model.Image
import co.mergedev.domain.model.enums.ImageVariant
import timber.log.Timber


/**
 * Return url to [variant] of [Image] instance.
 *
 * @param variant Aspect ratio of image.
 * @see ImageVariant
 */
fun Image.buildUrl(
    variant: ImageVariant = ImageVariant.Full.Original
): String {

    return try {

        if (variant.pathSuffix.isNotBlank())
            "${path}/${variant.pathSuffix}.$extension"
        else
            "$path.$extension"

    } catch (ex: Exception) {

        Timber.e(ex)
        "$path.$extension"
    }
}