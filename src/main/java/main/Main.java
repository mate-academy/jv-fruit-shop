package main;

import db.FruitsStorage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransactionModel;
import model.OperationType;
import model.OutFileStructure;
import service.FileParser;
import service.FruitDalyTransactionsHandler;
import service.WriteToFile;
import service.impl.FileParserImpl;
import service.impl.FruitDalyTransactionsHandlerImpl;
import service.impl.ReadFromCsvFileImpl;
import service.impl.WriteToCsvFileImpl;
import strategy.DalyOperationStrategy;
import strategy.DalyOperationStrategyImpl;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/activities.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/dailyreport.csv";
    private static final String FIRST_REPORT_COLUMN = "fruit";
    private static final String SECOND_REPORT_COLUMN = "quantity";

    public static void main(String[] arg) {
        //read the data from the file
        ReadFromCsvFileImpl readFromCsvFile = new ReadFromCsvFileImpl();
        String dataFromFile = readFromCsvFile.readFromCsvFile(INPUT_FILE_NAME);

        //parse the data to the String
        FileParser fileParser = new FileParserImpl();
        List<FruitTransactionModel> fruitsTransactionList =
                fileParser.getFruitTransaction(dataFromFile);

        //create Map with different operation types
        Map<OperationType, Integer> operationTypeMap = new HashMap<>();
        operationTypeMap.put(OperationType.B, 0); //balance
        operationTypeMap.put(OperationType.S, 1); //supply
        operationTypeMap.put(OperationType.R, 1); //return
        operationTypeMap.put(OperationType.P, -1); //purchase

        //create an instance of Strategy Class and send him the Map
        DalyOperationStrategy dalyOperationStrategy =
                new DalyOperationStrategyImpl(operationTypeMap);

        //create an instance of Transactions Handler and send him the parsing data and the strategy
        FruitDalyTransactionsHandler fruitDalyTransactionsHandler =
                new FruitDalyTransactionsHandlerImpl();
        FruitsStorage fruitCurrentStorage =
                fruitDalyTransactionsHandler.getFruitBalance(fruitsTransactionList,
                        dalyOperationStrategy);

        //create the separate structure for the output file
        OutFileStructure outFileStructure =
                new OutFileStructure(FIRST_REPORT_COLUMN, SECOND_REPORT_COLUMN);

        //write the report to a new file
        WriteToFile writer = new WriteToCsvFileImpl();
        writer.writeToCsvFile(OUTPUT_FILE_NAME, outFileStructure, fruitCurrentStorage);

        //println for your convenience and quick check
        System.out.println(fruitCurrentStorage.getFruitsStorage().toString());
        // the right answer is: banana=70, apple=42, orange=16, kiwi=8
    }
}
