package com.ddd.eventnd;

import com.ddd.eventst.IDomainEvent;
import javafx.event.EventDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SomeRepository {
    private DomainEvents domainEvents;
    private List<IEntity> entities; // 模拟ChangeTracker

    public SomeRepository() {
    }

    public int saveChanges() {
        List<IEntity> domainEventEntities = entities.stream()
                .filter(entity -> !entity.getEvents().isEmpty())
                .collect(Collectors.toList());

        for (IEntity entity : domainEventEntities) {
            List<IDomainEvent> events = new ArrayList<>(entity.getEvents());
            entity.clearEvents();
            for (IDomainEvent domainEvent : events) {
                DomainEvents.raise(domainEvent);
            }
        }

        return doSaveChanges(); // 实际保存更改的方法
    }
}
