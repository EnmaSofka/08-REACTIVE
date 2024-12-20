package com.bank.management.usecase.appservice;

import com.bank.management.command.DeleteBankAccountCommand;
import com.bank.management.exception.UserAlreadyExistsException;
import com.bank.management.gateway.EventBus;
import com.bank.management.gateway.EventRepository;
import com.bank.management.generic.Command;
import com.bank.management.generic.DomainEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;


public class DeleteBankAccountEventUseCase {

    private final EventRepository eventRepository;
    private final EventBus eventBus;
    private final ObjectMapper objectMapper;

    public DeleteBankAccountEventUseCase(EventRepository eventRepository, EventBus eventBus, ObjectMapper objectMapper) {
        this.eventRepository = eventRepository;
        this.eventBus = eventBus;
        this.objectMapper = objectMapper;
    }

    public Mono<DomainEvent>apply(DeleteBankAccountCommand command) {
        return Mono.empty();
    }

    public Mono<String> serializeCommand(Command command) {
        return Mono.fromCallable(() -> objectMapper.writeValueAsString(command))
                .onErrorMap(e -> new RuntimeException("Error serializing command", e));
    }
}
