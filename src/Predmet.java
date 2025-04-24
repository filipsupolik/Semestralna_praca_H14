public class Predmet {
    private int hmotnostPredmetu;
    private int cenaPredmetu;

    public Predmet(int hmotnostPredmetu, int cenaPredmetu) {
        this.hmotnostPredmetu = hmotnostPredmetu;
        this.cenaPredmetu = cenaPredmetu;
    }

    public int getHmotnostPredmetu() {
        return hmotnostPredmetu;
    }

    public void setHmotnostPredmetu(int hmotnostPredmetu) {
        this.hmotnostPredmetu = hmotnostPredmetu;
    }

    public int getCenaPredmetu() {
        return cenaPredmetu;
    }

    public void setCenaPredmetu(int cenaPredmetu) {
        this.cenaPredmetu = cenaPredmetu;
    }
}
