package core.basesyntax;

import model.FruitTransaction;
//import servise.calculate.CalculateFruits;
//import servise.calculate.CalculateFruitsImp;
import servise.convertobject.ConvertToObject;
import servise.convertobject.ConvertToObjectImp;
import servise.readfromfile.ReadFromFile;
import servise.readfromfile.ReadFromFileImpl;
import servise.report.Report;
import servise.report.ReportImp;
import servise.writefromfile.WriteToFile;
import servise.writefromfile.WriteToFileImp;
import strategy.*;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Path path = Path.of("src\\main\\resources\\inputData.csv");
        Path pathReport = Path.of("src\\main\\resources\\report.csv");

        ReadFromFile readFromFile = new ReadFromFileImpl();
        List<String> inputFromFile = readFromFile.readFromFile(path);

//        Map<String, OperationHandler> handlerMap = new HashMap<>();
//        handlerMap.put("b", new BalanceOperationHandler());

        ConvertToObject convertToObject = new ConvertToObjectImp();
        List<FruitTransaction> fruitTransactions = convertToObject.convertToObject(inputFromFile);

        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("r", new ReturnOperationHandler());
        map.put("p", new PurchaseOperationHandler());

        for (FruitTransaction fruits: fruitTransactions) {
            OperationHandler handler = map.get(fruits.getOperation());
            handler.process(fruits);
        }

        Report report = new ReportImp();
        String reportString = report.report();

        WriteToFile writeToFile = new WriteToFileImp();
        writeToFile.writeToFile(pathReport, reportString);
    }
}
