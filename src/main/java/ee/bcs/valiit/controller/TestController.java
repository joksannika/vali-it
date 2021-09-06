package ee.bcs.valiit.controller;

import ee.bcs.valiit.DTO.employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;   //vajad autowired lisa

    @PostMapping("employees")
    public void addEmployee(@RequestBody employees x) {
        String sql = "INSERT INTO employees (name, address) " +  //annad teada mida soovid teha
                "VALUES (:employeeName, :employeeAddress)";    // : taga sql muutuja, ei tea mis peab sinna k'ima, kasutajapoolne sisend
        Map<String, String> paramMap = new HashMap<>();        // teed mapi
        paramMap.put("employeeName", x.getName());             // v]ta jsonist ja asenda nimi
        paramMap.put("employeeAddress", x.getAddress());        //v]ta jsonsit ja asenda aadress
        jdbcTemplate.update(sql, paramMap);                    //saada muutujad postgresqlile ja anna p'ring
        // employees.add(x);
    }

    @DeleteMapping("employees/{abcd}")
    public void deleteEmployee(@PathVariable("abcd") int qwerty){
        String sql = "DELETE FROM employee WHERE id = :zxcv";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("zxcv", qwerty);
        jdbcTemplate.update(sql, paramMap);
        //employees.remove(abcd);
    }

    @PutMapping("employees/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody employees employee){
        String sql = "UPDATE employees SET name = :a1, address = :a2 WHERE id = :a3";
        Map<String, Object> paraMap = new HashMap<>();      //teeb tabeli alll oleva kolme reaga
        paraMap.put("a1", employee.getName());
        paraMap.put("a2", employee.getAddress());
        paraMap.put("a3", id);
        //  employees.set(id, employee);
        jdbcTemplate.update(sql, paraMap);  //saadab alles v'lja
    }

    @GetMapping("employee/{id}")
    public String  getEmployee (@PathVariable("id") int id){
        String sql = "SELECT name FROM employees WHERE id = :a1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", id);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    @GetMapping("sql-test2/")
    public List<String> test2(){
        String sql = "SELECT name FROM employees";
        Map<String, Object> paramMap = new HashMap<>();
        List<String> vastus = jdbcTemplate.queryForList(sql, paramMap, String.class);
        return vastus;
    }

    @GetMapping("sql-test3/{id}")
    public employees test3(@PathVariable("id") int id){
        String sql = "SELECT * FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        employees vastus = jdbcTemplate.queryForObject(sql, paramMap, new employeesRowMapper());
        return vastus;
    }

    @GetMapping("sql-test4")
    public List<employees> test4(){
        String sql = "SELECT * FROM employees";
        Map<String, Object> paramMap = new HashMap<>();
        List<employees> vastus = jdbcTemplate.query(sql, paramMap, new employeesRowMapper());
        return vastus;
    }

    public static class employeesRowMapper implements RowMapper<employees>{
        @Override
        public employees mapRow(ResultSet resultSet, int i) throws SQLException{
            employees result = new employees();
            result.setId(resultSet.getInt("id"));
            result.setAddress(resultSet.getString("address"));
            result.setName(resultSet.getString("name"));
            return result;
        }
    }



/*
        List<employees> employee = new ArrayList<>();
        @GetMapping("test")
        public String getHelloWorld () {
            return "Hello World";
        }

        //http://localhost:8080/test2/1
        //http://localhost:8080/test2/2
        //http://localhost:8080/test2/3
        @GetMapping("test2/{name}")
        public String test2 (@PathVariable("name") String name){
            return "Hello " + name;
        }

        //http://localhost:8080/test3?name=Siim
        //http://localhost:8080/test3?name=John
        @GetMapping("test3")
        public String test3 (@RequestParam("name") String nimi){
            return "Hello " + nimi;
        }
        //http://localhost:8080/test4?name=Siim
        //http://localhost:8080/test4?name=John
        @GetMapping("test4")
        public String test4 (String name){
            return "Hello " + name;
        }

        //http://localhost:8080/test5
        @GetMapping("test5")
        public employees test5 () {
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
    }

        List<employees> employees = new ArrayList<>();

        @GetMapping("employee")
        public List<employees> getAllEmployees () {
            return employees;

        }

        @GetMapping("employee/{id}")
        public employees getEmployee ( @PathVariable("id") int id){
            return employees.get(id);

        }

        @PutMapping("employee/{id}")
        public void updateEmployee ( @PathVariable("id") int id,
        @RequestBody employees employee){
            employees.set(id, employee);
        }

    @PostMapping("employee")
    public void addEmployee(@RequestBody employees employee){
        employees.add(employee);
    }

        @DeleteMapping("employee/{id}")
        public void deleteEmployee ( @PathVariable("id") int id){
            employees.remove(id);
        } */
}
