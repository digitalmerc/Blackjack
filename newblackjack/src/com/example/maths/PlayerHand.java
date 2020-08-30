package com.example.maths;

import java.util.ArrayList;
import java.util.Random;

public class PlayerHand {               //same thing as computer hand
    Deck deck = new Deck();
    Random card = new Random();
    int number1 = card.nextInt(13);
    int color1 = card.nextInt(4);
    int number2 = card.nextInt(13);
    int color2 = card.nextInt(4);
    ArrayList<String> playercards = new ArrayList<String>();







    public PlayerHand() {

    }


    public ArrayList<String> deal() {

        String firstcard = deck.ranks[number1] + " of " + deck.suits[color1];
        playercards.add(firstcard);
        String secondcard = deck.ranks[number2] + " of " + deck.suits[color2];


        boolean loop = true;

        while (loop) {
            if (playercards.contains(secondcard)) {
                secondcard = deck.ranks[card.nextInt(13)] + " of " + deck.suits[card.nextInt(4)];

            } else {
                playercards.add(secondcard);
                loop = false;
                break;
            }
        }
        return playercards;
    }







    public void hit(){
        String newcard = deck.ranks[card.nextInt(13)] + " of " + deck.suits[card.nextInt(4)];

        boolean hitloop = true;

        while (hitloop) {
            if (playercards.contains(newcard)) {
                newcard = deck.ranks[card.nextInt(13)] + " of " + deck.suits[card.nextInt(4)];

            } else {
                playercards.add(newcard);
                hitloop = false;
                break;
            }
        }






    }

    public void stay(){

    }
}
