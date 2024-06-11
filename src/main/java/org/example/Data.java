package org.example;

import java.util.ArrayList;

public class Data {
    ArrayList<Integer> oceny = new ArrayList<>();
    ArrayList<Integer> wagi = new ArrayList<>();
    Calculations calc = new Calculations();

    Data(){
        generate();
    }

    private void generate() {
        for (int i = 1; i <= 10; i++) {
            oceny.add((int) Math.floor(Math.random()*6+1));
        }
        for (int i = 1; i <= 10; i++) {
            wagi.add((int) Math.floor(Math.random()*5+1));
        }
    }

    public void showAll(){
        if(showList()){
            double wariancja = calc.getWariancja(this.oceny, this.wagi);
            double odchylenie = calc.getOdchylenie(wariancja);
            System.out.println("Odchylenie standardowe: "+odchylenie);
            System.out.println("Wariancja: "+wariancja);
        }
    }

    private boolean showList() {
        boolean rule = true;
        System.out.println("Ocena Waga");
        for (int i = 0; i < oceny.size(); i++) {
            int ocena = oceny.get(i);
            int waga = wagi.get(i);
            if (!check(ocena,waga))     rule = false;
        }
        return rule;
    }

    public boolean check(int ocena, int waga){
        if (!isOcena(ocena)&&!isWaga(waga)) {
            System.out.println("Ocena i waga nieprawidłowe.");
            return false;
        }
        else if (!isWaga(waga)) {
            System.out.println("Waga oceny nieprawidłowa.");
            return false;
        }
        else if (!isOcena(ocena)) {
            System.out.println("Nieprawidłowa ocena.");
            return false;
        }
        else {
            System.out.println(ocena+"     "+waga);
            return true;
        }
    }

    private boolean isOcena(int num){
        return (num<7&&num>0);
    }

    private boolean isWaga(int num){
        return (num<6&&num>0);
    }

}
