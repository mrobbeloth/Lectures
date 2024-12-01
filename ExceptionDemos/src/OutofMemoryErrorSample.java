import java.util.ArrayList;
import java.util.List;

/* Note setting 32 MB for the Java Heap space min and max will still only trigger OutOfMemoryError
*  Ditto 8 MB (surprised I could set it this low)
*
*  Gets a bit weird for min of 3 MB and max 4MB
* Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Monitor Ctrl-Break"
  Count=1
  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
  * */
public class OutofMemoryErrorSample {
    public static void main(String[] args) {
        // Out of Memory Error
        List<String> stringList = new ArrayList<>();
        int cnt = 0;
        while (true) {
            stringList.add(new String(new char[1000000])); // 1 MB increments on heap until it chokes
            System.out.println("Count="+(++cnt));
        }
    }
}
