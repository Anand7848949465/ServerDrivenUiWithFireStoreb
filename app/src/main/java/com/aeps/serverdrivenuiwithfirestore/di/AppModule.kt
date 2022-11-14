package com.aeps.serverdrivenuiwithfirestore.di

import com.aeps.serverdrivenuiwithfirestore.component.Constants.SDUICollection
import com.aeps.serverdrivenuiwithfirestore.data.repository.ServerDrivenUiRepositoryImpl
import com.aeps.serverdrivenuiwithfirestore.domain.repository.ServerDrivenUiRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    fun provideSDUIRef(db: FirebaseFirestore) = db.collection(SDUICollection)

    @Provides
    fun provideServerDrivenRepository(sdUiRef: CollectionReference): ServerDrivenUiRepository =
        ServerDrivenUiRepositoryImpl(sdUiRef)


}