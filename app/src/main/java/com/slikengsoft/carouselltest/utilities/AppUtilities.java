package com.slikengsoft.carouselltest.utilities;

import android.content.Context;

import com.slikengsoft.carouselltest.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * General function for all purposes
 */
public class AppUtilities {

    //Generate random number according to max provided
    public static int randomNum(int max){
        Random generator = new Random();
        return generator.nextInt(max);
    }

    //Load preset word from file
    public static ArrayList<String> load(Context context) {
        ArrayList<String> words = new ArrayList<>();
        try {
            InputStream is = context.getResources().openRawResource(R.raw.words);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                words.add(String.valueOf(line));
            }
            bufferedReader.close();
            return words;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //generate random title from 10 words from preset file(for testing only)
    public static String generate(List<String> words) {
        int wordNum = words.size();
        StringBuilder result = new StringBuilder();
        int place;
        for (int i = 0; i < 10; i++) {
            place = new Random().nextInt(wordNum);
            String s = words.get(place);
            result.append(s);
            result.append(" ");
        }
        return result.toString();
    }
}
