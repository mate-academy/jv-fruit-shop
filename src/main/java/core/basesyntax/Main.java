package core.basesyntax;

import Service.Activities.Activities;
import Service.Activities.Balance;
import Service.Activities.Purchase;
import Service.Activities.Return;
import Service.Activities.Supply;
import Service.Activities.TypeOfActivities;
import Service.ActivitiesStrategy;
import Service.ActivitiesStrategyImpl;
import Service.RecordToMap;
import Service.RecordToMapImpl;
import Service.WriteFile;
import Service.WriteFileImpl;
import Service.fruitRecord.FruitRecord;
import Service.FruitRecordToList;
import Service.FruitRecordToListImpl;
import Service.ReadFile;
import Service.ReadFileImpl;
import db.Storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //tests

        ReadFile file = new ReadFileImpl();
        FruitRecordToList recordToList = new FruitRecordToListImpl();

        String stringFile = file.readFile("inputData.csv");
        List<FruitRecord> fruitRecordList = recordToList.fruitRecordToList(stringFile);
        Storage.fruitStorageList.addAll(fruitRecordList);


        System.out.println(file.readFile("inputData.csv"));
        System.out.println("-------------");
        System.out.println(fruitRecordList);
        System.out.println(Storage.fruitStorageList);
        String a = TypeOfActivities.BALANCE.name();

        System.out.println("------------------");


        Map<TypeOfActivities, Activities> typeOfActivitiesActivitiesMap = new HashMap<>();
        typeOfActivitiesActivitiesMap.put(TypeOfActivities.BALANCE, new Balance());
        typeOfActivitiesActivitiesMap.put(TypeOfActivities.SUPPLY, new Supply());
        typeOfActivitiesActivitiesMap.put(TypeOfActivities.PURCHASE, new Purchase());
        typeOfActivitiesActivitiesMap.put(TypeOfActivities.RETURN, new Return());
        ActivitiesStrategy strategy = new ActivitiesStrategyImpl(typeOfActivitiesActivitiesMap);
        RecordToMap record = new RecordToMapImpl();
        record.recordToMap(Storage.fruitStorageList, strategy);
        WriteFile writeFile = new WriteFileImpl();
        writeFile.writeWithMapToFile(Storage.storage, "test1.csv");

        System.out.println(Storage.storage);


    }
}
