public class Predmet {
    private int indexPoradia;
    private int hmotnostPredmetu;
    private int cenaPredmetu;
    private int jeVBatohu;

    public Predmet(int hmotnostPredmetu, int cenaPredmetu) {
        this.hmotnostPredmetu = hmotnostPredmetu;
        this.cenaPredmetu = cenaPredmetu;
    }

    public int getIndexPoradia() {
        return indexPoradia;
    }

    public void setIndexPoradia(int indexPoradia) {
        this.indexPoradia = indexPoradia;
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

    public int isJeVBatohu() {
        return jeVBatohu;
    }

    public void setJeVBatohu(int jeVBatohu) {
        this.jeVBatohu = jeVBatohu;
    }
}
