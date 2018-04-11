package service;

import java.util.ResourceBundle;

public class MainMenu {
    public static void menu(ResourceBundle bundle) {
        System.out.println(bundle.getString("printAll"));
        System.out.println(bundle.getString("findSongByName"));
        System.out.println(bundle.getString("findSongByPerformer"));
        System.out.println(bundle.getString("sortSongsByName"));
        System.out.println(bundle.getString("findTheLongestSong"));
        System.out.println(bundle.getString("exit"));
        System.out.print(bundle.getString("waitForInput") + " ");
    }
}
