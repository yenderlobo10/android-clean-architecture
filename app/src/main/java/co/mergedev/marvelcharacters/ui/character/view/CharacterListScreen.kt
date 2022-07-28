@file:OptIn(ExperimentalMaterialApi::class)

package co.mergedev.marvelcharacters.ui.character.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import co.mergedev.marvelcharacters.R
import co.mergedev.marvelcharacters.data.model.Character
import co.mergedev.marvelcharacters.ui.character.viewModel.CharacterListViewModel
import co.mergedev.marvelcharacters.ui.common.navigation.routes.AppRoute
import co.mergedev.marvelcharacters.ui.common.theme.AppTheme
import co.mergedev.marvelcharacters.ui.main.AppState
import co.mergedev.marvelcharacters.ui.main.rememberAppState
import coil.compose.AsyncImage


@Composable
fun CharacterListScreen(
    appState: AppState,
    viewModel: CharacterListViewModel = viewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                },
                backgroundColor = MaterialTheme.colors.secondary
            )
        }
    ) {

        Box(
            modifier = Modifier.padding(it)
        ) {

            with(viewModel.screenState) {

                when {
                    isLoading -> LoadingStateContent()

                    isError -> ErrorStateContent()

                    else -> SuccessStateContent(
                        characterList = listCharacters,
                        onCharacterItemClick = { item ->
                            appState.navController.navigate(
                                AppRoute.CharacterDetail.createRoutePath(
                                    characterId = item.id
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LoadingStateContent(
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorStateContent(
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.i_error_cloud),
            contentDescription = "i-error-cloud",
            modifier = Modifier.size(96.dp)
        )

        Text(
            text = stringResource(R.string.ch_list_load_error),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun SuccessStateContent(
    characterList: List<Character>,
    onCharacterItemClick: (Character) -> Unit
) {

    val minWidth = LocalConfiguration.current.screenWidthDp * 0.44

    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        columns = GridCells.Adaptive(minSize = minWidth.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        items(
            items = characterList,
            key = { x -> x.id }
        ) { item ->
            CharacterListItem(
                character = item,
                onItemClick = onCharacterItemClick
            )
        }
    }
}


@Composable
private fun CharacterListItem(
    character: Character,
    onItemClick: (Character) -> Unit
) {

    val thumbUrl = character.thumbnail?.urlBuilder?.portrait?.incredible ?: ""

    Card(
        modifier = Modifier.requiredHeightIn(min = 280.dp),
        onClick = { onItemClick(character) }
    ) {
        Column(
            Modifier.fillMaxSize(),
        ) {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp),
                model = thumbUrl,
                contentDescription = "",
                placeholder = painterResource(R.drawable.image_404_portrait),
                error = painterResource(R.drawable.image_404_portrait),
                contentScale = ContentScale.FillBounds
            )

            Divider(
                color = MaterialTheme.colors.primary,
                thickness = 4.dp
            )

            Column(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        start = 12.dp,
                        end = 8.dp,
                    ),
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Text(
                    modifier = Modifier,
                    text = character.nameWithoutAlias.uppercase(),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier,
                    text = character.alias.uppercase(),
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
    }
}


@Preview
@Composable
private fun ContentPrev() {

    AppTheme {
        Surface {

        }
    }
}

@Preview
@Composable
private fun CharacterListScreenPrev() {

    AppTheme {
        CharacterListScreen(
            appState = rememberAppState()
        )
    }
}