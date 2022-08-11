package co.mergedev.domain.model

import co.mergedev.domain.model.resource.ResourceList

/**
 * Represent list of returned stories by [Character].
 *
 * @param available The number of total available stories in this list.
 * Will always be greater than or equal to the "[returned]" value.
 * @param returned The number of stories returned in this collection (up to 20).
 * @param collectionURI The path to the full list of stories in this collection.
 * @param items The list of returned stories in this collection.
 */
data class StoryList(

    override val available: Int,
    override val returned: Int,
    override val collectionURI: String,
    override val items: List<StorySummary>

) : ResourceList<StorySummary>
