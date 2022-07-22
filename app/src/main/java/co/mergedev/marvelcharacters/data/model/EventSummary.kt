package co.mergedev.marvelcharacters.data.model

/**
 * Represent a item of [EventList].
 *
 * @param resourceURI The path to the individual event resource.
 * @param name The name of the event.
 */
data class EventSummary(

    val resourceURI: String,
    val name: String?
)
