package App;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print(">");
            String command;

            try {
                command = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error reading command. Please try again.");
                continue;
            }

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            ChildProcess(command);
        }
    }

    private static void ChildProcess(String command) {
        if (command.equals("ls")) {
            Files.listCurrentDirectory();

        } else if (command.equals("help")) {
            System.out.println("ls: list current directory");
            System.out.println("mkdir: create a new directory (usage: mkdir /path/to/new/directory)");

        } else if (command.startsWith("mkdir")) {
            String directoryPath = command.substring(6).trim();
            Files.mkdir(directoryPath);

        } else {
            System.out.println("Command not recognized. Type 'help' for a list of available commands.");
        }
    }
}







