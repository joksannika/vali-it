package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson2b;
import ee.bcs.valiit.tasks.Lesson2c;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2bController {

   /* //http://localhost:8080/lesson2b/reverseArray?array=1,2,3,4,5
    @GetMapping("lesson2b/reverseArray")
    public int[] reverseArray (@RequestParam("array")int[] array){
        return Lesson2b.reverseArray(array);
    }*/

    //http://localhost:8080/lesson2b/reverseArray/1,2,3,4,5
    @GetMapping("lesson2b/reverseArray/{array}")
    public int [] reverseArray(@PathVariable("array")int [] array){
        return Lesson2b.reverseArray(array);
    }

    //http://localhost:8080/lesson2b/evenNumbers?array=7
    @GetMapping("lesson2b/evenNumbers")
    public int[] evenNumbers (@RequestParam("array")int array){
        return Lesson2b.evenNumbers(array);
    }

    //http://localhost:8080/lesson2b/min?array=7,5,2,6,1
    @GetMapping("lesson2b/min")
    public static int min (@RequestParam("array")int[] array){
        return Lesson2b.min(array);
    }

    //http://localhost:8080/lesson2b/max?array=4,6,5,22,9,56
    @GetMapping("lesson2b/max")
    public static int max (@RequestParam("array")int[]array){
        return Lesson2b.max(array);
    }

    //http://localhost:8080/lesson2b/sum/6,5,4,7,2
    @GetMapping("lesson2b/sum/{array}")
    public static int sum (@PathVariable("array")int[]array){
        return Lesson2b.sum(array);
    }

  /*  //http://localhost:8080/lesson2b/multiplyTable/
    @GetMapping ("lesson2b/multiplyTable")
*/

    //http://localhost:8080/lesson2b/fibonacci/6
    @GetMapping("lesson2b/fibonacci/{array}")
    public static int fibonacci (@PathVariable("array")int array){
        return Lesson2b.fibonacci(array);
    }

    //http://localhost:8080/lesson2b/sequence3n/10/20
    @GetMapping("lesson2b/sequence3n/{x}/{y}")
    public static int sequence3n (@PathVariable("x")int x, @PathVariable("y")int y){
        return Lesson2b.sequence3n(x, y);
    }

    //LESSON 2C CONTROLLER
    //http://localhost:8080/lesson2c/sequence3n/10/20
    @GetMapping("lesson2c/sequence3n/{x}/{y}")
    public static int sequence3n2 (@PathVariable("x")int x, @PathVariable("y")int y) {
        return Lesson2c.sequence3n(x, y);
    }

    //http://localhost:8080/lesson2c/getSeqLength/10
    @GetMapping ("lesson2c/getSeqLength/{x}")
    public static int getSeqLength (@PathVariable("x")int x){
        return Lesson2c.getSeqLength(x);
    }

    //http://localhost:8080/lesson2c/nextElement/10
    @GetMapping ("lesson2c/nextElement/{x}")
    public static int nextElement (@PathVariable("x")int x){
        return Lesson2c.nextElement(x);
    }

}
