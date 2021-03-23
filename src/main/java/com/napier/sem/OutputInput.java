package com.napier.sem;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Helepr class for working with Input/Output
 */
public class OutputInput {

    /**
     * Handles the input for further calculations
     * @returns number N
     */
    public static int getValue() {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        while (true) {
            try {
                System.out.println("Enter the N parameter for the report: ");
                return scan.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Invalid input, try again.");
                scan.next();
            }

        }
    }
    /**
     * Writes report to a text file
     * @returns void
     */
    public static <T> void saveToFile(ArrayList<T> data, String fileName, String header)
    {
        try {
            FileWriter writer = new FileWriter(fileName + ".txt", true);
            writer.write(header);
            writer.write("\n");
            for (T d : data) {
                writer.write(d.toString());
                writer.write("\n");
            }
            System.out.println("Report generated and saved to " + fileName + ".txt");

            writer.close();


        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }
}
