package core.basesyntax.services.work_with_files.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.operation_handlers.PurchaseOperationHandler;
import core.basesyntax.services.operation_handlers.ReturnOperationHandler;
import core.basesyntax.services.operation_handlers.SupplyOperationHandler;
import core.basesyntax.services.work_with_files.DbDataPutter;
import java.util.List;
import java.util.stream.Collectors;

public class DbDataPutterImpl implements DbDataPutter {
  public static List<String[]> balance;
  public static List<String[]> otherOperations;
  @Override
  public void divideData(List<String> rawData) {
    balance = rawData.stream()
            .filter(string -> string.charAt(0) == 'b')
            .map(string -> string.split(","))
            .collect(Collectors.toList());
    otherOperations = rawData.stream()
            .filter(string -> string.charAt(0) != 'b' && !string.equals("type"))
            .map(string -> string.split(","))
            .collect(Collectors.toList());
  }
  public static void putDataToDb(List<String[]> toDb) {
    for (String[] string : toDb) {
      Storage.fruitsTypeAndAmount.put(string[1], Integer.valueOf(string[2]));
    }
  }
  public static void handleOperations(List<String[]> changeDb) {
    for(String[] strings : changeDb) {
      PurchaseOperationHandler purchaseOperationHandler = new PurchaseOperationHandler();
      ReturnOperationHandler returnOperationHandler = new ReturnOperationHandler();
      SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler();
      switch (strings[0]) {
        case "p" -> purchaseOperationHandler.purchase(strings[1], Integer.parseInt(strings[2]));
        case "r" -> returnOperationHandler.returnFruit(strings[1], Integer.parseInt(strings[2]));
        case "s" -> supplyOperationHandler.supply(strings[1], Integer.parseInt(strings[2]));
      }
    }
  }
}
