package com.example.maths;

import java.util.ArrayList;

public class Points {




    public Points() {
    }



    public int calculatepoints(ArrayList<String> hand){

        int points=0;

        for (String cards : hand) {

            if (cards.contains("Ace")) {        //method to go through the arraylist prepared by the the other classes,returns the amount of points
                points += 1;
            } else if (cards.contains("2")) {
                points += 2;
            } else if (cards.contains("3")) {
                points += 3;
            } else if (cards.contains("4")) {
                points += 4;
            } else if (cards.contains("5")) {
                points += 5;
            } else if (cards.contains("6")) {
                points += 6;
            } else if (cards.contains("7")) {
                points += 7;
            } else if (cards.contains("8")) {
                points += 8;
            } else if (cards.contains("9")) {
                points += 9;
            } else if (cards.contains("10")) {
                points += 10;
            } else if (cards.contains("Jack")) {
                points += 10;
            } else if (cards.contains("Queen")) {
                points += 10;
            } else if (cards.contains("King")) {
                points += 10;
            }
        }


        return points;












    }
}
