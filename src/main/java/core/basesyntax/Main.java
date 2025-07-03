package core.basesyntax;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.csv";
        String outputFile = "output.csv";

        FileReaderLines fileReaderLines = new FileReaderLinesImpl();
        FruitDataCounter fruitDataCounter = new FruitDataCounterImpl();
        DataConvertor dataConvertor = new DataConvertorImpl();

        List<String> lines = fileReaderLines.lines(inputFile);
        List<FruitTransaction> fruitTransactions = dataConvertor.dataConvert(lines);
        List<String> fruits = fruitDataCounter.fruits(fruitTransactions);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.fileWriterCsv(fruits, outputFile);

        System.out.println("Файл успішно оброблений і збережений в " + outputFile);
    }
}

