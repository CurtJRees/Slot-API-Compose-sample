package com.curtjrees.slotapisexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FixtureListScreen(
                itemLayout = { fixtureItem ->
                    CustomFixtureLayout(fixtureItem = fixtureItem)
                }
            )
        }
    }
}


@Composable
fun CustomFixtureLayout(modifier: Modifier = Modifier, fixtureItem: FixtureItem) {
    val resources = AmbientContext.current.resources

    val crestModifier = Modifier.size(40.dp)
    val scoreBoxColor = if(fixtureItem.status == FixtureItem.Status.LIVE) Color.Red else Color.Black
    val scoreBoxModifier = Modifier.background(scoreBoxColor).preferredSize(32.dp)

    Card(
        backgroundColor = Color.LightGray,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        content = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(fixtureItem.homeTeam, modifier = Modifier.padding(horizontal = 16.dp))
                Image(bitmap = imageFromResource(resources, fixtureItem.homeCrest), modifier = crestModifier)

                if (fixtureItem.status == FixtureItem.Status.FIXTURE) {
                    Text(fixtureItem.time, modifier = Modifier.padding(horizontal = 24.dp))
                } else {
                    Box(Modifier.padding(start = 8.dp).then(scoreBoxModifier)) {
                        Text("0", color = Color.White, textAlign = TextAlign.Center, maxLines = 1, modifier = Modifier.align(Alignment.Center))
                    }

                    Box(scoreBoxModifier) {
                        val text = fixtureItem.minute?.toString()?.plus("'") ?: "FT"
                        Text(text, color = Color.White, textAlign = TextAlign.Center, maxLines = 1, modifier = Modifier.align(Alignment.Center))
                    }

                    Box(Modifier.padding(end = 8.dp).then(scoreBoxModifier)) {
                        Text("10", color = Color.White, textAlign = TextAlign.Center, maxLines = 1, modifier = Modifier.align(Alignment.Center))
                    }
                }

                Image(bitmap = imageFromResource(resources, fixtureItem.awayCrest), modifier = crestModifier)
                Text(fixtureItem.awayTeam, modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    )
}


@Preview
@Composable
fun PreviewCustomFixtureLayout() {
    CustomFixtureLayout(fixtureItem = upcomingFixture)
}