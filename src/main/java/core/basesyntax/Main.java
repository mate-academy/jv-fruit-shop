package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.operation.Supply;
import core.basesyntax.parce.ParseOperation;
//import core.basesyntax.parce.SupplyParse;
//import core.basesyntax.read.FileService;
import core.basesyntax.read.FileServiceImp;
import core.basesyntax.read.FileServiceInt;
import core.basesyntax.write.RecordingService;
//import core.basesyntax.write.RecordingService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ParseOperation<Supply> supplySupplyParse = new SupplyParse();

        FileServiceInt fileServiceInt = new FileServiceImp();
        List<String> data = fileServiceInt.readFile("/Users/artem2/Mate Academy/jv-fruit-shop/src/test/resources/base2.csv");
        for (String row : data) {
            String[] line = row.split(",");
            if (line[0].equals("s")) {
                String type = line[1];
                int q = Integer.parseInt(line[2]);
//                Supply supply = supplySupplyParse.parse(data);
                Supply supply = new Supply(type,q);
                        Storage.orders.add(supply);
            }


//            if (data.get(0).equals("s")) {
//                Supply supply = supplySupplyParse.parse(data);
//                Storage.orders.add(supply);
//            }
        }

//        FileService fileService = new FileService();
//        fileService.readFromFile("/Users/artem2/Mate Academy/jv-fruit-shop/src/test/resources/base.csv");
//        RecordingService recordingService = new RecordingService();
//        recordingService.writingToFile();
    }
}
