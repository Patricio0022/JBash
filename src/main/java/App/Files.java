package App;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Process;

public class Files {

        public static void listCurrentDirectory() {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd" ,"/c" ,"dir"); //Create new process
            processBuilder.directory(new File("."));



            try {
                Process process = processBuilder.start();

                long pid = process.pid(); // getting the pid of child process
                    System.out.printf("### Child ###\nCurrent PID: %d and Child PID: %d\n",
                        ProcessHandle.current().pid(), pid);

                process.waitFor(); //waiting the process
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream())); //reading
                String line;
                while( (line = reader.readLine())!= null) {
                    System.out.println(line);

                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }

        public static void mkdir(String name) {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "mkdir", name);

            try {
                Process process = processBuilder.start();
                long pid = process.pid(); // getting the pid of child process
                System.out.printf("### Child ###\nCurrent PID: %d and Child PID: %d\n",
                        ProcessHandle.current().pid(), pid);

                System.out.println("directory: " + name + "created in" );

                process.waitFor(); //waiting the process

            }  catch (IOException | InterruptedException e) {
                e.printStackTrace();

            }

        }


    }






