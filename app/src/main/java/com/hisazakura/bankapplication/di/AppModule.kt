package com.hisazakura.bankapplication.di

import android.content.Context
import com.hisazakura.bankapplication.room.EntryDataDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideEntryDataDatabase(
        @ApplicationContext context: Context
    ) : EntryDataDatabase = EntryDataDatabase.getDatabase(context)
}