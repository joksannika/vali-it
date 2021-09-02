package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2c;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3Controller {

    //http://localhost:8080/lesson3/factorial/5
    @GetMapping ("lesson3/factorial/{x}")
    public static int factorial (@PathVariable("x")int x) {
        return Lesson3.factorial(x);
    }

    //http://localhost:8080/lesson3/reverseString/433468
    @GetMapping ("lesson3/reverseString/{String}")
    public static String reverseString (@PathVariable("String")String a){
        return Lesson3.reverseString(a);
    }

    //http://localhost:8080/lesson3/isPrime/7
    @GetMapping ("lesson3/isPrime/{x}")
    public static boolean isPrime (@PathVariable("x")int x) {
        return Lesson3.isPrime(x);
    }

    //http://localhost:8080/lesson3/sort/345834
    @GetMapping ("lesson3/sort/{array}")
    public static int[] sort (@PathVariable("array")int[] array){
        return Lesson3.sort(array);
    }

    //http://localhost:8080/lesson3/evenFibonacci/8
    @GetMapping ("lesson3/evenFibonacci/{a}")
    public static int evenFibonacci (@PathVariable("x")int x){
        return Lesson3.evenFibonacci(x);
    }

    //http://localhost:8080/lesson3/morseCode/sos
    @GetMapping ("lesson3/morseCode/{String}")
    public static String morseCode (@PathVariable("String")String text){
        return Lesson3.morseCode(text);
    }

}
