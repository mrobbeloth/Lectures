import java.io.*;

public class FileProcessor {
    public static final int SUCCESS = 0;
    public static final int FILE_NOT_FOUND = 1;
    public static final int READ_ERROR = 2;
    public static final int UNSUPPORTED_FORMAT = 3;

    public static void main(String[] args) {
        String filePath = args[0]; // Change to your file path
        int resultCode = processFile(filePath);

        switch (resultCode) {
            case SUCCESS:
                System.out.println("File processed successfully.");
                break;
            case FILE_NOT_FOUND:
                System.out.println("Error: File not found.");
                break;
            case READ_ERROR:
                System.out.println("Error: Could not read the file."); // use icalcs or Windows Permissions
                break;
            case UNSUPPORTED_FORMAT:
                System.out.println("Error: Unsupported file format.");
                break;
            default:
                System.out.println("Unknown error occurred.");
        }
    }

    public static int processFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return FILE_NOT_FOUND;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!isSupportedFormat(line)) {
                    return UNSUPPORTED_FORMAT;
                }
                // Process the line here
            }
        } catch (IOException e) {
            return READ_ERROR;
        }

        return SUCCESS;
    }

    public static boolean isSupportedFormat(String line) {
        // Check if the line is in the supported format
        // For simplicity, let's say we only support lines with alphanumeric characters
        return line.matches("[a-zA-Z0-9 ]+");
    }
}
