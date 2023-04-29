package com.hugidonic.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.hugidonic.domain.entities.CoinDetailsModel

data class CoinDetailsDto(
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: LinksDto,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtendedDto>,
    val logo: String,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<TagDto>,
    val team: List<TeamMemberDto>,
    val type: String,
    val whitepaper: WhitepaperDto
)

fun CoinDetailsDto.toCoinDetailModel(): CoinDetailsModel {
    return CoinDetailsModel(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team.map { it.toTeamMemberModel() }
    )
}