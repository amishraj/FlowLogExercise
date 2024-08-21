package com.example.flowlogexercise;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.FlowLogEntry;
import model.LookupEntry;
import service.FlowLogService;
import service.LookupService;
import util.FileReaderUtil;
import util.ResultWriterUtil;

@SpringBootApplication
public class FlowlogexerciseApplication {

	public static void main(String[] args) {
		//Initialize the Service and Utility Classes
		FileReaderUtil fileReaderUtil = new FileReaderUtil();
        LookupService lookupService = new LookupService();
        FlowLogService flowLogService = new FlowLogService();
        ResultWriterUtil resultWriterUtil = new ResultWriterUtil();

        //use the util classes to read the lookup and flow log entries according to the LookupEntry and FlowLogEntry POJO Classes
        List<LookupEntry> lookupEntries = fileReaderUtil.readLookupFile("lookup.csv");
        List<FlowLogEntry> flowLogEntries = fileReaderUtil.readFlowLogFile("flow_logs.txt");

        //build the lookup table using the lookup service
        Map<String, String> lookupTable = lookupService.createLookupTable(lookupEntries);
        
        //using the flow log service, update a map of tag counts and port-protocol combination counts
        Map<String, Integer> tagCounts = flowLogService.countTags(flowLogEntries, lookupTable);
        Map<String, Integer> portProtocolCounts = flowLogService.countPortProtocolCombinations(flowLogEntries);

        //use the writer util class to write the results to the output files
        resultWriterUtil.writeTagCounts(tagCounts, "tag_counts.txt");
        resultWriterUtil.writePortProtocolCounts(portProtocolCounts, "port_protocol_counts.txt");
	}

}
