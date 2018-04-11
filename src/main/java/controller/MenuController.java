package controller;

import service.MainMenu;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class MenuController {
    public void printMenu() throws IOException {
        MainController mainController = new MainController();
        char key;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ResourceBundle bundle = chooseLanguage();

        while (true) {
            try {
                MainMenu.menu(bundle);

                key = reader.readLine().charAt(0);
                switch (key) {
                    case '1':
                        mainController.printPlaylist();
                        break;
                    case '2':
                        mainController.findByName();
                        break;
                    case '3':
                        mainController.findByPerformer();
                        break;
                    case '4':
                        mainController.sortByName();
                        break;
                    case '5':
                        mainController.findTheLongestSong();
                        break;
                    case '6':
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.exit(0);
                    default:
                        System.out.println("Try again");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
    private ResourceBundle chooseLanguage() throws IOException {
        char key;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Choose Language:");
        System.out.println("1) English;");
        System.out.println("2) Українська;");
        System.out.print("Input key> ");


        key = reader.readLine().charAt(0);
        while (true) {
            switch (key) {
                case '1':
                    return ResourceBundle.getBundle("resource");
                case '2':
                    return ResourceBundle.getBundle("resource_ua");
                    default:
                        new View().printElement("Error! Try again!");
                        break;
            }
        }

    }
}
