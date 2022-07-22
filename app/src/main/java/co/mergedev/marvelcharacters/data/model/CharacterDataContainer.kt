package co.mergedev.marvelcharacters.data.model

import co.mergedev.marvelcharacters.data.model.interfaces.ResourceDataContainer

/**
 * Represent result-data model returned by **characters** api end-points.
 *
 * @see [ResourceDataContainer]
 */
data class CharacterDataContainer(

    override val offset: Int,
    override val limit: Int,
    override val total: Int,
    override val count: Int,
    override val results: List<Character>

) : ResourceDataContainer<Character>
