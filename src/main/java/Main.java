import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String comand = "";



            System.out.println("Shell Plan  [versão 1.0]\n" +
                    "(Po) Pacote Office. Todos os direitos reservados.");

        while (!comand.equals("exit")) {
            System.out.print("> ");
            comand = sc.nextLine();

            if (comand.equals("ls")) {
                try {
                    Path diretorioAtual = Paths.get(".");

                    Files.list(diretorioAtual).forEach(path -> {
                        System.out.println(path.getFileName());
                    });
                } catch (IOException e) {
                    System.out.println("Não foi possível listar o diretório atual: " + e.getMessage());
                }
            }
        }

        sc.close();
    }
}
