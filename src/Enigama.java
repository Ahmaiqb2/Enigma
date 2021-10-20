import java.util.Scanner;

public class Enigama {

    public static void main(String[] args) {

        Start();

    }

    public static void Start(){
        Scanner input = new Scanner(System.in);
        boolean startmenu = true;

        System.out.println("Velkommen til Enigma Projektet");

        while(startmenu){
            System.out.println("Du får nu muligheden for at:");
            System.out.println(" 1) Number cipher");
            System.out.println(" 0) afslut program");
            System.out.print("Vælg mellem 0 - 1: ");

            int indtast = input.nextInt();

            input.nextLine();
            if (indtast == 1) {
                System.out.println("Nummer cipher");
                System.out.println("");
            }  else if (indtast == 0) {
                System.out.println("Du har afsluttet programmet");
                System.exit(0);
            }

            System.out.print("Indtast e for encrypt eller d for decrypt: ");
            char valg = input.nextLine().charAt(0);

            if (valg == 'e') {
                crypyedeMenu();
            } else if (valg == 'd') {
                decrypedeMenu();
            }  else if (indtast == 0) {
                System.out.println("Du har afsluttet programmet");
                System.exit(0);
            }
        }
    }


    private static void crypyedeMenu() {
        //Henter scanner Class
        Scanner input = new Scanner(System.in);
        System.out.println("Nummer cipher encrypt");
        System.out.print("Indtast tekst: ");
        //Sætter en værdi på scanner til teksten
        String tekst = input.nextLine();
        System.out.print("Indtast shift-værdi: ");
        //Sætter en værdi på scanner til shiftværdien
        int shiftVærdi = input.nextInt();
        //Kalder caesarEncrypt med teksten og shiftværdien
        String encrptedTekst = caesarEncrypt(tekst,shiftVærdi);
        //Udskriver det cryptede tekst
        System.out.println(encrptedTekst);
        System.out.println("");
    }

    public static int bogstavTilNummer(char Bogstav){
        String alfabetet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        int nummer = alfabetet.indexOf(Bogstav);
        return nummer;
    }

    public static int[] tekstTilListeAfNumre(String tekst ){
        int[] nummer = new int[tekst.length()];
        char[] bogstav = tekst.toCharArray();

        for (int i = 0; i < tekst.length(); i++){
            nummer[i] = bogstavTilNummer(bogstav[i]);
        }
        return nummer;
    }


    private static void decrypedeMenu() {
        //Henter scanner Class
        Scanner input = new Scanner(System.in);
        System.out.println("Nummer cipher decrypt");
        System.out.print("Indtast kode: ");
        //Sætter en værdi på scanner til teksten
        String tekst = input.nextLine();
        System.out.print("Indtast shift-værdi: ");
        //Sætter en værdi på scanner til shiftværdien
        int shiftVærdi = input.nextInt();
        //Kalder caesarEncrypt med teksten og shiftværdien
        String encrptedTekst = caesarDecrypt(tekst,shiftVærdi);
        //Udskriver det cryptede tekst
        System.out.println(encrptedTekst);
        System.out.println("");
    }

    public static char nummerTilBogstav(int nummer ){
        String alfabetet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        char bogstav = alfabetet.charAt(nummer);
        return bogstav;
    }

    public static String listeAfNummreTilTekst(int[] numre ){

        String tekst = "";
        for (int i = 0; i < numre.length; i++){
            int nummer = numre[i];
            char bogstav = nummerTilBogstav(nummer);

            tekst = tekst + bogstav;
        }
        return tekst;
    }


    public static int[] shiftListeAfNumre(int[] nummer, int shift) {
        int[] shiftNummer = new int[nummer.length];
        for (int i = 0; i < nummer.length; i++) {
            shiftNummer[i] = shiftNummer(nummer[i], shift);
        }
        return shiftNummer;
    }

    public static int shiftNummer(int nummer, int shift) {
        int shiftNummer = nummer + shift;
        if (shiftNummer > 30) {
            shiftNummer = Math.abs(shiftNummer - 29);
        } else if (shiftNummer <= 0) {
            // omskriver negativt tal til et positvt tal
            int positiv = Math.abs(shiftNummer);
            shiftNummer = Math.abs(29 - positiv);
        }

        if (nummer == 0) {
            shiftNummer = 0;
        }
        return shiftNummer;
    }


    public static String caesarEncrypt(String tekst, int shift) {
        tekst = tekst.toUpperCase();
        // textToListOfNumbers
        int[] tekstTilListeAfNumre = tekstTilListeAfNumre(tekst);
        // shiftListOfNumbers
        int[] shiftListeAfNumre = shiftListeAfNumre(tekstTilListeAfNumre, shift);
        // listOfNumbersToText
        String listOfNumbersToText = listeAfNummreTilTekst(shiftListeAfNumre);

        return listOfNumbersToText;
    }

    public static String caesarDecrypt(String tekst, int shift) {
        tekst = tekst.toUpperCase();
        int[] listeAfNumre = tekstTilListeAfNumre(tekst);
        int[] shiftListeAfNumre = shiftListeAfNumre(listeAfNumre, shift);
        String resultat = listeAfNummreTilTekst(shiftListeAfNumre);

        return resultat;
    }
}
