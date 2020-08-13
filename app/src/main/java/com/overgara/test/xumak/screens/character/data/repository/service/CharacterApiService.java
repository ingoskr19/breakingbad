package com.overgara.test.xumak.screens.character.data.repository.service;

import com.overgara.test.xumak.config.Constants;
import com.overgara.test.xumak.screens.character.data.repository.service.dto.CharacterDTO;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created By oscar.vergara on 12/08/2020
 */
interface CharacterApiService {

    @GET(Constants.CHARACTERS_URL)
    Observable<List<CharacterDTO>> getCharacters(
            @Query(value = "limit", encoded = true) int limit,
            @Query(value = "offset", encoded = true) int offset
    );
}
