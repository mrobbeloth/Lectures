import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * No luck even trying -Xms3m -Xmx4m -Xnoclassgc -Xrs
 * 3 MB min heap, 4 MB max jheap
 * No classic garbage collection
 * Reduced handling OS signals
 *
 * source of inspiration: https://bugs.openjdk.org/browse/JDK-8339901
 */
public class InternalErrorSample {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        while(true) {
            System.out.println(Files.createTempDirectory("internal_error_"+(++cnt)));
        }
    }
}
