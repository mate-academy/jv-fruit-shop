package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TransactionDto;
import service.ParserOperation;
import service.ReaderService;
import service.WriteService;
import service.impl.ParserOperationImpl;
import service.impl.ReaderServiceImpl;
import service.impl.WriteServiceImpl;
import strategy.StrategyOperation;
import strategy.impl.BalanceOperation;
import strategy.impl.PurchaseOperation;
import strategy.impl.ReturnOperation;
import strategy.impl.SupplyOperation;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_PATH = "src\\main\\resources\\input.csv";
    private static final String OUTPUT_FILE_PATH = "src\\main\\resources\\output.csv";
    private static final Map<String, StrategyOperation> map = new HashMap<>();

    static {
        map.put(TransactionDto.Operation.BALANCE.getType(), new BalanceOperation());
        map.put(TransactionDto.Operation.RETURN.getType(), new ReturnOperation());
        map.put(TransactionDto.Operation.SUPPLY.getType(), new SupplyOperation());
        map.put(TransactionDto.Operation.PURCHASE.getType(), new PurchaseOperation());
    }

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> strings = readerService.readFromFile(INPUT_FILE_PATH);
        ParserOperation parserOperation = new ParserOperationImpl();
        for (int i = 1; i < strings.size(); i++) {
            String line = strings.get(i);
            TransactionDto transactionDto = parserOperation.parserOperation(line);
            map.get(transactionDto.getOperation()).apply(transactionDto);
        }
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(OUTPUT_FILE_PATH);
    }
}
