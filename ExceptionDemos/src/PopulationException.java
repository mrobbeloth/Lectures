public class PopulationException extends Exception {
    public PopulationException() {
        super("Invalid population value");
    }

    public PopulationException(String message) {
        super(message);
    }
}
