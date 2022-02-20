package bd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitRecordDto;

public class Storage {
    public static final List<FruitRecordDto> records = new ArrayList<>();
    public static final Map<String, Integer> fruitQuantity = new HashMap<>();
}
