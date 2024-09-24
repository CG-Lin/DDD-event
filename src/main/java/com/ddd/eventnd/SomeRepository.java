package com.ddd.eventnd;

import com.ddd.eventst.IDomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SomeRepository {
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

        return commitDatabaseChanges(); // 实际保存更改的方法
    }

    // 模拟数据库提交操作
    private int commitDatabaseChanges() {
        // 这里实现实际的数据库保存逻辑
        return 1; // 返回影响的记录数
    }
}
