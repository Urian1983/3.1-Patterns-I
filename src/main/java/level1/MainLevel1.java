package level1;

import level1.view.Terminal;

import java.util.Scanner;

public class MainLevel1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Terminal terminal = new Terminal();
        terminal.run(scanner);
        scanner.close();
    }
}
