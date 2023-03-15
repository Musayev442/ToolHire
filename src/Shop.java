import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private ArrayList<Tool> toolList = new ArrayList<Tool>();

    // store a tool in the toolList
    public void storeTool(Tool tool) {
        toolList.add(tool);
    }

    // print the details of all tools in toolList
    public void printAllTools() {
        int toolCount = 1;

        System.out.println("--------- Shop Tools ---------");

        for (Tool tool : toolList) {
            System.out.println("Tool: " + toolCount);

            tool.printDetails();

            System.out.println("\n");
            toolCount++;
        }
    }

    public void readToolData() {
        // create a FileDialog to select the input file
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setDirectory("C:\\Users\\AsusPC\\Documents\\JavaProjects\\Tool Hire\\datas\\tool_data_1.txt"); // set directory to your desired path
        dialog.setVisible(true);

        String fileName = dialog.getFile();
        if (fileName != null) {
            System.out.println("Selected file: " + fileName);
            File file = new File(dialog.getDirectory(), fileName);

            try {
                Scanner fileScanner = new Scanner(file);

                // read each line of the file and print it to the console
                while (fileScanner.hasNextLine()) {
                    String lineOfText = fileScanner.nextLine().trim();

                    if (lineOfText.trim().isEmpty() || lineOfText.startsWith("//")) {
                        continue;  // skip comments and empty lines
                    }

                    Scanner lineScanner = new Scanner(lineOfText);
                    lineScanner.useDelimiter(",");


                    String toolName = lineScanner.next();
                    String itemCode = lineScanner.next();
                    int timesBorrowed = Integer.parseInt(lineScanner.next());
                    boolean onLoan = Boolean.parseBoolean(lineScanner.next());
                    int cost = Integer.parseInt(lineScanner.next());
                    int weight = Integer.parseInt(lineScanner.next());

                    Tool tool = new Tool(toolName, itemCode, timesBorrowed, onLoan, cost, weight);
                    storeTool(tool);

                    lineScanner.close(); // close scanner for this line
                }

                fileScanner.close(); // close scanner for file
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
        printAllTools(); // print all tools for debugging purposes

    }
}
