package io.temporal.snakegame.controller;

public class GameInfo {
    private int bWidth;
    private int bHeight;
    private int dotSize;
    private int allDots;
    private int randPos;
    private int delay;
    private boolean resizable;
    private String title;
    private String dotImg;
    private String appleImg;
    private String headImg;
    private String temporalImg;
    private boolean focusable;
    private String gameOverMessage;
    private String fontName;
    private int fontSize;

    public GameInfo() {}

    public GameInfo(int bWidth, int bHeight, int dotSize, int allDots, int randPos, int delay, boolean resizable, String title, String dotImg, String appleImg, String headImg, String temporalImg, boolean focusable, String gameOverMessage, String fontName, int fontSize) {
        this.bWidth = bWidth;
        this.bHeight = bHeight;
        this.dotSize = dotSize;
        this.allDots = allDots;
        this.randPos = randPos;
        this.delay = delay;
        this.resizable = resizable;
        this.title = title;
        this.dotImg = dotImg;
        this.appleImg = appleImg;
        this.headImg = headImg;
        this.temporalImg = temporalImg;
        this.focusable = focusable;
        this.gameOverMessage = gameOverMessage;
        this.fontName = fontName;
        this.fontSize = fontSize;
    }

    public int getbWidth() {
        return bWidth;
    }

    public void setbWidth(int bWidth) {
        this.bWidth = bWidth;
    }

    public int getbHeight() {
        return bHeight;
    }

    public void setbHeight(int bHeight) {
        this.bHeight = bHeight;
    }

    public int getDotSize() {
        return dotSize;
    }

    public void setDotSize(int dotSize) {
        this.dotSize = dotSize;
    }

    public int getAllDots() {
        return allDots;
    }

    public void setAllDots(int allDots) {
        this.allDots = allDots;
    }

    public int getRandPos() {
        return randPos;
    }

    public void setRandPos(int randPos) {
        this.randPos = randPos;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDotImg() {
        return dotImg;
    }

    public void setDotImg(String dotImg) {
        this.dotImg = dotImg;
    }

    public String getAppleImg() {
        return appleImg;
    }

    public void setAppleImg(String appleImg) {
        this.appleImg = appleImg;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getTemporalImg() {
        return temporalImg;
    }

    public void setTemporalImg(String temporalImg) {
        this.temporalImg = temporalImg;
    }

    public boolean isFocusable() {
        return focusable;
    }

    public void setFocusable(boolean focusable) {
        this.focusable = focusable;
    }

    public String getGameOverMessage() {
        return gameOverMessage;
    }

    public void setGameOverMessage(String gameOverMessage) {
        this.gameOverMessage = gameOverMessage;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
