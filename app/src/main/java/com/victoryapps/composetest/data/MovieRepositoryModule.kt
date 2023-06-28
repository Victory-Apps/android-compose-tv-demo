package com.victoryapps.composetest.data

import android.content.Context
import com.victoryapps.composetest.util.GenreJsonParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieRepositoryModule {

    @Provides
    @Singleton
    fun providesGenreJsonParser(@ApplicationContext context: Context) = GenreJsonParser(context)

    @Provides
    @Singleton
    fun providesVideoRepository(genreJsonParser: GenreJsonParser): MovieRepository =
        MovieRepositoryImpl(genreJsonParser)
}