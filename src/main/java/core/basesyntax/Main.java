package core.basesyntax;

import core.basesyntax.activities.Balance;
import core.basesyntax.activities.Purchase;
import core.basesyntax.activities.Return;
import core.basesyntax.activities.Supply;
import core.basesyntax.file.FromListToTransaction;
import core.basesyntax.file.FromListToTransactionImpl;
import core.basesyntax.file.ReadFile;
import core.basesyntax.file.ReadFileImpl;
import core.basesyntax.maps.StorageForChoosingTypeOperation;
import core.basesyntax.maps.StorageForFruitsAndQuantity;
import core.basesyntax.report.ReadyReportToFile;
import core.basesyntax.report.ReadyReportToFileImpl;
import core.basesyntax.report.Report;
import core.basesyntax.report.ReportImpl;
import core.basesyntax.transactions.FruitTransaction;
import core.basesyntax.transactions.ProcessingAllTransactions;
import core.basesyntax.transactions.ProcessingAllTransactionsImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        ReadFile fileReader = new ReadFileImpl();
        List<String> inputReport = fileReader.readFile(INPUT_FILE);

        FromListToTransaction dataConverter = new FromListToTransactionImpl();
        final List<FruitTransaction> transactions = dataConverter.finalProcess(inputReport);

        StorageForFruitsAndQuantity fruitStorage = new StorageForFruitsAndQuantity();
        StorageForChoosingTypeOperation operationStorage =
                new StorageForChoosingTypeOperation();

        operationStorage.addHandler(
                FruitTransaction.Operation.BALANCE, new Balance(fruitStorage));
        operationStorage.addHandler(
                FruitTransaction.Operation.SUPPLY, new Supply(fruitStorage));
        operationStorage.addHandler(
                FruitTransaction.Operation.PURCHASE, new Purchase(fruitStorage));
        operationStorage.addHandler(
                FruitTransaction.Operation.RETURN, new Return(fruitStorage));

        ProcessingAllTransactions transactionProcessor =
                new ProcessingAllTransactionsImpl(operationStorage);
        transactionProcessor.processAllTransactions(transactions);

        Report reportGenerator = new ReportImpl(fruitStorage);
        String resultingReport = reportGenerator.report();

        ReadyReportToFile fileWriter = new ReadyReportToFileImpl();
        fileWriter.readyReportToFile(resultingReport, OUTPUT_FILE);
    }
}


/*   FruitTransaction — для зберігання даних одного рядка файлу
     SUPPLY, banana, 100 = яка_операція, який_фрукт, яка_кількість.

     OperationHandler — інтерфейс (спільний контракт) для Balance, Supply, Purchase і Return
     = гарантує, що кожен приймає FruitTransaction і вміє її обробити

     StorageForFruitsAndQuantity — місце в памʼяті, де зберігається
     поточна кількість фруктів після обчислень
     Map<String, Integer> = (ключ)назву фрукта і
     (значення)його поточну кількість
     Обробники беруть інформацію з FruitTransaction і змінюють
     відповідне значення у StorageForFruitsAndQuantity

     Класи Balance, Purchase, Supply і Return = математика

      StorageForChoosingTypeOperation = (ключ)тип операції й (значення)OperationHandler
      BALANCE = Balance і тд
      Метод getHandler() отримує тип операції та повертає потрібний обробник

      ReadFileImpl = читає CSV-файл і повертає List<String>

      FromListToTransactionImpl = перетворення List<String> на List<FruitTransaction>

      ProcessingAllTransactionsImpl = для обробки всього списку транзакцій
      проходить по List<FruitTransaction>, для кожної транзакції
      знаходить відповідний OperationHandler
      і запускає його
      Всі обробники змінюють одне спільне сховище фруктів

     ReportImpl = фінальний звіт
      беру кінцеві дані зі StorageForFruitsAndQuantity і перетворюю на CSV-текст


       ReadyReportToFileImpl = для сформованого CSV-текст у фінальний файл (Галя балувана)
 */
