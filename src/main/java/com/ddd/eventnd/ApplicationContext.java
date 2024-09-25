package com.ddd.eventnd;

import com.ddd.eventst.IDomainEvent;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationContext  {
    private List<IEntity> entities; // 模拟ChangeTracker

    public ApplicationContext(List<IEntity> entities) {
        this.entities = entities;
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

        return commitDatabaseChanges(domainEventEntities); // 实际保存更改的方法
    }

    // 模拟数据库提交操作
    private int commitDatabaseChanges(List<IEntity> domainEventEntities) {
        // 这里实现实际的数据库保存逻辑
        return 1; // 返回影响的记录数
    }
}
