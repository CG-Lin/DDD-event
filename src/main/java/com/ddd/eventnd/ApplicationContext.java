package com.ddd.eventnd;

import com.ddd.eventst.IDomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationContext {
    private List<IEntity> entities = new ArrayList<>(); // 模拟ChangeTracker

    public void add(IEntity entity) {
        entities.add(entity);
    }

    public int saveChanges() {
        List<IEntity> eventsList = entities.stream()
                .filter(entity -> !entity.getEvents().isEmpty())
                .collect(Collectors.toList());

        for (IEntity events : eventsList) {
            for (IDomainEvent event : events.getEvents()) {
                DomainEvents.raise(event);
            }
            events.clearEvents();
        }

        return commitDatabaseChanges(eventsList); // 实际保存更改的方法
    }

    // 模拟数据库提交操作
    private int commitDatabaseChanges(List<IEntity> eventsList) {
        // 这里实现实际的数据库保存逻辑
        return 1; // 返回影响的记录数
    }
}
