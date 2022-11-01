package com.fruitshop.servicesimpl;

import com.fruitshop.dao.FruitDaoImpl;
import com.fruitshop.model.Fruit;
import com.fruitshop.services.ResultMessage;
import java.util.Map;

public class ResultMessageImpl implements ResultMessage {
    public static final String COMMA = ",";
    public static final String TITLE_TO_FILE = "fruit,quantity";

    public String makeMessage(FruitDaoImpl fruitDaoImpl) {
        StringBuilder sb = new StringBuilder(TITLE_TO_FILE + System.lineSeparator());
        for (Map.Entry<String, Fruit> entry: fruitDaoImpl.getAll().entrySet()) {
            sb.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue().getQuantityLeft())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
