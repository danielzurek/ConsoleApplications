package Symulator_LOTTO;

import Gra_w_zgadywanie_liczb.Main;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        int [] getNumbers = usersNumbers();
        int [] getLottoNumbers = getDrawNumbers();
        System.out.println("Twój zakład to: " + Arrays.toString(getNumbers));
        System.out.println("Wylosowane liczby to: " + Arrays.toString(getLottoNumbers));

         int counter = 0;
        for(int number : getNumbers){
            if(checkInArray(getLottoNumbers, number)){
                counter++;
            }
        }
        System.out.println("Liczba trafień to: " + counter);


    }

    public static int [] getDrawNumbers(){


        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));

        int [] drawNumbers = new int[6];

        for(int i = 0; i < drawNumbers.length; i++){
            drawNumbers[i] = arr[i];
        }

//    opcjonalne sortowanie- w prawdziwej grze lotto nie ma sortowania    Arrays.sort(drawNumbers);
return drawNumbers;
}


   public static int [] usersNumbers(){
       int numIndex = 6;
       int number = 0;
       int[] userNumbers = new int[6];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 6; i++){

            System.out.println("Podaj liczbę, którą chcesz skreślić. Pozostało jeszcze" + " " + numIndex + " " + "liczb do skreślenia");
            number = scanner.nextInt();

            if(number >=1 && number <=49 ){
                if(!checkInArray(userNumbers, number)){
                    userNumbers[i] = number;
                    numIndex--;

                } else {
                    System.out.println("Liczby nie moga sie powtarzac");
                    i--;
                }
            } else {
                System.out.println("Niewlasciwa liczba (musi byc z zakresu 1-49)");
                i--;
            }
            }
        scanner.close();
        return userNumbers;

   }
    public static boolean checkInArray(int[] array, int number) {
        for (int element : array) {
            if (element==number) {
                return true;
            }
        }
        return false;
    }
}
