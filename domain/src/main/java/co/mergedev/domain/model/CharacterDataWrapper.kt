package co.mergedev.domain.model

import co.mergedev.domain.model.resource.ResourceDataWrapper

/**
 * Represent body response returned by **characters** api end-points.
 *
 * @see [ResourceDataWrapper]
 */
data class CharacterDataWrapper(

    override val code: Int,
    override val status: String?,
    override val copyright: String?,
    override val attributionText: String?,
    override val attributionHTML: String?,
    override val data: CharacterDataContainer,
    override val etag: String?

): ResourceDataWrapper<Character>
