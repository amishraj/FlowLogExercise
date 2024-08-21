package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.LookupEntry;

public class LookupService {
	
	//method that creates the lookup table for port-protocol key and tag value
	public Map<String, String> createLookupTable(List<LookupEntry> lookupEntries) {
        Map<String, String> lookupTable = new HashMap<>();
        for (LookupEntry entry : lookupEntries) {
            lookupTable.put(entry.getPortProtocolKey(), entry.getTag());
        }
        return lookupTable;
    }
}
