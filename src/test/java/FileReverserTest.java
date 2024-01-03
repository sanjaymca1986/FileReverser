import co.file.FileReverser;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class FileReverserTest {
    private final FileReverser fileReverser = new FileReverser();

    @Test
    public void testReverseFile_simpleContent() throws IOException {
        String inputContent = "ABC";
        String expectedOutput = "CBA";

        testFileReversal(inputContent, expectedOutput);
    }

    @Test
    public void testReverseFile_multilineContent() throws IOException {
        String inputContent = "Line 1\nLine 2\nLine 3";
        String expectedOutput = "3 eniL\n2 eniL\n1 eniL";

        testFileReversal(inputContent, expectedOutput);
    }

    @Test
    public void testReverseFile_emptyFile() throws IOException {
        String inputContent = "";
        String expectedOutput = "";

        testFileReversal(inputContent, expectedOutput);
    }

    @Test
    public void testReverseFile_singleCharacter() throws IOException {
        String inputContent = "X";
        String expectedOutput = "X";

        testFileReversal(inputContent, expectedOutput);
    }
    private void testFileReversal(String inputContent, String expectedOutput) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        fileReverser.reverseFile(new InputStreamReader(inputStream), new OutputStreamWriter(outputStream));

        assertEquals(expectedOutput, outputStream.toString());
    }
}
