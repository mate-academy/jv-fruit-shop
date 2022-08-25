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

    public void setDataReading(DataReading dataReading) {
        this.dataReading = dataReading;
    }

    public void setProcessData(ProcessData processData) {
        this.processData = processData;
    }

    public void setDataWriting(DataWriting dataWriting) {
        this.dataWriting = dataWriting;
    }

    @Override
    public void servicing(String fileStartDay, String fileReport) {
        setDataReading(new DataReadingImpl());
        setProcessData(new ProcessDataImpl());
        setDataWriting(new DataWritingImpl());
        dataReading.readData(fileStartDay);
        processData.processingData();
        dataWriting.writeData(fileReport);
    }
}
