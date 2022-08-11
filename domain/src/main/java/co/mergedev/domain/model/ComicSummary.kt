package co.mergedev.domain.model

import co.mergedev.domain.model.resource.ResourceSummary

/**
 * Represent a item of [ComicList].
 *
 * @param resourceURI The path to the individual comic resource.
 * @param name The canonical name of the comic.
 */
data class ComicSummary(

    override val resourceURI: String,
    override val name: String?

) : ResourceSummary
