package co.mergedev.marvelcharacters.data.model

import co.mergedev.marvelcharacters.data.model.interfaces.ResourceSummary

/**
 * Represent a item of [SeriesList].
 *
 * @param resourceURI The path to the individual series resource.
 * @param name The canonical name of the series.
 */
data class SeriesSummary(

    override val resourceURI: String,
    override val name: String?

) : ResourceSummary
