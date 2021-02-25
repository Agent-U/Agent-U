package com.agentu_api.bo;

public class Accueil {
    private boolean close = false;

    private static Accueil singleton;
    private Accueil() {
    }
    public static Accueil getInstance() {
        if(singleton == null){
            singleton = new Accueil();
            return singleton;
        }else{
            return singleton;
        }
    }

    public boolean isClose() {
        return close;
    }

    public void setClose() {
        singleton.close = !singleton.close;
    }
}
