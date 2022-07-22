package co.mergedev.marvelcharacters.data.model

import co.mergedev.marvelcharacters.data.model.interfaces.ResourceSummary

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
