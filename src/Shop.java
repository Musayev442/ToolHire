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
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setDirectory("C:\\Users\\AsusPC\\Documents\\JavaProjects\\Tool Hire\\datas\\tool_data_1.txt"); // set directory to your desired path
        dialog.setVisible(true);

        String fileName = dialog.getFile();

        if (fileName != null) {

            File file = new File(dialog.getDirectory(), fileName);
            String typeOfData="";

            try {
                Scanner fileScanner = new Scanner(file);

                // read each line of the file and print it to the console
                while (fileScanner.hasNextLine()==true) {

                    String lineOfText = (fileScanner.nextLine()).trim();

                    if (lineOfText.startsWith("//") || lineOfText.isEmpty()) {
                        continue; // ignore comments and empty lines
                    } else if (lineOfText.startsWith("[")) {
                        typeOfData = lineOfText; // set type of data based on flag
                        System.out.println(typeOfData);
                    } else {

                        Scanner lineScanner = new Scanner(lineOfText.replaceAll("\\s+", ""));

                        if (typeOfData.equals("[ElectricTool data]")) {
                            ElectricTool electricTool = new ElectricTool();
                            electricTool.readData(lineScanner);
                            toolList.add(electricTool);
                        } else if (typeOfData.equals("[HandTool data]")) {
                            Handtool handtool=new Handtool();
                            handtool.readData(lineScanner);
                            toolList.add(handtool);
                        }

                        lineScanner.close(); // close scanner for this line
                    }
                }

                fileScanner.close(); // close scanner for file
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
        printAllTools(); // print all tools for debugging purposes

        System.exit(0);
    }
}
