package com.overgara.test.xumak.data.character.service;

import com.overgara.test.xumak.data.character.dto.CharacterDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created By oscar.vergara on 12/08/2020
 */
interface CharacterApiService {

    @GET(".")
    Observable<CharacterDTO> getCharacters(
            @Query(value = "limit", encoded = true) int limit,
            @Query(value = "offset", encoded = true) int offset
    );
}
