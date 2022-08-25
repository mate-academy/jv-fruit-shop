package core.basesyntax.service.maps;

import core.basesyntax.model.TypeActivity;
import java.util.HashMap;
import java.util.Map;

public class DecodeShortActivity {
    public static final Map<String, TypeActivity> map = new HashMap<>();

    static {
        map.put("b", TypeActivity.BALANCE);
        map.put("s", TypeActivity.SUPPLY);
        map.put("p", TypeActivity.PURCHASE);
        map.put("r", TypeActivity.RETURN);
    }

    public static Map<String, TypeActivity> getMap() {
        return map;
    }
}
