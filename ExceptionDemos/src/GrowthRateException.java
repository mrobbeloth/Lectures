public class GrowthRateException extends Exception {
    public GrowthRateException() {
        super("Growth rate entry was invalid");
    }

    public GrowthRateException(String message) {
        super(message);
    }
}
