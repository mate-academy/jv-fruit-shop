package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.List;
import java.util.Map;
import model.FruitOperation;
import model.FruitType;
import service.CalculateFruit;
import service.FruitOperationParse;
import service.FruitOperationTypeParser;
import service.FruitShopService;
import service.FruitTypeParser;
import service.ReadDataFromFile;
import service.WriteToFile;
import service.WriteToStorage;

public class FruitShopServiceImpl implements FruitShopService {
    private final ReadDataFromFile readDataFromFile = new ReadDataFromFileImpl();
    private final CalculateFruit calculateFruitImpl = new CalculateFruitImpl();

    private final FruitOperationTypeParser fruitOperationTypeParser
            = new FruitOperationTypeParserImpl();
    private final FruitTypeParser fruitTypeParser = new FruitTypeParserImpl();
    private final FruitOperationParse fruitOperationParse
            = new FruitOperationParseImpl(fruitOperationTypeParser, fruitTypeParser);

    private final FruitDao fruitDao = new FruitDaoImpl();
    private final WriteToStorage writeToStorage = new WriteToStorageImpl(fruitDao);
    private final WriteToFile writeToFile = new WriteToFileImpl(fruitDao);

    @Override
    public void getResult(String fromFileName, String toFileName) {
        List<String> listOfData = readDataFromFile.getData(fromFileName);
        List<FruitOperation> listFruitOperation
                = fruitOperationParse.parseFruitOperationList(listOfData);
        Map<FruitType, Integer> listCountedFruit
                = calculateFruitImpl.calcualteFruit(listFruitOperation);
        writeToStorage.writeToDataBase(listCountedFruit);
        writeToFile.writeToFileFromDataBase(toFileName);
    }
}
