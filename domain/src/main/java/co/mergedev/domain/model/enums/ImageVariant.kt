package co.mergedev.domain.model.enums

/**
 * TODO: document sealed class
 */
sealed class ImageVariant(
    val pathSuffix: String
) {

    /**
     * TODO: document sealed class
     */
    sealed class Portrait(
        val portraitPath: String
    ) : ImageVariant(
        pathSuffix = portraitPath
    ) {
        object Small : Portrait(portraitPath = "portrait_small")
        object Large : Portrait(portraitPath = "portrait_large")
        object Incredible : Portrait(portraitPath = "portrait_incredible")
    }

    /**
     * TODO: document sealed class
     */
    sealed class Landscape(
        val landscapePath: String
    ) : ImageVariant(
        pathSuffix = landscapePath
    ) {
        object Small : Landscape(landscapePath = "landscape_small")
        object Large : Landscape(landscapePath = "landscape_large")
        object Incredible : Landscape(landscapePath = "landscape_incredible")
    }

    /**
     * TODO: document sealed class
     */
    sealed class Full(
        val fullPath: String
    ) : ImageVariant(
        pathSuffix = fullPath
    ) {
        object Detail : Full(fullPath = "detail")
        object Original : Full(fullPath = "")
    }
}
