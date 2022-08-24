package core.basesyntax.service;

import core.basesyntax.process.ProcessData;
import core.basesyntax.process.ProcessDataImpl;
import core.basesyntax.readdata.DataReading;
import core.basesyntax.readdata.DataReadingImpl;
import core.basesyntax.writedata.DataWriting;
import core.basesyntax.writedata.DataWritingImpl;

public class ShopServiceImpl implements ShopService {
    private DataReading dataReading = new DataReadingImpl();
    private ProcessData processData = new ProcessDataImpl();
    private DataWriting dataWriting = new DataWritingImpl();

    @Override
    public void servicing(String fileName) {
        dataReading.readData(fileName);
        processData.processingData();
        dataWriting.writeData(fileName);
    }
}
