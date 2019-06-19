package es.popapps.trivisk;

public class GamesModel {

    private String gameName;
    private String gameSubtitle;
    private int    gameImg;


    public String getGameName(){
        return gameName;
    }

    public void setGameName(String name){
        gameName = name;
    }

    public String getGameSubtitle() {
        return gameSubtitle;
    }

    public void setGameSubtitle(String gameSubtitle) {
        this.gameSubtitle = gameSubtitle;
    }

    public int getGameImg() {
        return gameImg;
    }

    public void setGameImg(int gameImg) {
        this.gameImg = gameImg;
    }

}
