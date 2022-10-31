package com.fruitshop.servicesimpl;

import com.fruitshop.fruitsmodels.Fruit;
import java.util.Map;

public class ResultMessage {

    public static final String COMMA = ",";
    public static final String TITLE_TO_FILE = "fruit,quantity";
    private final DataBaseManagerImpl dataBaseManagerImpl = new DataBaseManagerImpl();
    private StringBuilder sb = new StringBuilder(TITLE_TO_FILE + System.lineSeparator());

    public String makeMessage() {
        for (Map.Entry<String, Fruit> entry: dataBaseManagerImpl.getAllDB().entrySet()) {
            sb.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue().getQuantityLeft())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
