package core.basesyntax.service.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class OperationBalanceHandler implements OperationHandler {

    @Override
    public void operationHandler(FruitTransaction fruitTransaction) {
        operationDao.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }

    /*@Override
    public HashMap<String, Integer> getReportForOperationHandler(List<String> dataFromFile) {
        HashMap<String, Integer> operationBallanceMap = new HashMap<>();
        for (String current : dataFromFile) {
            String[] splitLine = current.split(SEPARATE_CURRENT_LINE);
            String key = splitLine[INDEX_FOR_PRODUCT_NAME_IN_STRING];
            int value = Integer.parseInt(splitLine[INDEX_FOR_PRODUCT_VALUE_IN_STRING]);
            if (splitLine[0].equals("b")) {
                operationBallanceMap.put(key, operationBallanceMap.getOrDefault(key, 0) + value);
            }
        }
        report.put(key, report.getOrDefault(key, 0) + value);
        for (HashMap.Entry<String, Integer> current : report.entrySet()) {
            System.out.println(current.getKey() + "  " + current.getValue().toString());
        }
        return report;
    }

    @Override
    public HashMap<String, Integer> getReportForOperationHandler(String lineDataFromReport) {
        String[] splitLine = lineDataFromReport.split(SEPARATE_CURRENT_LINE);
        String key = splitLine[INDEX_FOR_OPERATION_IN_STRING]
                + SEPARATE_CURRENT_LINE
                + splitLine[INDEX_FOR_PRODUCT_NAME_IN_STRING];
        int value = Integer.parseInt(splitLine[INDEX_FOR_PRODUCT_VALUE_IN_STRING]);
        report.put(key, report.getOrDefault(key, 0) + value);
        for (HashMap.Entry<String, Integer> current : report.entrySet()) {
            System.out.println(current.getKey() + "  " + current.getValue().toString());
        }
        return report;
    }*/
}
