import java.util.ArrayList;

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
}
