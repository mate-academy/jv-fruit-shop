package core.basesyntax.service.util;

public class TransactionSplitter {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_COLUMN = 0;
    private static final int PRODUCT_TYPE_COLUMN = 1;
    private static final int OPERATION_VALUE_COLUMN = 2;

    public static String getOperationType(String row) {
        String[] columns = row.split(SEPARATOR);
        return columns[OPERATION_TYPE_COLUMN];
    }

    public static String getProductType(String row) {
        String[] columns = row.split(SEPARATOR);
        return columns[PRODUCT_TYPE_COLUMN];
    }

    public static int getOperationValue(String row) {
        String[] columns = row.split(SEPARATOR);
        return Integer.parseInt(columns[OPERATION_VALUE_COLUMN]);
    }
}
