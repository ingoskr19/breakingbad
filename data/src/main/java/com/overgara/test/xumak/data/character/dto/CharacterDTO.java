package com.overgara.test.xumak.data.character.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public class CharacterDTO implements Serializable
{
    private final static long serialVersionUID = 5621047467198026613L;

    @SerializedName("char_id")
    private Integer charId;
    @SerializedName("name")
    private String name;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("occupation")
    private List<String> occupation = null;
    @SerializedName("img")
    private String img;
    @SerializedName("status")
    private String status;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("appearance")
    private List<Integer> appearance = null;
    @SerializedName("portrayed")
    private String portrayed;
    @SerializedName("category")
    private String category;
    @SerializedName("better_call_saul_appearance")
    private List<Integer> betterCallSaulAppearance = null;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
}
