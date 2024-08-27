package com.ddd.eventnd;

import com.ddd.eventst.IDomainEvent;

public interface DomainEventHandler<T extends IDomainEvent> {
    void handle(T event);
}