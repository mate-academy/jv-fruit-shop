package com.companyname.fruitshop;

import com.companyname.fruitshop.model.Operation;
import com.companyname.fruitshop.service.impl.AddOperationHandler;
import com.companyname.fruitshop.service.impl.BalanceOperationHandler;
import com.companyname.fruitshop.service.impl.FileReaderServiceImpl;
import com.companyname.fruitshop.service.impl.FruitServiceImpl;
import com.companyname.fruitshop.service.impl.OperationStrategyImpl;
import com.companyname.fruitshop.service.impl.RemoveOperationHandler;
import com.companyname.fruitshop.service.interfaces.FruitService;
import com.companyname.fruitshop.service.interfaces.OperationHandler;
import com.companyname.fruitshop.service.interfaces.OperationStrategy;
import com.companyname.fruitshop.service.interfaces.FileReaderService;
import com.companyname.fruitshop.storage.FruitStorage;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Path filePath = Path.of("src/main/resources/file2.csv");
        FileReaderService fileReaderService = new FileReaderServiceImpl(filePath);
        List<String> lines = fileReaderService.readLines();

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.b, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.s, new AddOperationHandler());
        operationHandlerMap.put(Operation.r, new AddOperationHandler());
        operationHandlerMap.put(Operation.p, new RemoveOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.saveData(lines);
        System.out.println(FruitStorage.getFruits());
    }
}
