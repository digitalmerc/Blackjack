package com.example.maths;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        boolean playagain = true;

        while (playagain) {

            Points point = new Points();

            ComputerHand computerHand = new ComputerHand();
            //our classes

            PlayerHand playerhand = new PlayerHand();
            playerhand.deal();              //plays the hands
            computerHand.deal();
            System.out.print(playerhand.playercards);
            System.out.println(computerHand.computercards);


            Scanner scanner = new Scanner(System.in);//scans for input


            boolean hitorstay = true;
            int times = 0;
            while (hitorstay == true) {
                System.out.println("would you like to hit or stay?");
                String move = scanner.nextLine();

                if (move.equals("hit")) {//for loop to hit or stay
                    times += 1;
                    System.out.println("you've hitted");
                    playerhand.hit();
                    Thread.sleep(2000);//delays by one second
                    System.out.print(playerhand.playercards);
                    System.out.println(computerHand.computercards);
                    if (times == 3) {
                        hitorstay = false;
                        System.out.println("card spaces full");
                        break;
                    } else {
                        hitorstay = true;
                    }
                } else if (move.equals("stay")) {
                    System.out.println("you've stayed");
                    playerhand.stay();
                    hitorstay = false;
                    break;
                }

            }

            System.out.println("computers turn,time for the card to be revealed");
            Computertime(point, computerHand);


            int playerfinalpoints = point.calculatepoints(playerhand.playercards);//calculates points of cards
            int computerfinalpoints = point.calculatepoints(computerHand.computercards);
            String message = "";

            if ((playerfinalpoints > computerfinalpoints) && (playerfinalpoints <= 21)) {//compares points together
                message = "you have won player,the total amount of cards on your side,beats the computers side;";
            } else if ((computerfinalpoints > playerfinalpoints) && (computerfinalpoints <= 21)) {
                message = "you have lost,the total amount of points on the computers cards beats yours";
            } else if (computerfinalpoints > 21) {
                message = "you have won player,the computers cards went over 21";
            } else if (playerfinalpoints > 21) {
                message = "you have lost,the amount of cards went over 21";
            }


            System.out.println(message);//annouces the winner

            System.out.println("would you like to play again,yes or no?");
            String again = scanner.nextLine();
            if(again.contains("yes")){
                playagain = true;
            }else if(again.contains("no")){
                playagain = false;
                System.exit(0);
            }








        }
    }

    private static void Computertime(Points point,ComputerHand computerHand) throws InterruptedException {
        System.out.println(computerHand.reveal());
        boolean loop = true;
        int times = 0;



        while (loop == true) {

            int number = point.calculatepoints(computerHand.computercards);

            if((21 - number) > 5){//potiential ai of system,
                times +=1;
                System.out.println("computer has choosen to hit");
                computerHand.hit();
                Thread.sleep(2000);//delays by 1 second
                System.out.println(computerHand.computercards);
                if(times == 3){
                    loop = false;
                    System.out.println("card spaces full");
                    break;
                }else{
                    loop = true;
                }






            }else{
                computerHand.stay();
                System.out.println("computer has choosen to stay");
                loop = false;
                break;
            }






        }




    }
}
