package main;

import dao.Connector;
import menu.MainMenu;

public class Main {

    public static boolean alive = true;

    public static void main(String[] args) {
        Connector.createEmf();
        System.out.println("\nSCHOOL MANAGEMENT APPLICATION");
        while(alive){
            MainMenu.menu();
        }
        Connector.closeEmf();
    }
}
