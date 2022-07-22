package co.mergedev.marvelcharacters.data.model

import co.mergedev.marvelcharacters.data.model.interfaces.ResourceSummary

/**
 * Represent a item of [StoryList].
 *
 * @param resourceURI The path to the individual story resource.
 * @param name The canonical name of the story.
 * @param type The type of the story (interior or cover).
 */
data class StorySummary(

    override val resourceURI: String,
    override val name: String?,
    val type: String?

): ResourceSummary
