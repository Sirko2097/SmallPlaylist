package view;


import controller.MenuController;

public class View {

    public void init(){
        new MenuController().printMenu();
    }

    public void printElement(String message) {
        System.out.print(message);
    }

    public void printElement(String message, String element) {
        System.out.println(message + element);
    }

}
