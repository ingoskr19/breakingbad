package com.overgara.test.xumak.screens.character.data.repository.service;

import com.overgara.test.xumak.base.BaseRetrofit;
import com.overgara.test.xumak.screens.character.data.repository.service.dto.CharacterDTO;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.overgara.test.xumak.config.Constants.BASE_URL;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public class CharacterApi {

    private CharacterApiService service;

    public CharacterApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(BaseRetrofit.getOkHttpClient(BaseRetrofit.getHttpLoggingInterceptor()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(CharacterApiService.class);
    }

    public Observable<List<CharacterDTO>> getCharacters(int limit, int offset) {
        return service.getCharacters(
                limit,
                offset);
    }
}
