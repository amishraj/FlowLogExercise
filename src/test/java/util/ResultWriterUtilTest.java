package util;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultWriterUtilTest {
	@Test
    public void testWriteTagCounts() throws IOException {
        ResultWriterUtil resultWriterUtil = new ResultWriterUtil();
        Map<String, Integer> tagCounts = new HashMap<>();
        tagCounts.put("sv_P2", 1);
        tagCounts.put("sv_P1", 2);

        resultWriterUtil.writeTagCounts(tagCounts, "test_tag_counts.txt");

        BufferedReader reader = new BufferedReader(new FileReader("output/test_tag_counts.txt"));
            assertEquals("Tag,Count", reader.readLine());
            assertEquals("sv_P2,1", reader.readLine());
            assertEquals("sv_P1,2", reader.readLine());
    }

    @Test
    public void testWritePortProtocolCounts() throws IOException {
        ResultWriterUtil resultWriterUtil = new ResultWriterUtil();
        Map<String, Integer> portProtocolCounts = new HashMap<>();
        portProtocolCounts.put("443-tcp", 1);
        portProtocolCounts.put("23-tcp", 1);

        resultWriterUtil.writePortProtocolCounts(portProtocolCounts, "test_port_protocol_counts.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader("output/test_port_protocol_counts.txt"))) {
            assertEquals("Port,Protocol,Count", reader.readLine());
            assertEquals("23,tcp,1", reader.readLine());
            assertEquals("443,tcp,1", reader.readLine());
        }
    }

}
