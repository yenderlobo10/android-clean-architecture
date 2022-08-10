package co.mergedev.domain.model

import co.mergedev.domain.model.resource.ResourceSummary

/**
 * Represent a item of [EventList].
 *
 * @param resourceURI The path to the individual event resource.
 * @param name The name of the event.
 */
data class EventSummary(

    override val resourceURI: String,
    override val name: String?
) : ResourceSummary
