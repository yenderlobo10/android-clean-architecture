package co.mergedev.domain.model

import co.mergedev.domain.model.resource.ResourceList

/**
 * Represent list of issues by [Character].
 *
 * @param available The number of total available issues in this list.
 * Will always be greater than or equal to the "[returned]" value.
 * @param returned The number of issues returned in this collection (up to 20).
 * @param collectionURI The path to the full list of issues in this collection.
 * @param items The list of returned issues in this collection.
 */
data class ComicList(

    override val available: Int,
    override val returned: Int,
    override val collectionURI: String,
    override val items: List<ComicSummary>

) : ResourceList<ComicSummary>
