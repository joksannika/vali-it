package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
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
}
