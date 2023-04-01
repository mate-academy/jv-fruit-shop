package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.enums.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.TransactionParseService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String TITLE = "fruit,quantity";
    private final TransactionParseService transactionParseService;
    private final FruitShopService fruitShopService;

    public CreateReportServiceImpl(TransactionParseService transactionParseService
            , FruitShopService fruitShopService) {
        this.transactionParseService = transactionParseService;
        this.fruitShopService = fruitShopService;
    }

    @Override
    public String createReport() {
        StringBuilder validStringData = new StringBuilder();

        validStringData.append(TITLE + System.lineSeparator());

        for (Map.Entry<String, Integer> entry : FruitStorage.fruitsStorage.entrySet()) {
            validStringData.append(entry.getKey() + ",");
            validStringData.append(entry.getValue() + System.lineSeparator());
        }

        return validStringData.toString();
    }
}
