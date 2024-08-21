package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class LookupEntryTest {
	static LookupEntry lookupEntry;
	
	@BeforeAll
	public static void init() {
		lookupEntry= new LookupEntry(443, "tcp", "sv_P1");
	}
	
	@AfterAll
	public static void cleanUp() {
		lookupEntry=null;
	}
	
	@Test
	void sanityCheck() {
		assertNotNull(lookupEntry);
	}
	
	@Test
	void canGetPortProtocolKey() {
		LookupEntry lookupEntryForTest = new LookupEntry(68, "udp", "sv_P2");
		String expected="68-udp";
        assertEquals(expected, lookupEntryForTest.getPortProtocolKey());
    }
	
	@Test
	void canGetTag() {
		LookupEntry lookupEntryForTest = new LookupEntry(68, "udp", "sv_P2");
		String expected="sv_P2";
        assertEquals(expected, lookupEntryForTest.getTag());
    }
}
