package com.ddd.eventnd;

import com.ddd.eventst.IDomainEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainEvents {
    private static Map<Class<? extends IDomainEvent>, List<DomainEventHandler<? extends IDomainEvent>>> handlers = new HashMap<>();

    public static <T extends IDomainEvent> void register(Class<T> eventType, DomainEventHandler<T> handler) {
        handlers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(handler);
    }

    public static <T extends IDomainEvent> void raise(T event) {
        List<DomainEventHandler<? extends IDomainEvent>> eventHandlers = handlers.get(event.getClass());
        if (eventHandlers != null) {
            for (DomainEventHandler handler : eventHandlers) {
                handler.handle(event);
            }
        }
    }
}
