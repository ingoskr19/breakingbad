package com.overgara.test.xumak.database;

import android.text.TextUtils;

import androidx.room.TypeConverter;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created By oscar.vergara on 13/08/2020
 */
public class DataConverterHelper {

    @TypeConverter
    public static List<Integer> stringToIntLis(String value) {
        List<Integer> list = new ArrayList<>();
        for(String num : Arrays.asList(value.split(";"))){
            if(!TextUtils.isEmpty(num))
                list.add(Integer.parseInt(num));
        }
        return list;
    }

    @TypeConverter
    public static List<String> stringToIntListString(String value) {
        return Arrays.asList(value.split(";"));
    }

    @TypeConverter
    public static String intListToString(List<Integer> list) {
        return Joiner.on(";").join(list);
    }

    @TypeConverter
    public static String stringListToString(List<String> list) {
        return Joiner.on(";").join(list);
    }
}
