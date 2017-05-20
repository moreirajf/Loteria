package loteria;

/**
 * Created by zefrancisco on 16/05/17.
 */
public class Jogo {
    private int[] dezenas;

    public Jogo() {

    }

    public int[] getDezenas() {
        return dezenas;
    }

    public void setDezenas(int[] dezenas) {
        this.dezenas = dezenas;
    }

    public Jogo(int[] dezenas) {
        this.dezenas = dezenas;
        status();
    }
    public void status(){
        for (int i = 0; i < 6; i++) {
        }
    }

}
