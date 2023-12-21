package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static Map<String, Integer> fruits = new HashMap<>();



}
//Storage - просто зроби там статичну публічну мапу, та не треба створювати об`єкт, просто працюй зі значеннями напряму, де треба, наприклад Storage.fruits.get(), Storage.fruits.put() й так далі
//Storage class - that should have Map<String, Integer>. This class is a simplier DB. Key of the map is a fruit name, and value is amount of that fruit that is currently in our storage