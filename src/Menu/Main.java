package Menu;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Menu.Menu;
import Menu.MenuManager;

public class Main {
    public static void main(String[] args) {
        Menu menu = new MenuManager();
        menu.run();
    }
}