package co.mergedev.marvelcharacters.view.character.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import co.mergedev.domain.model.Character
import co.mergedev.domain.model.enums.ImageVariant
import co.mergedev.domain.model.extension.buildUrl
import co.mergedev.marvelcharacters.R
import co.mergedev.marvelcharacters.ui.theme.AppTheme
import co.mergedev.marvelcharacters.view.character.viewModel.CharacterDetailViewModel
import co.mergedev.marvelcharacters.view.main.AppState
import co.mergedev.marvelcharacters.view.main.rememberAppState
import coil.compose.AsyncImage
import kotlin.math.max
import kotlin.math.min


@Composable
fun CharacterDetailScreen(
    appState: AppState,
    characterId: Long?,
    viewModel: CharacterDetailViewModel = viewModel()
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        with(viewModel.screenState) {
            when {
                isLoading -> LoadingStateContent()

                isError -> ErrorStateContent()

                else -> SuccessStateContent(
                    character = character
                )
            }
        }
    }

    LaunchedEffect(characterId) {

        viewModel.loadCharacterDetail(characterId)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun SuccessStateContent(
    character: Character?
) {

    if (character !is Character) {
        ErrorStateContent()
        return
    }

    Scaffold {
        DetailContent(
            character = character
        )
    }
}

@Composable
private fun DetailContent(
    character: Character
) {

    val scrollState = rememberScrollState()
    val maxHeightImage = LocalConfiguration.current.screenHeightDp * 0.5

    BoxWithConstraints(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        // Head image
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = maxHeightImage.dp)
                .graphicsLayer {
                    alpha = min(
                        1f,
                        1 - (scrollState.value / (maxHeightImage.toFloat() * 2.3f))
                    )
                    translationY = -scrollState.value * 0.1f
                },
            model = character.thumbnail?.buildUrl(ImageVariant.Full.Detail),
            contentDescription = "test-image",
            placeholder = painterResource(R.drawable.image_404_landscape),
            error = painterResource(R.drawable.image_404_landscape),
            contentScale = ContentScale.FillBounds,
            alignment = BiasAlignment(
                horizontalBias = 0f,
                verticalBias = max(
                    -1f,
                    -scrollState.value / ((maxHeightImage.toFloat() * 2.3f) / 2)
                )
            )
        )

        // Detail
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Spacer(
                modifier = Modifier.height(maxHeightImage.dp)
            )

            CharacterDetails(
                character = character,
            )
        }
    }
}

@Composable
private fun CharacterDetails(
    character: Character,
) {

    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 30.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        // Comics
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.secondary
                        ),
                    ),
                    shape = CutCornerShape(
                        topStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                )
                .padding(16.dp)
        ) {
            Column {

                Text(
                    text = "${character.comics?.available}",
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = "Comics",
                    style = MaterialTheme.typography.caption
                )
            }
        }

        // Stories
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.secondary
                        ),
                    ),
                    shape = CutCornerShape(
                        topStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                )
                .padding(16.dp)
        ) {
            Column {

                Text(
                    text = "${character.stories?.available}",
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = "Stories",
                    style = MaterialTheme.typography.caption
                )
            }
        }

        // Events
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.secondary
                        ),
                    ),
                    shape = CutCornerShape(
                        topStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                )
                .padding(16.dp)
        ) {
            Column {

                Text(
                    text = "${character.events?.available}",
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = "Events",
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }

    // Alias
    Text(
        text = character.alias,
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.Medium
    )

    // Name
    Text(
        modifier = Modifier.padding(top = 4.dp, start = 4.dp),
        text = character.nameWithoutAlias,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Bold
    )

    // Description
    character.description?.let {
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = it,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Justify
        )
    }


    // List comics
    character.comics?.let { comics ->
        Text(
            modifier = Modifier.padding(vertical = 12.dp),
            text = "Comics",
            style = MaterialTheme.typography.h5
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            comics.items.forEachIndexed { i, comic ->
                Text(
                    text = "${i + 1}) ${comic.name}"
                )
            }
        }
    }
}


@Preview
@Composable
private fun CharacterDetailScreenPrev() {

    AppTheme {
        CharacterDetailScreen(
            appState = rememberAppState(),
            characterId = -1
        )
    }
}