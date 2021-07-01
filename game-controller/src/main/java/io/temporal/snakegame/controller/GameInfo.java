package io.temporal.snakegame.controller;

public class GameInfo {
    private int BWidth;
    private int BHeight;
    private int DotSize;
    private int AllDots;
    private int RandPos;
    private int Delay;
    private boolean Resizable;
    private String Title;
    private String DotImg;
    private String AppleImg;
    private String HeadImg;
    private String TemporalImg;
    private boolean Focusable;
    private String GameOverMessage;
    private String FontName;
    private int FontSize;

    public GameInfo() {}

    public GameInfo(int BWidth, int BHeight, int dotSize, int allDots, int randPos, int delay, boolean resizable, String title, String dotImg, String appleImg, String headImg, String temporalImg, boolean focusable, String gameOverMessage, String fontName, int fontSize) {
        this.BWidth = BWidth;
        this.BHeight = BHeight;
        DotSize = dotSize;
        AllDots = allDots;
        RandPos = randPos;
        Delay = delay;
        Resizable = resizable;
        Title = title;
        DotImg = dotImg;
        AppleImg = appleImg;
        HeadImg = headImg;
        TemporalImg = temporalImg;
        Focusable = focusable;
        GameOverMessage = gameOverMessage;
        FontName = fontName;
        FontSize = fontSize;
    }

    public int getBWidth() {
        return BWidth;
    }

    public void setBWidth(int BWidth) {
        this.BWidth = BWidth;
    }

    public int getBHeight() {
        return BHeight;
    }

    public void setBHeight(int BHeight) {
        this.BHeight = BHeight;
    }

    public int getDotSize() {
        return DotSize;
    }

    public void setDotSize(int dotSize) {
        DotSize = dotSize;
    }

    public int getAllDots() {
        return AllDots;
    }

    public void setAllDots(int allDots) {
        AllDots = allDots;
    }

    public int getRandPos() {
        return RandPos;
    }

    public void setRandPos(int randPos) {
        RandPos = randPos;
    }

    public int getDelay() {
        return Delay;
    }

    public void setDelay(int delay) {
        Delay = delay;
    }

    public boolean isResizable() {
        return Resizable;
    }

    public void setResizable(boolean resizable) {
        Resizable = resizable;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDotImg() {
        return DotImg;
    }

    public void setDotImg(String dotImg) {
        DotImg = dotImg;
    }

    public String getAppleImg() {
        return AppleImg;
    }

    public void setAppleImg(String appleImg) {
        AppleImg = appleImg;
    }

    public String getHeadImg() {
        return HeadImg;
    }

    public void setHeadImg(String headImg) {
        HeadImg = headImg;
    }

    public String getTemporalImg() {
        return TemporalImg;
    }

    public void setTemporalImg(String temporalImg) {
        TemporalImg = temporalImg;
    }

    public boolean isFocusable() {
        return Focusable;
    }

    public void setFocusable(boolean focusable) {
        Focusable = focusable;
    }

    public String getGameOverMessage() {
        return GameOverMessage;
    }

    public void setGameOverMessage(String gameOverMessage) {
        GameOverMessage = gameOverMessage;
    }

    public String getFontName() {
        return FontName;
    }

    public void setFontName(String fontName) {
        FontName = fontName;
    }

    public int getFontSize() {
        return FontSize;
    }

    public void setFontSize(int fontSize) {
        FontSize = fontSize;
    }
}
