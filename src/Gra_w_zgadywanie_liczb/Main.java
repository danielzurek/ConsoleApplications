package Gra_w_zgadywanie_liczb;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Random r = new Random();
        int a = r.nextInt(100)+1;
        int secretnumber = a;
        int usersNumber;

        Scanner reader = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");


        do{
            while (!reader.hasNextInt()) {
                System.out.println("To nie jest liczba!");
                reader.next();
                System.out.println("Podaj liczbę: ");
            }
            System.out.println("Podaj liczbę: ");
            usersNumber = reader.nextInt();
            if(usersNumber == a){
                System.out.println("Zgadłeś!");
            }
            else if(usersNumber > a){
                System.out.println("Za dużo! Spróbój jeszcze raz.");
            }
            else if(usersNumber < a){
                System.out.println("Za mało. Spróbój jeszcze raz");
            }
        }while (usersNumber != secretnumber);


    }

}