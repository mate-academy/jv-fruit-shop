package core.basesyntax.FruitShopService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.basesyntax.model.FruitTransaction;

public class ServiceConvertImpl implements ServiceConvert {


    List<FruitTransaction> dataFromInput = new ArrayList<>();

    @Override
    public void convertDataFromFile(List<String> inputData) {

        for(String el : inputData) {
            String operationName = el.split(",")[0];
            String fruitName = el.split(",")[1];
            String fruitQTY = el.split(",")[2];
            dataFromInput.add(new FruitTransaction(operationName,fruitName,Integer.parseInt(fruitQTY)));
        }
    }




}
