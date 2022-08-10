package co.mergedev.domain.model.extension

import co.mergedev.domain.model.Image
import co.mergedev.domain.model.enums.ImageVariant
import timber.log.Timber


/**
 * TODO: document
 *
 * @param variant
 */
fun Image.buildUrl(
    variant: ImageVariant
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