package view;


import controller.MenuController;

import java.io.IOException;

public class View {

    public void init(){
        try {
            new MenuController().printMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printElement(String message) {
        System.out.print(message);
    }

    public void printElement(String message, String element) {
        System.out.println(message + element);
    }

}
