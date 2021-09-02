package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2controller {

    //http://localhost:8080/lesson2/generateArray/7
    @GetMapping("lesson2/generateArray/{array}")
    public static int[] generateArray(@PathVariable("array")int array){
        return Lesson2.generateArray(array);
    }

    //http://localhost:8080/lesson2/decreasingArray/7
    @GetMapping("lesson2/decreasingArray/{array}")
    public static int[] decreasingArray(@PathVariable("array")int array){
        return Lesson2.decreasingArray(array);
    }

    //http://localhost:8080/lesson2/yl3/7
    @GetMapping("lesson2/yl3/{array}")
    public static int[] yl3(@PathVariable("array")int array){
        return Lesson2.yl3(array);
    }

    //http://localhost:8080/lesson2/sampleArray
    @GetMapping("lesson2/samplearray")
    public static int[] sampleArray(){
        return Lesson2.sampleArray();
    }

    //http://localhost:8080/lesson2/firstN/7
    @GetMapping("lesson2/firstN/{array}")
    public static int[] firstN(@PathVariable("array")int array){
        return Lesson2.firstN(array);
    }
}
