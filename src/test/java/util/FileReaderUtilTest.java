package util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.FlowLogEntry;
import model.LookupEntry;

public class FileReaderUtilTest {
	
	@Test
    public void testReadFlowLogFile() {
        FileReaderUtil fileReaderUtil = new FileReaderUtil();
        List<FlowLogEntry> flowLogs = fileReaderUtil.readFlowLogFile("flow_logs.txt");

        assertNotNull(flowLogs);
        assertEquals(14, flowLogs.size());  // Assuming the provided sample data is in flow_logs.txt

        FlowLogEntry entry = flowLogs.get(0);
        assertEquals("10.0.1.201", entry.getSrcIp());
        assertEquals("198.51.100.2", entry.getDstIp());
        assertEquals(443, entry.getDstPort());
        assertEquals(6, entry.getProtocol());
    }

    @Test
    public void testReadLookupFile() {
        FileReaderUtil fileReaderUtil = new FileReaderUtil();
        List<LookupEntry> lookupEntries = fileReaderUtil.readLookupFile("lookup.csv");

        assertNotNull(lookupEntries);
        assertEquals(11, lookupEntries.size());  // Assuming the provided sample data is in lookup.csv

        LookupEntry entry = lookupEntries.get(0);
        assertEquals(25, entry.getDstPort());
        assertEquals("tcp", entry.getProtocol());
        assertEquals("sv_P1", entry.getTag());
    }

}
