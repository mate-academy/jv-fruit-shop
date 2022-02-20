package core.basesyntax;

import java.util.List;
import java.util.stream.Collectors;
import core.basesyntax.DB.Storage;
import core.basesyntax.FruitShopService.Reader;
import core.basesyntax.FruitShopService.TransactionParser;
import core.basesyntax.FruitShopService.TransactionService;
import core.basesyntax.FruitShopService.TransactionServiceImpl;
import core.basesyntax.model.FruitTransaction;


public class FruitShopMain {

    public static void main(String[] args) {

        List<String> inputData = Reader.readInputData("src/main/resources/dataInput.csv"); // тут лист стрингов
        List<FruitTransaction> transactions = inputData.stream().map(TransactionParser::parseTransaction).collect(Collectors.toList());
        Storage storage = new Storage();
        TransactionService transactionService = new TransactionServiceImpl(storage);
        transactions.forEach(transactionService::processTransaction);

//        Writer.writeReport("path to file for report", storage.getbalance());
    }
}
