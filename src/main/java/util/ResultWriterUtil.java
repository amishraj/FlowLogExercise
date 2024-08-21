package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ResultWriterUtil {
	
	//method that writes the tag counts to the specified file path in the output dir
    public void writeTagCounts(Map<String, Integer> tagCounts, String outputFilePath) {
        try (FileWriter writer = new FileWriter("output/" +outputFilePath)) {
            writer.write("Tag,Count\n");
            for (Map.Entry<String, Integer> entry : tagCounts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method that writes the port/protocol combination counts to the specified file path in the output dir
    public void writePortProtocolCounts(Map<String, Integer> portProtocolCounts, String outputFilePath) {
        try (FileWriter writer = new FileWriter("output/" +outputFilePath)) {
            writer.write("Port,Protocol,Count\n");
            for (Map.Entry<String, Integer> entry : portProtocolCounts.entrySet()) {
                String[] parts = entry.getKey().split("-");
                writer.write(parts[0] + "," + parts[1] + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
