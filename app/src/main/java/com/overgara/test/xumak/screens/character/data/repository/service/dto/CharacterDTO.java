package com.overgara.test.xumak.screens.character.data.repository.service.dto;

import com.google.gson.annotations.SerializedName;
import com.overgara.test.xumak.screens.character.presentation.model.Character;

import java.io.Serializable;
import java.util.List;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public class CharacterDTO implements Serializable
{
    @SerializedName("char_id")
    protected Integer charId;
    @SerializedName("name")
    protected String name;
    @SerializedName("birthday")
    protected String birthday;
    @SerializedName("occupation")
    protected List<String> occupation = null;
    @SerializedName("img")
    protected String img;
    @SerializedName("status")
    protected String status;
    @SerializedName("nickname")
    protected String nickname;
    @SerializedName("appearance")
    protected List<Integer> appearance = null;
    @SerializedName("portrayed")
    protected String portrayed;
    @SerializedName("category")
    protected String category;
    @SerializedName("better_call_saul_appearance")
    protected List<Integer> betterCallSaulAppearance = null;

    public Integer getCharId() {
        return charId;
    }

    public void setCharId(Integer charId) {
        this.charId = charId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Integer> getAppearance() {
        return appearance;
    }

    public void setAppearance(List<Integer> appearance) {
        this.appearance = appearance;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Integer> getBetterCallSaulAppearance() {
        return betterCallSaulAppearance;
    }

    public void setBetterCallSaulAppearance(List<Integer> betterCallSaulAppearance) {
        this.betterCallSaulAppearance = betterCallSaulAppearance;
    }

    public CharacterDTO setCharacter(CharacterDTO character){
        this.charId = character.getCharId();
        this.name = character.getName();
        this.birthday = character.getBirthday();
        this.occupation = character.getOccupation();
        this.img = character.getImg();
        this.status = character.getStatus();
        this.nickname = character.getNickname();
        this.appearance = character.getAppearance();
        this.portrayed = character.getPortrayed();
        this.category = character.getCategory();
        this.betterCallSaulAppearance = character.getBetterCallSaulAppearance();
        return this;
    }
}
