package com.example.hais.simle.emojutils;

import android.text.Spannable;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Huang hai-sen on 2016/10/9.
 */
public class SmileUtils {

    public static final String ee_1 = "[):]";
    public static final String ee_2 = "[:D]";
    public static final String ee_3 = "[;)]";
    public static final String ee_4 = "[:-o]";
    public static final String ee_5 = "[:p]";
    public static final String ee_6 = "[(H)]";
    public static final String ee_7 = "[:@]";
    public static final String ee_8 = "[:s]";
    public static final String ee_9 = "[:$]";
    public static final String ee_10 = "[:(]";
    public static final String ee_11 = "[:'(]";
    public static final String ee_12 = "[:|]";
    public static final String ee_13 = "[(a)]";
    public static final String ee_14 = "[8o|]";
    public static final String ee_15 = "[8-|]";
    public static final String ee_16 = "[+o(]";
    public static final String ee_17 = "[<o)]";
    public static final String ee_18 = "[|-)]";
    public static final String ee_19 = "[*-)]";
    public static final String ee_20 = "[:-#]";
    public static final String ee_21 = "[:-*]";
    public static final String ee_22 = "[^o)]";
    public static final String ee_23 = "[8-)]";
    public static final String ee_24 = "[(|)]";
    public static final String ee_25 = "[(u)]";
    public static final String ee_26 = "[(S)]";
    public static final String ee_27 = "[(*)]";
    public static final String ee_28 = "[(#)]";
    public static final String ee_29 = "[(R)]";
    public static final String ee_30 = "[({)]";
    public static final String ee_31 = "[(})]";
    public static final String ee_32 = "[(k)]";
    public static final String ee_33 = "[(F)]";
    public static final String ee_34 = "[(W)]";
    public static final String ee_35 = "[(D)]";

    private static final Spannable.Factory spannableFactory = Spannable.Factory.getInstance();
    private static final Map<Pattern, Object> emoticons = new HashMap<Pattern, Object>();

    static {
        Emojicon[] emojicons = DefaultEmojiconDatas.getData();
        for (Emojicon emojicon : emojicons) {
            addPattern(emojicon.getEmojiText(), emojicon.getIcon());
        }
//        EmojiconInfoProvider emojiconInfoProvider = UI.getInstance().getEmojiconInfoProvider();
//        if(emojiconInfoProvider != null && emojiconInfoProvider.getTextEmojiconMapping() != null){
//            for(Map.Entry<String, Object> entry : emojiconInfoProvider.getTextEmojiconMapping().entrySet()){
//                addPattern(entry.getKey(), entry.getValue());
//            }
//        }

    }

    public static void addPattern(String emojiText, Object icon){
        emoticons.put(Pattern.compile(Pattern.quote(emojiText)), icon);
    }
}
