package com.hugidonic.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.hugidonic.domain.entities.TeamMemberModel

data class TeamMemberDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
)

fun TeamMemberDto.toTeamMemberModel(): TeamMemberModel {
    return TeamMemberModel(
        id = id,
        name = name,
        position = position
    )
}