package com.zeynep.loginpage;

public class musics {
    private int logo;
    private String şarkı,sanatçı;

    public musics(int logo, String şarkı, String sanatçı) {
        this.logo = logo;
        this.şarkı = şarkı;
        this.sanatçı = sanatçı;
    }

    public static musics get(int position) {
        return null;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getŞarkı() {
        return şarkı;
    }

    public void setŞarkı(String şarkı) {
        this.şarkı = şarkı;
    }

    public String getSanatçı() {
        return sanatçı;
    }

    public void setSanatçı(String sanatçı) {
        this.sanatçı = sanatçı;
    }
}
