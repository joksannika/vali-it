package ee.bcs.valiit.service;

import ee.bcs.valiit.DTO.bankfileDto;
import ee.bcs.valiit.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepository accountRepository;

    public void createAccount(String accountNr, String client){
        accountRepository.createAccount(accountNr, client);
    }

    public int getBalance(String accountNr){
        return accountRepository.acquireAccountBalance(accountNr);
    }

    public void depositMoney(String accountNr, int deposit){
      /*  String sql = "SELECT locked FROM bankfile WHERE account = :a1;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        Boolean locked = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class); */
        Boolean locked = accountRepository.isAccountLocked(accountNr);
        if (locked == false) {
      /*      String sql2 = "SELECT balance FROM bankfile WHERE account = :a1";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("a1", accountNr);
            Integer oldBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class); */
            Integer oldBalance = accountRepository.acquireAccountBalance(accountNr);
            Integer newBalance = oldBalance + deposit;
      /*      String sql3 = "UPDATE bankfile SET balance = :newBalance WHERE account = :a1";
            Map<String, Object> paramMap3 = new HashMap<>();
            paramMap3.put("a1", accountNr);
            paramMap3.put("newBalance", newBalance);
            jdbcTemplate.update(sql3, paramMap3);  */
            accountRepository.updateAccountBalance(accountNr, newBalance);
        }
    }

    public void withdrawMoney(String accountNr, int withdrawl){
        Boolean locked = accountRepository.isAccountLocked(accountNr);
        if (locked == false) {
            Integer oldBalance = accountRepository.acquireAccountBalance(accountNr);
            if (oldBalance > withdrawl) {
                Integer newBalance = oldBalance - withdrawl;
                accountRepository.updateAccountBalance(accountNr, newBalance);
            } else {
                System.out.println("Insufficient funds");
            }
        }
    }

    public void transfer(String accountNr, String accountNr2, int transfer){
        Boolean locked = accountRepository.isAccountLocked(accountNr);
        Boolean locked9 = accountRepository.isAccountLocked(accountNr2);
        if (locked == false && locked9 == false) {
            Integer oldBalance = accountRepository.acquireAccountBalance(accountNr);
            if (oldBalance > transfer) {
                Integer newBalance = oldBalance - transfer;
                accountRepository.updateAccountBalance(accountNr, newBalance);
                Integer oldBalance2 = accountRepository.acquireAccountBalance(accountNr2);
                Integer newBalance2 = oldBalance2 + transfer;
                accountRepository.updateAccountBalance(accountNr2, newBalance2);
            } else {
                System.out.println("Insufficient funds");
            }
        }
    }

    public void lockAccount(String accountNr){
        accountRepository.lockAccount(accountNr);
    }

    public void unlockAccount(String accountNr){
        accountRepository.unlockAccount(accountNr);
    }


    public List<bankfileDto> theWholeList() {
        return accountRepository.theWholeList();
    }
}
