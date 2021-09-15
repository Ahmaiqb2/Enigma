import java.util.Scanner;

public class Eniga {

    public static void main(String[] args) {

        Velkomst();

    }

    public static void Velkomst(){
        Scanner input = new Scanner(System.in);
        boolean startmenu = true;

        System.out.println("Velkommen til Enigma Projektet");

        while(startmenu){
            System.out.println("Vælg mellem følgende former for kryptering:");
            System.out.println(" 1) Number cipher");
            System.out.println(" 2) Caesar cipher");
            System.out.println(" 0) afslut program");
            System.out.print("vælg (0-2): ");

            int indtast = input.nextInt();

            input.nextLine(); // FIX: Scanner Bug to ignore empty line
            if (indtast == 1) {
                System.out.println("Number cipher");
                System.out.println("-------------");
            } else if (indtast == 2) {
                System.out.println("Caesar cipher");
                System.out.println("-------------");
            }  else if (indtast == 0) {
                System.out.println("Du har afsluttet programmet");
                System.exit(0);
            }

            System.out.println("Indtast e for encrypt eller d for decrypt");
            char mode = input.nextLine().charAt(0);

            if (mode == 'e') {
                crypyedeMenu();
            } else if (mode == 'd') {
                decrypedeMenu();
            } else if (mode == 'e') {
                crypyedeMenu();
            } else if (mode == 'd') {
                decrypedeMenu();
            } else if (indtast == 0) {
                System.out.println("Du har afsluttet programmet");
                System.exit(0);
            }
        }
    }


    private static void crypyedeMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Number cipher encrypt");
        System.out.println("Indtast klartekst:");
        String plaintext = input.nextLine();

        int[] numbers = textToListOfNumber(plaintext);

        //String ciphertext = textToListOfNumber(numbers);
        System.out.println("Kodeteksten er:");
        //System.out.println(ciphertext);
    }

    public static int letterToNumber(char letter){
        /*char[] alfa = {' ', 'A', 'B', 'C', 'D', 'E','F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};
        //int[] numre = {1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};

        int nummer = 0;
        for (int i = 0; i < alfa.length; i++){
            char bogstavViTjekker = alfa[i];
            if (letter == bogstavViTjekker){
                nummer = i;
            }
        }*/
        String alfabetet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        int num = alfabetet.indexOf(letter);
        return num;
    }

    public static int[] textToListOfNumber( String text ){
        int[] numbers = new int[text.length()];
        char[] letters = text.toCharArray();

        for (int i = 0; i < text.length(); i++){
            numbers[i] = letterToNumber(letters[i]);
        }

        return numbers;
    }


    private static void decrypedeMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number Cipher decrypt");
        System.out.println("Indtast kodetekst");
        String ciphertext = scanner.nextLine();

        //int[] cipher = numberToLetter(ciphertext);

        //String plaintext = listOfNumbersToText(cipher);

        System.out.println("Klarteksten er:");
        //System.out.println(plaintext);
    }

    public static char numberToLetter( int number ){
        String alfabetet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        char letter = alfabetet.charAt(number);
        return letter;
    }

    public static String listOfNumbersToText (int[] numbers ){

        String text = "";
        for (int i = 0; i < numbers.length; i++){
            int number = numbers[i];
            char letter = numberToLetter(number);

            text = text + letter;
        }
        return text;
    }
}
