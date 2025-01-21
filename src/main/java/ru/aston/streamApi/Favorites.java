package ru.aston.streamApi;

import java.util.HashMap;
import java.util.Map;

// Шаблон типобезопасного неоднородного контейнера - API
public class Favorites {
    private Map<Class<?>, Object> favorites =
            new HashMap<Class<?>, Object>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null)
            throw new NullPointerException("Type is null");
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
    /*Каждый экземпляр Favorites поддерживается закрытым объектом
    Map<Class<?>, Object>, который называется favorites.
    у каждого ключа могут быть разные параметризованные типы:
    один может быть Class<String>, другой Class<Integer> и
    т.д. Вот откуда берётся неоднородность.
     */

