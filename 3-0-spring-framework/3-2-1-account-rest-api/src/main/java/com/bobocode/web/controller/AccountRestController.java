package com.bobocode.web.controller;

import com.bobocode.dao.AccountDao;
import com.bobocode.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller that handles requests with URL "/accounts".
 */
@RestController
@RequestMapping("/accounts")
public class AccountRestController {

    private final AccountDao accountDao;

    public AccountRestController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * Handles GET request to get a list of all accounts.
     *
     * @return list of accounts
     */
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }

    /**
     * Handles GET request with an id as a path variable to get account by id.
     *
     * @param id the account id
     * @return the account with the given id
     */
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable long id) {
        return accountDao.findById(id);
    }

    /**
     * Handles POST request to create a new account.
     *
     * @param account the account to be created
     * @return the created account
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status 201
    public Account createAccount(@RequestBody Account account) {
        return accountDao.save(account);
    }

    /**
     * Handles PUT request to update an account.
     *
     * @param id the account id
     * @param account the account to be updated
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status 204
    public void updateAccount(@PathVariable long id, @RequestBody Account account) {
        if (account.getId() != id) {
            throw new IllegalStateException("Account ID in path and body do not match");
        }
        accountDao.save(account); // Save the updated account
    }

    /**
     * Handles DELETE request to remove an account by id.
     *
     * @param id the account id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status 204
    public void deleteAccount(@PathVariable long id) {
        Account account = accountDao.findById(id);
        accountDao.remove(account);
    }
}
