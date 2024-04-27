package Igor.Banaszak;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String nazwisko;
    private String imie;
    private int wiek;
    private ArrayList<Integer> listaOcen;

    public Student (String nazwisko,String imie,int wiek,ArrayList listaOcen) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.wiek = wiek;
        this.listaOcen = listaOcen;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    public ArrayList getListaOcen() {
        return listaOcen;
    }
}
