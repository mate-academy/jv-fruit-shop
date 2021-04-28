package com.companyname.fruitshop;

import com.companyname.fruitshop.dao.FruitDaoImpl;
import com.companyname.fruitshop.model.Operation;
import com.companyname.fruitshop.service.impl.BalanceOperationHandler;
import com.companyname.fruitshop.service.impl.FileReaderService;
import com.companyname.fruitshop.service.impl.FruitServiceImpl;
import com.companyname.fruitshop.service.impl.OperationStrategyImpl;
import com.companyname.fruitshop.service.interfaces.FruitService;
import com.companyname.fruitshop.service.interfaces.OperationHandler;
import com.companyname.fruitshop.service.interfaces.OperationStrategy;
import com.companyname.fruitshop.service.interfaces.ParseService;
import com.companyname.fruitshop.service.impl.ParseServiceImpl;
import com.companyname.fruitshop.service.interfaces.ReaderService;
import com.companyname.fruitshop.service.interfaces.ValidatorService;
import com.companyname.fruitshop.service.impl.ValidatorServiceImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        /*
        1. Read File                                    1. Open File
        2. Parse data?                                  2. Read line
        3. Validate data?                  VS           3. Parse line?
        4. Execute strategies                           4. Validate line?
        5. Generate report                              5. Execute strategy
        6. Write report to a file                       6. ....???
         */

        // 1
        Path filePath = Path.of("src/main/resources/file.csv");
        ReaderService readerService = new FileReaderService(filePath);
        List<String> lines = readerService.readLines();

        // 2?
        ValidatorService validatorService = new ValidatorServiceImpl();
        validatorService.validateData(lines);

        // 3?
        ParseService parseService = new ParseServiceImpl();
        parseService.parseData(lines);

        // 4
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.b, new BalanceOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(new FruitDaoImpl(), operationStrategy);
    }
}
