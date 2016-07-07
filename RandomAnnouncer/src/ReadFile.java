import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This program reads a text file line by line and print to the console. It uses
 * FileOutputStream to read the file.
 *
 */
public class ReadFile {

    private String Text = "";

    public ReadFile(String path) {
        File file = new File(path);

        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

            // dis.available() returns 0 if the file does not have more lines.
            while (dis.available() != 0) {
                // this statement reads the line from the file and save it to
                // the text string.
                Text += dis.readLine() + "\n";
            }

            // dispose all the resources after using them.
            dis.close();
        } catch (FileNotFoundException e) {
            //   e.printStackTrace();
        } catch (IOException e) {
            //    e.printStackTrace();
        }
    }

    /**
     * @return the getURL
     */
    public String getText() {
        return Text;
    }
}