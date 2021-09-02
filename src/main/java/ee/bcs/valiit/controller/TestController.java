package ee.bcs.valiit.controller;

import ee.bcs.valiit.DTO.employees;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    List<employees> employee = new ArrayList<>();
    @GetMapping("test")
    public String getHelloWorld() {
        return "Hello World";
    }

    //http://localhost:8080/test2/1
    //http://localhost:8080/test2/2
    //http://localhost:8080/test2/3
    @GetMapping("test2/{name}")
    public String test2(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    //http://localhost:8080/test3?name=Siim
    //http://localhost:8080/test3?name=John
    @GetMapping("test3")
    public String test3(@RequestParam("name") String nimi){
        return "Hello " + nimi;
    }
    //http://localhost:8080/test4?name=Siim
    //http://localhost:8080/test4?name=John
    @GetMapping("test4")
    public String test4(String name) {
        return "Hello " + name;
    }

    //http://localhost:8080/test5
    @GetMapping("test5")
    public employees test5(){
        employees employee = new employees();
        employee.setName("Siim");
        employee.setAddress("Tallinn");
        return employee;
    }
/*
    //POSTMAN
    List<employees> employees = new ArrayList<>();

    @GetMapping("employee")
    public List<employees> getEmployees(){
        return employees;
    }

    @PostMapping("employee")
    public void addEmployee(@RequestBody employees employee){
        employees.add(employee);
    }

    // (GET) http://localhost:8080/employee/5
    // (PUT) http://localhost:8080/employee/5 + requestBody
    // (DELETE)http://localhost:8080/employee/5
    @GetMapping("employee/{a}")
    public int employee (@PathVariable("a")int a){
        return employee;
    }*/

    List<employees> employees = new ArrayList<>();

    @GetMapping("employee")
    public List<employees> getAllEmployees(){
        return employees;

    }

    @GetMapping("employee/{id}")
    public employees getEmployee(@PathVariable("id") int id){
        return employees.get(id);

    }

    @PutMapping("employee/{id}")
    public void updateEmployee(@PathVariable("id") int id,
                               @RequestBody employees employee){
        employees.set(id, employee);
    }

    @PostMapping("employee")
    public void addEmployee(@RequestBody employees employee){
        employees.add(employee);
    }

    @DeleteMapping("employee/{id}")
    public void deleteEmployee(@PathVariable("id")int id){
        employees.remove(id);
    }

}
