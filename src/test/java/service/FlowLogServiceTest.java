package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.*;

import model.FlowLogEntry;

public class FlowLogServiceTest {
	static FlowLogService flowLogService;
	
	@BeforeAll
    public static void init() {
        flowLogService = new FlowLogService();
    }
	
	@AfterAll
	public static void cleanUp() {
		flowLogService = null;
	}
	
	@Test
	void sanityCheck() {
		assertNotNull(flowLogService);
	}
	
	@Test
    public void testCountTags() {
        List<FlowLogEntry> flowLogs = new ArrayList<>();
        flowLogs.add(new FlowLogEntry(2, "123456789012", "eni-0a1b2c3d", "10.0.1.201", "198.51.100.2", 443, 49153, 6, 25, 20000, 1620140761, 1620140821, "ACCEPT", "OK"));
        flowLogs.add(new FlowLogEntry(2, "123456789012", "eni-4d3c2b1a", "192.168.1.100", "203.0.113.101", 23, 49154, 6, 15, 12000, 1620140761, 1620140821, "REJECT", "OK"));

        Map<String, String> lookupTable = new HashMap<>();
        lookupTable.put("443-tcp", "sv_P2");
        lookupTable.put("23-tcp", "sv_P1");

        Map<String, Integer> tagCounts = flowLogService.countTags(flowLogs, lookupTable);

        assertEquals(1, tagCounts.get("sv_P2"));
        assertEquals(1, tagCounts.get("sv_P1"));
        assertEquals(null, tagCounts.get("Untagged"));
    }

    @Test
    public void testCountPortProtocolCombinations() {
        List<FlowLogEntry> flowLogs = new ArrayList<>();
        flowLogs.add(new FlowLogEntry(2, "123456789012", "eni-0a1b2c3d", "10.0.1.201", "198.51.100.2", 443, 49153, 6, 25, 20000, 1620140761, 1620140821, "ACCEPT", "OK"));
        flowLogs.add(new FlowLogEntry(2, "123456789012", "eni-4d3c2b1a", "192.168.1.100", "203.0.113.101", 23, 49154, 6, 15, 12000, 1620140761, 1620140821, "REJECT", "OK"));

        Map<String, Integer> portProtocolCounts = flowLogService.countPortProtocolCombinations(flowLogs);

        assertEquals(1, portProtocolCounts.get("443-tcp"));
        assertEquals(1, portProtocolCounts.get("23-tcp"));
    }

}
