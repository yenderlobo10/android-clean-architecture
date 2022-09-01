package co.mergedev.data.di

import co.mergedev.data.api.marvel.MarvelApiClient
import co.mergedev.data.api.marvel.characters.MarvelCharactersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideMarvelCharacterService(
        apiClient: MarvelApiClient
    ): MarvelCharactersService =
        apiClient.retrofit().create(MarvelCharactersService::class.java)

}