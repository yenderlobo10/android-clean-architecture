package co.mergedev.domain.model

import co.mergedev.domain.model.resource.ResourceList

/**
 * Represent list of returned events by [Character].
 *
 * @param available The number of total available events in this list.
 * Will always be greater than or equal to the "[returned]" value.
 * @param returned The number of events returned in this collection (up to 20).
 * @param collectionURI The path to the full list of events in this collection.
 * @param items The list of returned events in this collection.
 */
data class SeriesList(

    override val available: Int,
    override val returned: Int,
    override val collectionURI: String,
    override val items: List<SeriesSummary>

) : ResourceList<SeriesSummary>
