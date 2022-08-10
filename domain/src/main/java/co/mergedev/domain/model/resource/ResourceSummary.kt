package co.mergedev.domain.model.resource

/**
 * Represent a base summary item of [ResourceList].
 *
 * @param resourceURI The path to the individual item resource.
 * @param name The canonical name of the story.
 */
interface ResourceSummary {

    val resourceURI: String
    val name: String?
}