package service;
import java.util.*;

import model.FlowLogEntry;

public class FlowLogService {

	//method that counts the tag counts using the flow logs and lookup table
    public Map<String, Integer> countTags(List<FlowLogEntry> flowLogs, Map<String, String> lookupTable) {
        Map<String, Integer> tagCounts = new HashMap<>();
        for (FlowLogEntry entry : flowLogs) {
            String tag = lookupTable.getOrDefault(entry.getPortProtocolKey(), "Untagged");
            tagCounts.put(tag, tagCounts.getOrDefault(tag, 0) + 1);
        }
        return tagCounts;
    }

    //method that counts the port protocol combinations from the flow logs
    public Map<String, Integer> countPortProtocolCombinations(List<FlowLogEntry> flowLogs) {
        Map<String, Integer> portProtocolCounts = new HashMap<>();
        for (FlowLogEntry entry : flowLogs) {
            String key = entry.getPortProtocolKey();
            portProtocolCounts.put(key, portProtocolCounts.getOrDefault(key, 0) + 1);
        }
        return portProtocolCounts;
    }
}
