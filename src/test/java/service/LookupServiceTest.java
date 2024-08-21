package service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.LookupEntry;

public class LookupServiceTest {
	static LookupService lookupService;

    @BeforeAll
    public static void init() {
        lookupService = new LookupService();
    }
    @AfterAll
	public static void cleanUp() {
		lookupService = null;
	}
    
    @Test
    public void sanityCheck() {
    	assertNotNull(lookupService);
    }

    @Test
    public void testCreateLookupTable() {
        List<LookupEntry> lookupEntries = new ArrayList<>();
        lookupEntries.add(new LookupEntry(443, "tcp", "sv_P2"));
        lookupEntries.add(new LookupEntry(23, "tcp", "sv_P1"));

        Map<String, String> lookupTable = lookupService.createLookupTable(lookupEntries);

        assertEquals("sv_P2", lookupTable.get("443-tcp"));
        assertEquals("sv_P1", lookupTable.get("23-tcp"));
    }

}
