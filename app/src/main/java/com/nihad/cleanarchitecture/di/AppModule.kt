package com.nihad.cleanarchitecture.di

import android.app.Service
import com.nihad.cleanarchitecture.core.Constant
import com.nihad.cleanarchitecture.feature_name.data.remote.ServiceClass
import com.nihad.cleanarchitecture.feature_name.data.repository.BooksRepositoryImp
import com.nihad.cleanarchitecture.feature_name.data.repository.CompanyRepositoryImp
import com.nihad.cleanarchitecture.feature_name.domain.repository.BooksRepository
import com.nihad.cleanarchitecture.feature_name.domain.repository.CompanyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideServiceAPI():ServiceClass{
        return  Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceClass::class.java)

    }

    @Provides
    @Singleton
    fun providerCompanyRepository(api:ServiceClass):CompanyRepository{
        return CompanyRepositoryImp(api)

    } @Provides
    @Singleton
    fun providerBooksRepository(api:ServiceClass):BooksRepository{
        return BooksRepositoryImp(api)

    }
}