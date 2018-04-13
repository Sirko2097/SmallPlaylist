package view;


import controller.MenuController;
import org.apache.log4j.Logger;

import java.io.IOException;

public class View {

    private final static Logger logger = Logger.getLogger(View.class);
    public void init(){
        try {
            new MenuController().printMenu();
            logger.info("Menu controller initialized");
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public void printElement(String message) {
        System.out.print(message);
    }

    public void printElement(String message, String element) {
        System.out.println(message + element);
    }

}
