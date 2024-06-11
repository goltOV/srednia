package org.example;

import java.util.ArrayList;

public class Calculations {


    public double getWariancja(ArrayList<Integer> oceny, ArrayList<Integer> wagi) {
        double result = 0.00;
        ArrayList<Integer> listOfNums = new ArrayList<>();
        int n = 0;
        int avgX = 0;
        for (int i = 0; i < oceny.size(); i++) {
            int ocena = oceny.get(i);
            for (int j = 0; j < wagi.get(i); j++) {
                listOfNums.add(ocena);
                avgX += ocena;
                n++;
            }
        }
        avgX = avgX/n;
        for (int i = 0; i < n; i++) {
            int num = listOfNums.get(i);
            result += (num-avgX)*(num-avgX);
        }
        result /= n;
        return Math.floor(result * 100) / 100;
    }

    public double getOdchylenie(double wariancja) {
        return Math.floor(Math.sqrt(wariancja) * 100) / 100;
    }
}
