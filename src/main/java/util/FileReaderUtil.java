package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import model.FlowLogEntry;
import model.LookupEntry;

public class FileReaderUtil {
	
	//method that parses the flow logs as per the FlowLogEntry class 
	public List<FlowLogEntry> readFlowLogFile(String filePath) {
        List<FlowLogEntry> flowLogs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                FlowLogEntry entry = new FlowLogEntry(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        parts[3],
                        parts[4],
                        Integer.parseInt(parts[5]),
                        Integer.parseInt(parts[6]),
                        Integer.parseInt(parts[7]),
                        Long.parseLong(parts[8]),
                        Long.parseLong(parts[9]),
                        Long.parseLong(parts[10]),
                        Long.parseLong(parts[11]),
                        parts[12],
                        parts[13]
                );
                flowLogs.add(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flowLogs;
    }

	//method that parses the lookup file and creates the entries based on the LookupEntry class
    public List<LookupEntry> readLookupFile(String filePath) {
        List<LookupEntry> lookupEntries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filePath)))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                LookupEntry entry = new LookupEntry(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2]
                );
                lookupEntries.add(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lookupEntries;
    }
}
