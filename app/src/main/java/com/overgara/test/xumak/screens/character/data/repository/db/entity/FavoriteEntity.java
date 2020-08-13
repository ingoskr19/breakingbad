package com.overgara.test.xumak.screens.character.data.repository.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.overgara.test.xumak.screens.character.data.repository.service.dto.CharacterDTO;

import java.util.List;

/**
 * Created By oscar.vergara on 13/08/2020
 */
@Entity(tableName = FavoriteEntity.TABLE_NAME)
public class FavoriteEntity {

    public static final String TABLE_NAME = "FAVORITES";

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "char_id")
    private Integer charId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "birthday")
    private String birthday;

    @ColumnInfo(name = "occupation")
    private List<String> occupation = null;

    @ColumnInfo(name = "img")
    private String img;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "nickname")
    private String nickname;

    @ColumnInfo(name = "appearance")
    private List<Integer> appearance = null;

    @ColumnInfo(name = "portrayed")
    private String portrayed;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "better_call_saul_appearance")
    private List<Integer> betterCallSaulAppearance = null;

    @ColumnInfo(name = "favorite")
    private boolean favorite;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public FavoriteEntity setCharacter(CharacterDTO character){
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
