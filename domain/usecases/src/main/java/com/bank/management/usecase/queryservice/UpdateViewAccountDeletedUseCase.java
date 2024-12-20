package com.bank.management.usecase.queryservice;

import com.bank.management.exception.BankAccountNotFoundException;
import com.bank.management.gateway.AccountRepository;
import reactor.core.publisher.Mono;


public class UpdateViewAccountDeletedUseCase {

    private final AccountRepository accountRepository;

    public UpdateViewAccountDeletedUseCase(AccountRepository bankAccountRepository) {
        this.accountRepository = bankAccountRepository;
    }

    public Mono<Boolean> apply(String id) {
        return accountRepository.findById(id)
                .switchIfEmpty(Mono.error(new BankAccountNotFoundException()))
                .flatMap(account -> accountRepository.delete(id).then(Mono.just(true)));
    }

}
