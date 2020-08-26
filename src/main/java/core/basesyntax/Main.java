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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> listOfFruit = new ArrayList<>();
        FileServiceInt fileServiceInt = new FileServiceImp();
        List<String> data = fileServiceInt.readFile("/Users/artem2/Mate Academy/jv-fruit-shop/src/test/resources/base.csv");
        for (String row : data) {
            String[] line = row.split(",");
            listOfFruit.add(line[1]);
            String t = line[0];
            String type = line[1];
            int q = Integer.parseInt(line[2]);
            Supply supply = new Supply(t, type, q);
            Storage.orders.add(supply);
            RecordingService recordingService = new RecordingService();
            recordingService.writingToFile();
        }
        List<String> result = listOfFruit.stream().distinct().collect(Collectors.toList());
        for (String fruit : result) {
            fruit
        }
    }
}
