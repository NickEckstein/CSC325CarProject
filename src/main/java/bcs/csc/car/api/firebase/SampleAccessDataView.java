package bcs.csc.car.api.firebase;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Test Firebase Class
 */
public class SampleAccessDataView {

    private final StringProperty userName = new SimpleStringProperty();
    private final int age = 0;
    private final ReadOnlyBooleanWrapper writePossible = new ReadOnlyBooleanWrapper();

    public SampleAccessDataView() {
        writePossible.bind(userName.isNotEmpty());
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public ReadOnlyBooleanProperty isWritePossibleProperty() {
        return writePossible.getReadOnlyProperty();
    }
}
