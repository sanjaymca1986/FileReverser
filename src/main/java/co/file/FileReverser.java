package co.file;

import java.io.*;

public class FileReverser {
     public void reverseFile(InputStreamReader inputStreamReader, OutputStreamWriter outputStreamWriter) {
        StringBuilder fileContents = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String reversedContents = fileContents.reverse().toString().replaceFirst("^\\n", "");

        try (BufferedWriter writer = new BufferedWriter(outputStreamWriter)) {
            writer.write(reversedContents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
