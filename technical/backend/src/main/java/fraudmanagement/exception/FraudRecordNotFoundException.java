package fraudmanagement.exception;

public class FraudRecordNotFoundException
        extends RuntimeException {

    public FraudRecordNotFoundException(
            String message) {

        super(message);
    }
}
