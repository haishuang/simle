package com.example.hais.simle.emojutils;

/**
 * Created by Huang hai-sen on 2016/10/9.
 */
public class Emojicon {
    /**
     * 类型
     */
    private Type type;
    /**
     * 路径
     */
    private String iconPath;
    /**
     * 资源id
     */
    private int icon;
    /**
     * 显示的文本信息
     */
    private String emojiText;
    /**
     * 名称
     */
    private String name;

    public Emojicon(int icon, String emoji, Type type) {
        this.icon = icon;
        this.name = emoji;
        this.type =type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getEmojiText() {
        return emojiText;
    }

    public void setEmojiText(String emojiText) {
        this.emojiText = emojiText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public enum Type{
        /**
         * normal icon, can be input one or more in edit view
         */
        NORMAL,
        /**
         * big icon, send out directly when your press it
         */
        BIG_EXPRESSION
    }
}

