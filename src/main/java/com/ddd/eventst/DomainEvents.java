package com.ddd.eventst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author wuk
 * @description:
 * @menu
 * @date 2024/8/25 23:55
 */
public class DomainEvents {
    // 保存事件处理程序的映射
    private static Map<Class<?>, List<Consumer<?>>> handlers = new HashMap<>();

    // 注册事件处理程序
    public static <T extends IDomainEvent> void register(Class<T> eventType, Consumer<T> eventHandler) {
        handlers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(eventHandler);
    }

    // 触发事件
    public static <T extends IDomainEvent> void raise(T domainEvent) {
        List<Consumer<?>> eventHandlers = handlers.get(domainEvent.getClass());
        if (eventHandlers != null) {
            for (Consumer<?> handler : eventHandlers) {
                @SuppressWarnings("unchecked")
                Consumer<T> action = (Consumer<T>) handler;
                action.accept(domainEvent);
            }
        }
    }
}
