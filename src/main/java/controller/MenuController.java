package controller;

import org.apache.log4j.Logger;
import service.MainMenu;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class MenuController {
    private static final Logger logger = Logger.getLogger(MenuController.class);

    public void printMenu() throws IOException {
        MainController mainController = new MainController();
        char key;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ResourceBundle bundle = chooseLanguage();

        logger.info("Printing menu, according to the chosen language");
        while (true) {
            try {
                MainMenu.menu(bundle);


                key = reader.readLine().charAt(0);
                switch (key) {
                    case '1':
                        logger.info("Print all records method was generated");
                        mainController.printPlaylist();
                        break;
                    case '2':
                        logger.info("Find by name method was generated");
                        mainController.findByName();
                        break;
                    case '3':
                        logger.info("Find by performer method was generated");
                        mainController.findByPerformer();
                        break;
                    case '4':
                        logger.info("Sort all records method was generated");
                        mainController.sortByName();
                        break;
                    case '5':
                        logger.info("Find the longest song method was generated");
                        mainController.findTheLongestSong();
                        break;
                    case '6':
                        try {
                            reader.close();
                        } catch (IOException e) {
                            logger.error(e);
                        }
                        logger.info("Closing the application");
                        System.exit(0);
                    default:
                        System.out.println("Try again");
                        break;
                }
            } catch (IOException e) {
                logger.error(e);
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
                    logger.info("English was chosen");
                    return ResourceBundle.getBundle("resource");
                case '2':
                    logger.info("Ukrainian was chosen");
                    return ResourceBundle.getBundle("resource_ua");
                    default:
                        new View().printElement("Error! Try again!");
                        break;
            }
        }

    }
}
