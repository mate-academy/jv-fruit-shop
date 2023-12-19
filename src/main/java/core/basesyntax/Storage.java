package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static Map<String, Integer> fruits = new HashMap<>();



}
//Storage - просто зроби там статичну публічну мапу, та не треба створювати об`єкт, просто працюй зі значеннями напряму, де треба, наприклад Storage.fruits.get(), Storage.fruits.put() й так далі
