import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Shop {
    private ArrayList<Tool> toolList = new ArrayList<Tool>();

    // store a tool in the toolList
    public void storeTool(Tool tool) {
        toolList.add(tool);
    }

    // print the details of all tools in toolList
    public void printAllTools() {
        for (Tool tool : toolList) {
            tool.printDetails();
        }
    }

    public void readToolData() {
        String fileName = "C:\\Users\\AsusPC\\Documents\\JavaProjects\\Tool Hire\\datas\\tool_data_1.txt";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("//")) {
                    continue;  // skip comments and empty lines
                }

                String[] data = line.trim().split(",");
                System.out.println(data[4]);
                String toolName = data[0];
                String itemCode = data[1];
                int timesBorrowed = Integer.parseInt(data[2]);
                boolean onLoan = Boolean.parseBoolean(data[3]);
                int cost = Integer.parseInt(data[4]);
                int weight = Integer.parseInt(data[5]);

                Tool tool = new Tool(toolName, itemCode, timesBorrowed, onLoan, cost, weight);
                storeTool(tool);
            }
            printAllTools();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
