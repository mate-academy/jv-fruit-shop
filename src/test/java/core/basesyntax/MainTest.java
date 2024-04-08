package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.*;
import core.basesyntax.service.*;
import core.basesyntax.serviceImp.*;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
    private static ConvertData convertData;
    private static CSVReader csvReader;
    private static CSVWriter csvWriter;
    private static ProcessData processData;
    private static ReportGenerate reportGenerate;
    private static OperationStrategy operationStrategy;
    private static BalanceOperationHandler balanceOperationHandler;
    private static PurchaseOperationHandler purchaseOperationHandler;
    private static SupplyOperationHandler supplyOperationHandler;
    private static ReturnOperationHandler returnOperationHandler;
    private static FruitTransaction bananaBalance;
    private static Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;
    private static List<String> checkTransactionsStrings;
    private static List<FruitTransaction> checkTransactionsList;
    private static final String BANANA = "banana";
    private static final int NEGATIVE_QUANTITY = -10;

    @BeforeAll
    static void beforeAll() {
        balanceOperationHandler = new BalanceOperationHandler();
        supplyOperationHandler = new SupplyOperationHandler();
        purchaseOperationHandler = new PurchaseOperationHandler();
        returnOperationHandler = new ReturnOperationHandler();
        operationHandlerMap = Map.of(FruitTransaction.Operation.BALANCE, balanceOperationHandler,
                FruitTransaction.Operation.PURCHASE, purchaseOperationHandler,
                FruitTransaction.Operation.RETURN, returnOperationHandler,
                FruitTransaction.Operation.SUPPLY, supplyOperationHandler);
        convertData = new ConvertDataImp();
        csvReader = new CSVReaderImp();
        csvWriter = new CSVWriterImp();
        reportGenerate = new ReportGenerateImp();
        operationStrategy = new OperationStrategyImp(operationHandlerMap);
        processData = new ProcessDataImp(operationStrategy);
        bananaBalance = new FruitTransaction(FruitTransaction.Operation.BALANCE, BANANA, 100);
        checkTransactionsStrings = List.of(
                "type;fruit;quantity",
                "b;banana;20",
                "s;banana;102",
                "p;banana;40",
                "r;banana;30");
        checkTransactionsList = List.of(
                new FruitTransaction(FruitTransaction.Operation.BALANCE, BANANA, 20),
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, BANANA, 102),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, BANANA, 40),
                new FruitTransaction(FruitTransaction.Operation.RETURN, BANANA, 30)
        );
    }

    @Test
    void fileNameNull_notOk() {
        assertThrows(NullPointerException.class, () -> csvReader.read(null));
    }

    @Test
    void fileNotExist_notOk() {
        assertThrows(RuntimeException.class, () -> csvReader.read("Fsaf2.csv"));
    }

    @Test
    void illegalFileFormat_notOk() {
        assertThrows(IllegalArgumentException.class, () -> csvReader.read("abcd.txt"));
    }

    @Test
    void FileIsEmpty_notOk() {
        assertThrows(RuntimeException.class, () -> convertData.convertToTransaction(new ArrayList<>()));
    }

    @Test
    void illegalTextFormat_notOk() {
        List<String> transactionList = List.of("type", "fruit", "quantity");
        assertThrows(IllegalArgumentException.class, () -> convertData.convertToTransaction(transactionList));
    }

    @Test
    void negativeAfterPurchase_notOk() {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        fruitTransactions.add(bananaBalance);
        fruitTransactions.add(new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, BANANA, 110
        ));
        assertThrows(RuntimeException.class, () -> processData.operation(fruitTransactions));
    }

    @Test
    void negativeQuantity_notOk() {
        assertThrows(RuntimeException.class, () -> purchaseOperationHandler.operation(new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, BANANA, NEGATIVE_QUANTITY
        )));
        assertThrows(RuntimeException.class, () -> balanceOperationHandler.operation(new FruitTransaction(
                FruitTransaction.Operation.BALANCE, BANANA, NEGATIVE_QUANTITY
        )));
        assertThrows(RuntimeException.class, () -> returnOperationHandler.operation(new FruitTransaction(
                FruitTransaction.Operation.RETURN, BANANA, NEGATIVE_QUANTITY
        )));
        assertThrows(RuntimeException.class, () -> supplyOperationHandler.operation(new FruitTransaction(
                FruitTransaction.Operation.SUPPLY, BANANA, NEGATIVE_QUANTITY
        )));
    }

    @Test
    void read_Ok() {
        List<String> fruitTransactions = csvReader.read("reportToRead.csv");
        assertEquals(fruitTransactions, checkTransactionsStrings);
    }

    @Test
    void convertData_Ok() {
        assertEquals(convertData.convertToTransaction(checkTransactionsStrings),
                checkTransactionsList);
    }

    @Test
    void processData_Ok() {
        processData.operation(checkTransactionsList);
        String report = reportGenerate.report();
        String checkReport = "fruit;quantity\n" +
                "banana;112";
        assertEquals(checkReport, report);
    }
}
