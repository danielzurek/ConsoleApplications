package Gra_w_zgadywanie_liczb_2;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int min = 0;
        int max = 1000;
        int guess = ((max-min)/2)+min;
        Scanner scanner = new Scanner(System.in);
        String computerGuess = " ";
        int counter = 1;
        while (true) {
            System.out.println("Czy ta liczba to " + guess+ "?");
            computerGuess = scanner.nextLine();
            if (computerGuess.equals("zgadłeś")) {
                System.out.println("Zgadłem po "+counter+" próbach!");
                return;
            } else if (computerGuess.equals("za dużo")){
                max = guess;
                counter++;
            } else if (computerGuess.equals("za mało")) {
                min = guess;
                counter++;
            } else {
                System.out.println("Podaj poprawna odpowiedz (zgadłeś, za mało, za dużo).");
            }
            guess = ((max-min)/2)+min;
        }
    }

    }
