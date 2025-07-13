package core.basesyntax.service.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitReaderImpl;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ServiceShopForTestsException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ServiceShopForTestsImplTest {
    public static final String FILE_FROM = "src/main/resources/FORTESTS.csv";
    private ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private ServiceShopForTests serviceShopForTests = new ServiceShopForTestsImpl();

    @Test
    void service_FruitWithNullParameters_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        fruitTransaction.setAmount(200);
        fruitTransaction.setFruit(null);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void service_OperationWithNullParameters_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(null);
        fruitTransaction.setAmount(200);
        fruitTransaction.setFruit("banana");
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void service_OperationParametersContainsOneLetter_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.mapToOperation("b"));
        fruitTransaction.setAmount(50);
        fruitTransaction.setFruit("banana");
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getAmount());
        try {
            serviceShopForTests.shopTest(fruitTransaction);
        } catch (ServiceShopForTestsException e) {
            fail("something had wrong parameters! ", e);
        }
    }

    @Test
    void service_FruitWithEmptyParameters_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        fruitTransaction.setAmount(200);
        fruitTransaction.setFruit("");
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void service_AmountLessThanOne_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        fruitTransaction.setAmount(0);
        fruitTransaction.setFruit("apple");
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void service_NewFruitToTheStorage_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        fruitTransaction.setAmount(50);
        fruitTransaction.setFruit("orange");
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getAmount());
        try {
            serviceShopForTests.shopTest(fruitTransaction);
        } catch (ServiceShopForTestsException e) {
            throw new RuntimeException("invalid fruit typing! ", e);
        }
    }

    @Test
    void service_FruitNameStartedWithNumbers_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        fruitTransaction.setAmount(2);
        fruitTransaction.setFruit("123");
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void service_FruitNameStartedWithSpeciallySymbols_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        fruitTransaction.setAmount(2);
        fruitTransaction.setFruit("%$#!*$*#%&@$");
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void service_ReturnMinusParameters_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        fruitTransaction.setAmount(-5);
        fruitTransaction.setFruit("apple");
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void service_FruitNameShouldHaveAtLeastFourLetters_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        fruitTransaction.setAmount(10);
        fruitTransaction.setFruit("abc");
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void purchase_FruitContainsNull_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new PurchaseOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit(null),
                fruitTransaction.setAmount(200));
        fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void purchase_BalanceIsNull_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new PurchaseOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("banana"),
                fruitTransaction.setAmount(0));
        fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void purchase_EmptyFruit_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new PurchaseOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit(""),
                fruitTransaction.setAmount(40));
        fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void purchase_PurchaseGood_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new PurchaseOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("apple"),
                fruitTransaction.setAmount(20));
        fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getAmount());
        try {
            serviceShopForTests.shopTest(fruitTransaction);
        } catch (ServiceShopForTestsException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void purchase_NotEnoughQuality_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new PurchaseOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("apple"),
                fruitTransaction.setAmount(200));
        fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void purchase_FruitWithSpeciallySymbols_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new SupplyOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("$%%#^#^@#^"),
                fruitTransaction.setAmount(5));
        fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void balance_NullFruit_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new BalanceOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit(null),
                fruitTransaction.setAmount(200));
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void balance_ZeroBalance_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new BalanceOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("banana"),
                fruitTransaction.setAmount(0));
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void balance_EmptyFruit_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new BalanceOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit(""),
                fruitTransaction.setAmount(40));
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void balance_BalanceFilledToAllParameters_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new BalanceOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("apple"),
                fruitTransaction.setAmount(40));
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        try {
            serviceShopForTests.shopTest(fruitTransaction);
        } catch (ServiceShopForTestsException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void balance_FruitNameStartedWithSpeciallySymbols_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new SupplyOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("$%%#^#^@#^"),
                fruitTransaction.setAmount(5));
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void return_EmptyFruit_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new ReturnOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit(""),
                fruitTransaction.setAmount(40));
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void return_ZeroBalance_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new ReturnOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("apple"),
                fruitTransaction.setAmount(0));
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void return_NullFruit_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new ReturnOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit(null),
                fruitTransaction.setAmount(100));
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void return_MinusAmount_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new ReturnOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("banana"),
                fruitTransaction.setAmount(-100));
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void return_FruitNameStartedWithSpeciallySymbols_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new SupplyOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("$%%#^#^@#^"),
                fruitTransaction.setAmount(5));
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void supply_EmptyFruit_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new SupplyOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit(""),
                fruitTransaction.setAmount(40));
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void supply_ZeroBalance_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new SupplyOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("apple"),
                fruitTransaction.setAmount(0));
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void supply_NullFruit_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new SupplyOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit(null),
                fruitTransaction.setAmount(100));
        fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void supply_MinusAmount_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new SupplyOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("banana"),
                fruitTransaction.setAmount(-100));
        fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void supply_FruitWithSpeciallySymbols_NotOk() {
        FruitTransaction fruitTransaction = new FruitTransaction();
        OperationHandler operationHandler = new SupplyOperation();
        operationHandler.updateNumberOffFruit(
                fruitTransaction.setFruit("$$#@$banana"),
                fruitTransaction.setAmount(5));
        fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
        assertThrows(ServiceShopForTestsException.class, () ->
                serviceShopForTests.shopTest(fruitTransaction));
    }

    @Test
    void dataConverter_FruitWithSpeciallySymbols_NotOk() {
        Reader fruitReader = new FruitReaderImpl();
        List<String> inputReport = fruitReader.read(FILE_FROM);
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        for (int i = 0; i < transactions.size(); i++) {
            FruitTransaction fruitTransaction = transactions.get(i);
            assertThrows(ServiceShopForTestsException.class, () ->
                    serviceShopForTests.shopTest(fruitTransaction));
        }
    }

    @Test
    void dataConverter_ZeroBalance_NotOk() {
        Reader fruitReader = new FruitReaderImpl();
        List<String> inputReport = fruitReader.read(FILE_FROM);
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        for (int i = 1; i < transactions.size(); i++) {
            FruitTransaction fruitTransaction = transactions.get(i);
            assertThrows(ServiceShopForTestsException.class, () ->
                    serviceShopForTests.shopTest(fruitTransaction));
        }
    }

    @Test
    void dataConverter_BalanceBanana_Ok() {
        Reader fruitReader = new FruitReaderImpl();
        List<String> inputReport = fruitReader.read(FILE_FROM);
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        for (int i = 2; i < transactions.size(); i++) {
            FruitTransaction fruitTransaction = transactions.get(i);
            Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getAmount());
            try {
                serviceShopForTests.shopTest(fruitTransaction);
            } catch (ServiceShopForTestsException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    void dataConverter_ReturnBanana_Ok() {
        Reader fruitReader = new FruitReaderImpl();
        List<String> inputReport = fruitReader.read(FILE_FROM);
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        for (int i = 3; i < transactions.size(); i++) {
            FruitTransaction fruitTransaction = transactions.get(i);
            Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getAmount());
            try {
                serviceShopForTests.shopTest(fruitTransaction);
            } catch (ServiceShopForTestsException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    void dataConverter_PurchaseTooMuchBananas_NotOk() {
        Reader fruitReader = new FruitReaderImpl();
        List<String> inputReport = fruitReader.read(FILE_FROM);
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        for (int i = 4; i < transactions.size(); i++) {
            FruitTransaction fruitTransaction = transactions.get(i);
            assertThrows(ServiceShopForTestsException.class, () ->
                    serviceShopForTests.shopTest(fruitTransaction));
        }
    }

    @Test
    void getReport() {
        Storage.storage.put("banana", 100);
        String expected = "fruit, quanity\r\n"
                + "banana,100\r\n";
        String actual = reportGenerator.getReport();
        assertEquals(expected, actual);
    }

    @AfterEach
    public void afterEachTest() {
        Storage.storage.clear();
    }
}
