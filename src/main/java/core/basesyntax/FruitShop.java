package core.basesyntax;

import csv.processing.CsvProcessorRead;
import csv.processing.CsvProcessorWrite;
import java.util.HashMap;

public class FruitShop {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("you should to use : FruitShop.jar [input.csv] [output.csv]");
            return;
        }
        String inputCsvFilePath = args[0];
        String outCsvFilePath = args[1];
        String delimiter = ",";
        String[] outHeaders = {Fields.fruit.name(),Fields.quantity.name()};
        ShopStoreService<String> shop = new ShopStoreService();
        CsvProcessorRead csvProcessorRead = new CsvProcessorRead();
        csvProcessorRead.openCsv(inputCsvFilePath,delimiter);

        do {
            shop.storeProcessCsvData(csvProcessorRead.getField(Fields.fruit.name()),
                    Integer.parseInt(csvProcessorRead.getField(Fields.quantity.name())),
                    csvProcessorRead.getField(Fields.type.name()));
        } while (csvProcessorRead.readNext());
        HashMap<String,Integer> balanceReport = shop.getBalaceReport();
        CsvProcessorWrite csvProcessorWrite = new CsvProcessorWrite();
        csvProcessorWrite.createCsv(outCsvFilePath,outHeaders,delimiter);

        for (String key : balanceReport.keySet()) {
            csvProcessorWrite.setField(Fields.fruit.name(),key);
            csvProcessorWrite.setField(Fields.quantity.name(),(balanceReport.get(key)).toString());
            csvProcessorWrite.write();
        }
    }

    enum Fields {
        fruit,
        quantity,
        type
    }
}
