/*package core.basesyntax.Services;

import java.util.List;

public class FruitShopService {

    public void createReportFile(String pathToFile) {
        List<String> list = readFromFile(pathToFile);
        List<FruitTransaction> fruitTransactions = parseData(list);
        List<String> report = createReport(fruitTransactions);
        writeReport(report);
    }

    private List<String> readFromFile(String pathToFile) {
        /**
          * Зчитує дані з файлу, повертає їх у List<String>

    }

    private List<FruitTransaction> parseData(List<String> data) {
        // { "b,apple,10"  } ->
        // new FruitTransaction(operation, fruitName, amount)
        //
        /** Перетворює стрінгову інформацію в ліст об'єктів FruitTransaction, групуючи їх
          * по назві фрукту та типу операції,яка виконується над цим фруктом

    }

    public enum Operation {
        RETURN
    }

    private List<String> createReport(List<FruitTransaction> fruitTransactions) {
        /**
         * На основі fruitTransactions створює звіт по фруктам

    }

    private void writeReport(List<String> report) {
        /**
         * Записує звіт в новий файл

    }

}*/
