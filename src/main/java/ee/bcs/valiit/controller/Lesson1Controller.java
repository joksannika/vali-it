package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson1Controller {

    //http://localhost:8080/lesson1/somestring/
    @GetMapping("lesson1/somestring")
    public String someString(){
        return Lesson1.someString();
    }

    //http://localhost:8080/lesson1/min/2/5
    @GetMapping("lesson1/min/{a}/{b}")
    public int min(@PathVariable("a") int a, @PathVariable("b") int b){
        return Lesson1.min(a,b);
    }

    //http://localhost:8080/lesson1/max?a=2&b=5
    @GetMapping("lesson1/max")
    public int max(@RequestParam("a") int a, @RequestParam("b") int b){
        return Lesson1.max(a, b);

   /* // http://localhost:8080/lesson1/max/2/5
    @GetMapping("lesson1/max/{a}/{b}")
    public int max(@PathVariable("a")int a, @PathVariable("b") int b){
        return Lesson1.max(a,b);  */
    }

    //http://localhost:8080/lesson1/abs?a=4
    @GetMapping("lesson1/abs")
    public int abs(@RequestParam("a")int a){
        return Lesson1.abs(a);
    }

    //http://localhost:8080/lesson1/isEven?a=4
    @GetMapping("lesson1/isEven")
    public boolean isEven(@RequestParam("a")int a){
        return Lesson1.isEven(a);
    }

    //http://localhost:8080/lesson1/min3/4/678/34365
    @GetMapping("lesson1/min3/{a}/{b}/{c}")
    public int min3(@PathVariable("a")int a, @PathVariable("b") int b, @PathVariable("c") int c){
        return Lesson1.min3(a, b, c);
    }

    //http://localhost:8080/lesson1/max3/4/678/34365
    @GetMapping("lesson1/max3/{a}/{b}/{c}")
    public int max3(@PathVariable("a")int a, @PathVariable("b") int b, @PathVariable("c") int c){
        return Lesson1.max3(a, b, c);
    }
}
