package fruitshop;

import db.Storage;
import java.util.List;
import service.ActivitiesStrategy;
import service.FileReader;
import service.FileReaderImpl;
import service.FruitRecordToList;
import service.FruitRecordToListImpl;
import service.WriteFile;
import service.WriteFileImpl;
import service.WriteRecordsToDB;
import service.WriteRecordsToDbImpl;
import fruitrecord.FruitRecord;

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
        WriteRecordsToDB record = new WriteRecordsToDbImpl();
        record.recordToMap(Storage.records, strategy);
        WriteFile writeFile = new WriteFileImpl();
        writeFile.writeWithMapToFile(Storage.fruitsQuantity, reportPath);
        return "Report created!";
    }
}
