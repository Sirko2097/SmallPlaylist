package controller;

import service.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuController {
    public void printMenu() {
        MainController mainController = new MainController();
        char key;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            MainMenu.menu();

            try {
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
}
