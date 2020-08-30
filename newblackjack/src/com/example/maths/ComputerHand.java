package com.example.maths;

import java.util.ArrayList;
import java.util.Random;

public class ComputerHand {

    Deck deck = new Deck();             //bunch of randoms,to generate the random card
    Random card = new Random();
    int number1 = card.nextInt(13);
    int color1 = card.nextInt(4);
    int number2 = card.nextInt(13);
    int color2 = card.nextInt(4);
    ArrayList<String> computercards = new ArrayList<String>();//to store the cards choosen from the computer

    public ComputerHand(){//constructor

    }



    public ArrayList<String> deal(){    //this is the first initial move,but the card is hidden until revealed later on

        String firstcard = deck.ranks[number1] + " of " + deck.suits[color1];
        computercards.add(firstcard);
        computercards.add("********************");
        return computercards;
    }


    public ArrayList<String> reveal(){

        computercards.remove(1);

        String secondcard = deck.ranks[number2] + " of " + deck.suits[color2];


        boolean loop = true;

        while (loop) {//with randoms always possibility of the same card,so it checks it
            if (computercards.contains(secondcard)) {
                secondcard = deck.ranks[card.nextInt(13)] + " of " + deck.suits[card.nextInt(4)];

            } else {
                computercards.add(secondcard);
                loop = false;
                break;
            }
        }








        return computercards;
    }


    public void hit() {//adds new card if they want it
        String newcard = deck.ranks[card.nextInt(13)] + " of " + deck.suits[card.nextInt(4)];

        boolean hitloop = true;

        while (hitloop) {
            if (computercards.contains(newcard)) {
                newcard = deck.ranks[card.nextInt(13)] + " of " + deck.suits[card.nextInt(4)];

            } else {
                computercards.add(newcard);
                hitloop = false;
                break;
            }
        }
    }


        public void stay(){

        }



    }






