package fruitshop;

import db.Storage;
import fruitrecord.FruitRecord;
import java.util.List;
import service.ActivitiesStrategy;
import service.FileReader;
import service.FileReaderImpl;
import service.FruitRecordToList;
import service.FruitRecordToListImpl;
import service.FruitService;
import service.FruitServiceImpl;
import service.WriteFile;
import service.WriteFileImpl;

public class FruitShopImpl implements FruitShop {
    private ActivitiesStrategy strategy;
    private String filePath;
    private String reportPath;

    public FruitShopImpl(ActivitiesStrategy strategy, String filePath, String reportPath) {
        this.strategy = strategy;
        this.filePath = filePath;
        this.reportPath = reportPath;
    }

    @Override
    public String createNewReport() {
        FileReader file = new FileReaderImpl();
        String stringFile = file.read(filePath);
        FruitRecordToList recordToList = new FruitRecordToListImpl();
        List<FruitRecord> fruitRecordList = recordToList.fruitRecordToList(stringFile);
        Storage.records.addAll(fruitRecordList);
        FruitService record = new FruitServiceImpl(strategy);
        record.recordToMap(Storage.records);
        WriteFile writeFile = new WriteFileImpl();
        writeFile.writeWithMapToFile(Storage.fruitsQuantity, reportPath);
        return "Report created!";
    }
}
