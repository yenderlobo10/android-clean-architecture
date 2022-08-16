package co.mergedev.data.di

import co.mergedev.data.api.marvel.characters.IMarvelCharactersService
import co.mergedev.data.api.marvel.characters.MarvelCharacterService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ServiceModule {

    @Binds
    abstract fun provideMarvelCharacterService(
        service: MarvelCharacterService
    ): IMarvelCharactersService
}