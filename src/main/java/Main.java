import dao.FruitDao;
import dao.FruitDaoImpl;
import database.Storage;
import model.Fruit;
import service.*;
import service.impl.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFileImpl();
        ConvertData convertData = new ConvertDataImpl();
        FruitService fruitService = new FruitServiceImpl();
        FruitDao fruitDao = new FruitDaoImpl(fruitService);
        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitDao);
        WriteToFile writeToFile = new WriteToFileImpl();

        List<String> inputInfo = readFromFile.fileInfo();
        List<Fruit> fruitList = convertData.fruitList(inputInfo);
        for (Fruit fruit : fruitList) {
            operationStrategy.update(fruit);
        }
        writeToFile.writeReport(Storage.fruits);
    }
}

