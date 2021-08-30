package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args){
        Random random = new Random();
        int i = random.nextInt(100);
        //System.out.println(i);
        int count = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            count++;
            System.out.println("Sisesta üks täisarv.");
            int command = scanner.nextInt();
            if (command < i){
                System.out.println("Sinu pakutud number on liiga väike.");
            }
            else if (command > i){
                System.out.println("Sinu pakutud number on liiga suur.");
            }
            else if (command == i){
                System.out.println("Sinu pakutud number on õige.");
                System.out.println("Te arvasite õige numbri " + count + " korraga ära!");
                break;
            }

        }
    }
}
