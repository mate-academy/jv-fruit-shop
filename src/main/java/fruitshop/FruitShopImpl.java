package fruitshop;

import db.Storage;
import java.util.List;
import service.ActivitiesStrategy;
import service.FruitRecordToList;
import service.FruitRecordToListImpl;
import service.ReadFile;
import service.ReadFileImpl;
import service.RecordToMap;
import service.RecordToMapImpl;
import service.WriteFile;
import service.WriteFileImpl;
import service.fruitrecord.FruitRecord;

public class FruitShopImpl implements FruitShop {
    private ActivitiesStrategy strategy;

    public FruitShopImpl(ActivitiesStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void createNewReport(String fileName, String nameNewReport) {
        ReadFile file = new ReadFileImpl();
        String stringFile = file.readFile(fileName);
        FruitRecordToList recordToList = new FruitRecordToListImpl();
        List<FruitRecord> fruitRecordList = recordToList.fruitRecordToList(stringFile);
        Storage.fruitStorageList.addAll(fruitRecordList);
        RecordToMap record = new RecordToMapImpl();
        record.recordToMap(Storage.fruitStorageList, strategy);
        WriteFile writeFile = new WriteFileImpl();
        writeFile.writeWithMapToFile(Storage.storage, nameNewReport);
    }
}
