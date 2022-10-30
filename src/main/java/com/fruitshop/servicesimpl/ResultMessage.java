package com.fruitshop.servicesimpl;

import com.fruitshop.fruitsmodels.Fruit;
import com.fruitshop.services.Constants;
import java.util.Map;

public class ResultMessage {

    private final DataBaseManagerImpl dataBaseManagerImpl = new DataBaseManagerImpl();
    private StringBuilder sb = new StringBuilder(Constants.TITLE_TO_FILE + System.lineSeparator());

    public String makeMessage() {
        for (Map.Entry<String, Fruit> entry: dataBaseManagerImpl.getAllDB().entrySet()) {
            sb.append(entry.getKey())
                    .append(Constants.COMMA)
                    .append(entry.getValue().getQuantityLeft())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
