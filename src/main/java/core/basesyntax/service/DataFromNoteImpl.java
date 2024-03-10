package core.basesyntax.service;

public class DataFromNoteImpl implements DataFromNote {
    public static final String ELEMENT_SEPARATOR = ";";

    @Override
    public String[] getData(String note) {
        return note.split(ELEMENT_SEPARATOR);
    }
}
