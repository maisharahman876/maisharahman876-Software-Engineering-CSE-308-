package client;
import java.io.File;
import java.io.FileNotFoundException;

public interface CalculateSum {
    public int sum(String typ, File f) throws FileNotFoundException, Exception;
}
