package com.curtjrees.slotapisexample

import androidx.annotation.DrawableRes

data class FixtureItem(
    val id: Int,
    val status: Status,
    val date: String,
    val time: String,
    val minute: Int? = null,
    val competition: String,
    val homeTeam: String,
    val homeScore: Int,
    @DrawableRes val homeCrest: Int,
    val awayTeam: String,
    @DrawableRes val awayCrest: Int,
    val awayScore: Int,
) {

    enum class Status {
        FIXTURE,
        LIVE,
        RESULT,
    }
}

val upcomingFixture = FixtureItem(
    id = 0,
    status = FixtureItem.Status.FIXTURE,
    date = "Nov 21, 2020",
    time = "15:00",
    competition = "Premier League",
    homeTeam = "MU",
    homeScore = 2,
    homeCrest = R.drawable.crest_manu,
    awayTeam = "AR",
    awayCrest = R.drawable.crest_arsenal,
    awayScore = 0,
)

val liveFixture = FixtureItem(
    id = 1,
    status = FixtureItem.Status.LIVE,
    date = "Nov 20, 2020",
    time = "10:00",
    minute = 30,
    competition = "Champions League",
    homeTeam = "BR",
    homeScore = 0,
    homeCrest = R.drawable.crest_brighton,
    awayTeam = "CP",
    awayCrest = R.drawable.crest_palace,
    awayScore = 0,
)

val resultFixture = FixtureItem(
    id = 2,
    status = FixtureItem.Status.RESULT,
    date = "Nov 19, 2020",
    time = "09:00",
    competition = "Premier League",
    homeTeam = "AV",
    homeScore = 1,
    homeCrest = R.drawable.crest_av,
    awayTeam = "BU",
    awayCrest = R.drawable.crest_burnley,
    awayScore = 1,
)