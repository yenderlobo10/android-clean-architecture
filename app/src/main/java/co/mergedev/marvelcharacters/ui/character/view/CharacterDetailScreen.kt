package co.mergedev.marvelcharacters.ui.character.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import co.mergedev.marvelcharacters.R
import co.mergedev.marvelcharacters.data.model.Character
import co.mergedev.marvelcharacters.ui.character.viewModel.CharacterDetailViewModel
import co.mergedev.marvelcharacters.ui.common.theme.AppTheme
import co.mergedev.marvelcharacters.ui.main.AppState
import co.mergedev.marvelcharacters.ui.main.rememberAppState


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

    ConstraintLayout {

        // Head image
        Image(
            painter = painterResource(id = R.drawable.image_404_landscape),
            contentDescription = "test-image"
        )

        // Detail
        Column(
            Modifier.verticalScroll(scrollState)
        ) {

            CharacterDetails(
                character = character
            )
        }
    }
}

@Composable
private fun CharacterDetails(
    character: Character
) {

    Column {

        Text(
            text = character.alias,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = character.nameWithoutAlias,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )

        character.description?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Justify
            )
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