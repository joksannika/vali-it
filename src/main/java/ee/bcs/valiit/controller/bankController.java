package ee.bcs.valiit.controller;

import ee.bcs.valiit.DTO.bankfileDto;
import ee.bcs.valiit.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class bankController {
    //http://localhost:8080/bankfile/.../...
    @Autowired
    private BankService bankService;

    @GetMapping("bankfile/createaccount/{account}/{client}")
    public void createAccount(@PathVariable("account") String accountNr, @PathVariable("client") String client) {
        bankService.createAccount(accountNr, client);
    }

    @GetMapping("bankfile/getbalance/{account}")
    public int getBalance(@PathVariable("account") String accountNr) {
        return bankService.getBalance(accountNr);
    }

    @GetMapping("bankfile/depositmoney/{account}/{deposit}")
    public void depositMoney(@PathVariable("account") String accountNr, @PathVariable("deposit") int deposit) {
        bankService.depositMoney(accountNr, deposit);
    }

    @GetMapping("bankfile/withdrawmoney/{account}/{withdrawl}")
    public void withdrawMoney(@PathVariable("account") String accountNr, @PathVariable("withdrawl") int withdrawl) {
        bankService.withdrawMoney(accountNr, withdrawl);
    }

    @GetMapping("bankfile/transfer/{fromAccount}/{toAccount}/{transfer}")
    public void transfer(@PathVariable("fromAccount") String accountNr, @PathVariable("toAccount") String accountNr2, @PathVariable("transfer") int transfer) {
        bankService.transfer(accountNr, accountNr2, transfer);
    }

    @GetMapping("bankfile/lockaccount/{account}")
    public void lockAccount(@PathVariable("account") String accountNr) {
        bankService.lockAccount(accountNr);
    }

    @GetMapping("bankfile/unlockaccount/{account}")
    public void unlockAccount(@PathVariable("account") String accountNr) {
        bankService.unlockAccount(accountNr);
    }

    @GetMapping("bankfile/list")
    public List<bankfileDto> list(){
        return bankService.theWholeList();
    }


}