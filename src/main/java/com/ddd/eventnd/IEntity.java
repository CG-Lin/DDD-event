package com.ddd.eventnd;

import com.ddd.eventst.IDomainEvent;

import java.util.List;

public interface IEntity {
    List<IDomainEvent> getEvents();

    void clearEvents();
}

