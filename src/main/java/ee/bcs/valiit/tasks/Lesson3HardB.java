package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3HardB {

    // TODO kirjuta mäng kus kasutaja peab ära arvama numbri 0-99 (nagu 3Hard)
    // NB programm ei tohi kohe alguses välja mõelda numbrit
    // vaid eesmärk on öelda kasutajale, et ta eksis nii kaua kui võimalik
    // ilma selleta, et ta läheks vastuollu ühegi varasema väitega
    public static void main(String[] args){

    }
}
/*  @RestController
public class Lesson3HardController {
    Random random = new Random();
    int randomNr = random.nextInt(100);
    int count = 0;

    //http://localhost:8080/lesson3Hard/?a=7

    @GetMapping ("lesson3Hard/")
    public String guess(int a) {
        if (a < randomNr) {
            return "Number on liiga väike";
        } else if (a > randomNr) {
            return "Number on liiga suur";
        } else {
            return "Palju õnne, arvasid numbri ära!";
        }
    }
} */
