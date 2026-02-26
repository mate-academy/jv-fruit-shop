package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class ShopStorage implements Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    //TODO: Заборонити null/empty ключі та null/від'ємні значення при create/update;
    // кидати IllegalArgumentException.
    //TODO: Розглянути повернення boolean у update/delete замість кидання IllegalArgumentException
    // при відсутності ключа (визначити контракт і задокументувати).
    //TODO: read повинен або повертати Integer (може бути null) та документувати поведінку,
    // або повертати 0 за замовчуванням — вибрати й дотримуватися.
    public boolean create(String fruit, Integer quantity) {
        if (storage.containsKey(fruit)) {
            return false;
        }
        storage.put(fruit, quantity);
        return true;
    }

    public Integer read(String key) {
        return storage.get(key);
    }

    // add or substrate in transaction layer
    public boolean update(String fruit, Integer quantity) {
        if (!storage.containsKey(fruit)) {
            throw new IllegalArgumentException(fruit + " not exist in storage!");
        }
        storage.put(fruit, quantity);
        return true;
    }

    public boolean delete(String fruit) {
        if (!storage.containsKey(fruit)) {
            throw new IllegalArgumentException(fruit + " not exist in storage!");
        }
        storage.remove(fruit);
        return true;
    }
}
