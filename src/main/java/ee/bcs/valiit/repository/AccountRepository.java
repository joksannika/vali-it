package ee.bcs.valiit.repository;

import ee.bcs.valiit.DTO.bankfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr, String client) {
        String sql = "INSERT INTO bankfile (account, balance, client) " +
                "VALUES (:accountNumber, 0, :clientName)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("clientName", client);
        jdbcTemplate.update(sql, paramMap);
    }

    public Boolean isAccountLocked(String accountNr) {
        String sql = "SELECT locked FROM bankfile WHERE account = :a1;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
    }

    public Integer acquireAccountBalance(String accountNr){
        String sql2 = "SELECT balance FROM bankfile WHERE account = :a1";
        Map<String, Object> paraMap2 = new HashMap<>();
        paraMap2.put("a1", accountNr);
        return jdbcTemplate.queryForObject(sql2, paraMap2, Integer.class);
    }

    public Integer updateAccountBalance(String accountNr, Integer newBalance){
        String sql3 = "UPDATE bankfile SET balance = :newBalance WHERE account = :a1";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("a1", accountNr);
        paramMap3.put("newBalance", newBalance);
        return jdbcTemplate.update(sql3, paramMap3);
    }

    public void lockAccount(String accountNr){
        String sql = "UPDATE bankfile SET locked = true WHERE account = :a1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        jdbcTemplate.update(sql, paramMap);
    }

    public void unlockAccount(String accountNr){
        String sql = "UPDATE bankfile SET locked = false WHERE account = :a1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", accountNr);
        jdbcTemplate.update(sql, paramMap);
    }

    public static class bankfileRowMapper implements RowMapper<bankfileDto> {
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

    public List theWholeList (){
        String sql = "SELECT * FROM bankfile";
        Map<String, Object> paramMap = new HashMap<>();
        List<bankfileDto> vastus = jdbcTemplate.query(sql, paramMap, new bankfileRowMapper());
        return (vastus);
    }
}
