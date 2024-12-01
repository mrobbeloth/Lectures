public class UglyException extends GrowthRateException{
    public UglyException(){
        throw new RuntimeException();
    }

    public UglyException(String message){
        throw new RuntimeException(message);
    }
}
