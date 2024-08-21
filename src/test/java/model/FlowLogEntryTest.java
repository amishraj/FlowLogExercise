package model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FlowLogEntryTest {
	static FlowLogEntry flowLogEntry;
	
	@BeforeAll
	public static void init() {
		flowLogEntry= new FlowLogEntry(2, "123456789012", "eni-0a1b2c3d", "10.0.1.201", "198.51.100.2", 443, 49153, 6, 25, 20000, 1620140761, 1620140821, "ACCEPT", "OK");
		
	}
	
	@AfterAll
	public static void cleanUp() {
		flowLogEntry=null;
	}
	
	@Test
	void sanityCheck() {
		assertNotNull(flowLogEntry);
	}
	
	@Test
	void canGetPortProtocolKey() {
		FlowLogEntry flowLogEntryForTest= new FlowLogEntry(2, "123456789012", "eni-0a1b2c3d", "10.0.1.201", "198.51.100.2", 443, 49153, 6, 25, 20000, 1620140761, 1620140821, "ACCEPT", "OK");

		String expected = "443-tcp";
		assertEquals(expected, flowLogEntryForTest.getPortProtocolKey());
    }
	
	@Test
	void canGetProtocolName() {
		assertEquals("tcp", flowLogEntry.getProtocolName());
	}
}
