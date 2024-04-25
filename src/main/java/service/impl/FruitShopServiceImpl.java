package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.List;
import java.util.Map;
import model.FruitOperation;
import model.FruitType;
import service.CalculateFruit;
import service.FruitOperationParser;
import service.FruitOperationTypeParser;
import service.FruitShopService;
import service.FruitTypeParser;
import service.ReadDataFromFileSystem;
import service.SaveToFileSystem;
import service.SaveToStorage;

public class FruitShopServiceImpl implements FruitShopService {
    private final ReadDataFromFileSystem readDataFromFileSystem = new ReadDataFromFileSystemImpl();
    private final CalculateFruit calculateFruitImpl = new CalculateFruitImpl();

    private final FruitOperationTypeParser fruitOperationTypeParser
            = new FruitOperationTypeParserImpl();
    private final FruitTypeParser fruitTypeParser = new FruitTypeParserImpl();
    private final FruitOperationParser fruitOperationParser
            = new FruitOperationParserImpl(fruitOperationTypeParser, fruitTypeParser);

    private final FruitDao fruitDao = new FruitDaoImpl();
    private final SaveToStorage saveToStorage = new SaveToStorageImpl(fruitDao);
    private final SaveToFileSystem saveToFileSystem = new SaveToFileSystemImpl(fruitDao);

    @Override
    public void processData(String readFromFileName, String writeToFileName) {
        List<String> listOfData = readDataFromFileSystem.getData(readFromFileName);
        List<FruitOperation> listFruitOperation
                = fruitOperationParser.parseFruitOperationList(listOfData);
        Map<FruitType, Integer> listCountedFruit
                = calculateFruitImpl.calculateFruit(listFruitOperation);
        saveToStorage.writeToDataBase(listCountedFruit);
        saveToFileSystem.writeToFileFromDataBase(writeToFileName);
    }
}
