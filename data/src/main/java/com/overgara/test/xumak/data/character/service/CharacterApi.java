package com.overgara.test.xumak.data.character.service;

import com.overgara.test.xumak.data.character.CharacterRepository;
import com.overgara.test.xumak.data.character.base.BaseRetrofit;
import com.overgara.test.xumak.data.character.dto.CharacterDTO;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public class CharacterApi implements CharacterRepository {

    private CharacterApiService service;

    public CharacterApi(String BASE_URL) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(BaseRetrofit.getOkHttpClient(BaseRetrofit.getHttpLoggingInterceptor()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(CharacterApiService.class);
    }

    public Observable<CharacterDTO> getCharacters(int limit, int offset) {
        return service.getCharacters(
                limit,
                offset)
                .subscribeOn(Schedulers.io());
    }
}
