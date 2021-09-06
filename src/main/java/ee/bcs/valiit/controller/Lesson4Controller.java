/* package ee.bcs.valiit.controller;

import ee.bcs.valiit.DTO.bankfileDto;
import ee.bcs.valiit.tasks.Lesson4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Lesson4Controller {

    //http://localhost:8080/bankfile/.../...
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("bankfile/createaccount/{account}/{client}")
    public void createAccount(@PathVariable("account") String accountNr, @PathVariable("client") String client) {
        String sql = "INSERT INTO bankfile (account, balance, client) " +
                "VALUES (:accountNumber, 0, :clientName)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("clientName", client);
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("bankfile/getbalance/{account}")
    public int getBalance(@PathVariable("account") String accountNr) {
        String sql = "SELECT balance FROM bankfile WHERE account = :a1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    @GetMapping("bankfile/depositmoney/{account}/{deposit}")
    public void depositMoney(@PathVariable("account") String accountNr, @PathVariable("deposit") int deposit) {
        String sql = "SELECT locked FROM bankfile WHERE account = :a1;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        Boolean locked = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        if (locked == false) {
            String sql2 = "SELECT balance FROM bankfile WHERE account = :a1";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("a1", accountNr);
            Integer oldBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);
            Integer newBalance = oldBalance + deposit;
            String sql3 = "UPDATE bankfile SET balance = :newBalance WHERE account = :a1";
            Map<String, Object> paramMap3 = new HashMap<>();
            paramMap3.put("a1", accountNr);
            paramMap3.put("newBalance", newBalance);
            jdbcTemplate.update(sql3, paramMap3);
        }
    }

    @GetMapping("bankfile/withdrawmoney/{account}/{withdrawl}")
    public void withdrawMoney(@PathVariable("account") String accountNr, @PathVariable("withdrawl") int withdrawl) {
        String sql = "SELECT locked FROM bankfile WHERE account = :a1;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        Boolean locked = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        if (locked == false) {
            String sql2 = "SELECT balance FROM bankfile WHERE account = :a1";
            Map<String, Object> paraMap2 = new HashMap<>();
            paraMap2.put("a1", accountNr);
            Integer oldBalance = jdbcTemplate.queryForObject(sql2, paraMap2, Integer.class);
            if (oldBalance > withdrawl) {
                Integer newBalance = oldBalance - withdrawl;
                String sql3 = "UPDATE bankfile SET balance = :newBalance WHERE account = :a1";
                Map<String, Object> paramMap3 = new HashMap<>();
                paramMap3.put("a1", accountNr);
                paramMap3.put("newBalance", newBalance);
                jdbcTemplate.update(sql3, paramMap3);
            } else {
                System.out.println("Insufficient funds");
            }
        }
    }

    @GetMapping("bankfile/transfer/{fromAccount}/{toAccount}/{transfer}")
    public void transfer(@PathVariable("fromAccount") String accountNr, @PathVariable("toAccount") String accountNr2, @PathVariable("transfer") int transfer) {
        String sql = "SELECT locked FROM bankfile WHERE account = :a1;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        Boolean locked = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        String sql9 = "SELECT locked FROM bankfile WHERE account = :a1;";
        Map<String, Object> paramMap9 = new HashMap<>();
        paramMap9.put("a1", accountNr2);
        Boolean locked9 = jdbcTemplate.queryForObject(sql9, paramMap9, Boolean.class);
        if (locked == false && locked9 == false) {
            String sql2 = "SELECT balance FROM bankfile WHERE account = :a1";
            Map<String, Object> paraMap2 = new HashMap<>();
            paraMap2.put("a1", accountNr);
            Integer oldBalance = jdbcTemplate.queryForObject(sql2, paraMap2, Integer.class);
            if (oldBalance > transfer) {
                Integer newBalance = oldBalance - transfer;
                String sql3 = "UPDATE bankfile SET balance = :newBalance WHERE account = :a1";
                Map<String, Object> paramMap3 = new HashMap<>();
                paramMap3.put("a1", accountNr);
                paramMap3.put("newBalance", newBalance);
                jdbcTemplate.update(sql3, paramMap3);
                String sql4 = "SELECT balance FROM bankfile WHERE account = :a2";
                Map<String, Object> paramMap4 = new HashMap<>();
                paramMap4.put("a2", accountNr2);
                Integer oldBalance2 = jdbcTemplate.queryForObject(sql4, paramMap4, Integer.class);
                Integer newBalance2 = oldBalance2 + transfer;
                String sql5 = "UPDATE bankfile SET balance = :newBalance WHERE account = :a2";
                Map<String, Object> paramMap5 = new HashMap<>();
                paramMap5.put("a2", accountNr2);
                paramMap5.put("newBalance", newBalance2);
                jdbcTemplate.update(sql5, paramMap5);
            } else {
                System.out.println("Insufficient funds");
            }
        }
    }

    @GetMapping("bankfile/lockaccount/{account}")
    public void lockAccount(@PathVariable("account") String accountNr) {
        String sql = "UPDATE bankfile SET locked = true WHERE account = :a1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("bankfile/unlockaccount/{account}")
    public void unlockAccount(@PathVariable("account") String accountNr) {
        String sql = "UPDATE bankfile SET locked = false WHERE account = :a1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        jdbcTemplate.update(sql, paramMap);
    }

    public static class bankfileRowMapper implements RowMapper<bankfileDto>{
        @Override
        public bankfileDto mapRow(ResultSet resultSet, int i) throws SQLException {
            bankfileDto result = new bankfileDto();
            result.setId(resultSet.getInt("id"));
            result.setAccount(resultSet.getString("account"));
            result.setBalance(resultSet.getInt("balance"));
            result.setClient(resultSet.getString("client"));
            result.setLocked(resultSet.getBoolean("locked"));
            return result;
        }
    }

    @GetMapping("bankfile/list")
    public List<bankfileDto> list(){
        String sql = "SELECT * FROM bankfile";
        Map<String, Object> paramMap = new HashMap<>();
        List<bankfileDto> vastus = jdbcTemplate.query(sql, paramMap, new bankfileRowMapper());
        return vastus;
    }
}



/* @GetMapping("bankfile/transfer/{fromAccount}/{toAccount}/{transfer}")
    public void transfer (@PathVariable("fromAccount") String accountNr, @PathVariable("toAccount") String accountNr2, @PathVariable("transfer") int transfer){
        String sql = "SELECT balance FROM bankfile WHERE account = :a1";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("a1", accountNr);
        Integer oldBalance = jdbcTemplate.queryForObject(sql, paraMap, Integer.class);
        if (oldBalance > transfer) {
            Integer newBalance = oldBalance - transfer;
            String sql2 = "UPDATE bankfile SET balance = :newBalance WHERE account = :a1";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("a1", accountNr);
            paramMap2.put("newBalance", newBalance);
            jdbcTemplate.update(sql2, paramMap2);
            String sql3 = "SELECT balance FROM bankfile WHERE account = :a2";
            Map<String, Object> paramMap3 = new HashMap<>();
            paramMap3.put("a2", accountNr2);
            Integer oldBalance2 = jdbcTemplate.queryForObject(sql3, paramMap3, Integer.class);
            Integer newBalance2 = oldBalance2 + transfer;
            String sql4 = "UPDATE bankfile SET balance = :newBalance WHERE account = :a2";
            Map<String, Object> paramMap4 = new HashMap<>();
            paramMap4.put("a2", accountNr2);
            paramMap4.put("newBalance", newBalance2);
            jdbcTemplate.update(sql4, paramMap4);
            }else{
                System.out.println("Insufficient funds");
            }  */
