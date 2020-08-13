package com.overgara.test.xumak.data.character;

import com.overgara.test.xumak.data.character.dto.CharacterDTO;

import io.reactivex.Observable;

public interface CharacterRepository {

    Observable<CharacterDTO> getCharacters(int limit, int offset);

}
