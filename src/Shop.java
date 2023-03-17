import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private final ArrayList<ShopItem> shopItemList = new ArrayList<>();

    // print the details of all tools in toolList
    public void printAllTools() {
        int toolCount = 1;

        System.out.println("--------- Shop Tools ---------");

        for (ShopItem item : shopItemList) {
            System.out.println("Tool: " + toolCount);

            item.printDetails();

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
                while (fileScanner.hasNextLine()) {

                    String lineOfText = (fileScanner.nextLine()).trim();

                    if (lineOfText.startsWith("//") || lineOfText.isEmpty()) {
                        continue; // ignore comments and empty lines
                    }

                    if (lineOfText.startsWith("[")) {
                        typeOfData = lineOfText; // set type of data based on flag
                        System.out.println(typeOfData);
                    } else {

                        Scanner lineScanner = new Scanner(lineOfText);

                        if (typeOfData.equalsIgnoreCase("[ElectricTool data]")) {
                            ElectricTool electricTool = new ElectricTool();
                            electricTool.readData(lineScanner);
                            shopItemList.add(electricTool);
                        } else if (typeOfData.equals("[HandTool data]")) {
                            Handtool handtool=new Handtool();
                            handtool.readData(lineScanner);
                            shopItemList.add(handtool);
                        }else if (typeOfData.equals("[Perishable data]")){
                            Perishable perishable=new Perishable();
                            perishable.readData(lineScanner);
                            shopItemList.add(perishable);
                        }else if (typeOfData.equals("[Workwear data]")){
                            Workwear workwear =new Workwear();
                            workwear.readData(lineScanner);
                            shopItemList.add(workwear);
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
