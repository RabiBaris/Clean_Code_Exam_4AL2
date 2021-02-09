package infrastructure.utilities;

import infrastructure.dao.IUserDao;
import infrastructure.dao.IBookDao;
import domain.User;
import infrastructure.factories.DaoFactory;
import infrastructure.factories.MessageFactory;
import use_case.*;

import java.util.List;
import java.util.Scanner;

public class ScannerProject {

    private IUserDao userDao = DaoFactory.getUserDao();
    private IBookDao bookDao = DaoFactory.getBookDao();
    private Scanner scanner = new Scanner(System.in);
    private static ScannerProject instance;

    private ScannerProject() {
    }

    public static ScannerProject getInstance() {
        if (instance == null) {
            instance = new ScannerProject();
        }
        return instance;
    }

    public void start() {
        boolean endProgram = false;
        while (!endProgram) {
            MessageFactory.getMessage().send("Pour vous connecter en tant que libraire, écrivez \"libraire\", pour vous connecter en tant qu'utilisateur, entrez votre id, pour quitter le programme, entrez \"end\"");
            String s = scanner.nextLine();
            switch (s) {
                case "libraire":
                    menuLibraire();
                    break;
                case "end":
                    endProgram = true;
                    break;
                default:
                    try {
                        int userId = Integer.parseInt(s);
                        List <Integer> existingId = userDao.getAllId();
                        if (existingId.contains(userId)) {
                            User user = userDao.getUserById(userId);
                            menuUser(user);
                        }
                        else {
                            MessageFactory.getMessage().send("Utilisateur inconnu");
                        }
                    }
                    catch (Exception e) {
                        MessageFactory.getMessage().send("Merci d'entrer une commande correcte");
                    }

                }


            }


        }
        
    private void menuLibraire() {
        boolean endLibraire = false;
        while (!endLibraire) {
            MessageFactory.getMessage().send("Pour consulter tous les livres, écrivez \"tous\", pour retourner au menu principal, entrez \"menu\"");
            String s = scanner.nextLine();
            switch (s) {
                case "tous":
                    new DisplayAllBooksUseCase();
                    break;
                case "menu":
                    endLibraire = true;
                    break;
                default:
                    MessageFactory.getMessage().send("Merci d'entrer une commande correcte");

            }

        }
    }

    private void menuUser (User user) {
        boolean endUser = false;
        while (!endUser) {
            MessageFactory.getMessage().send("Pour consulter tous les livres, écrivez \"tous\", pour retourner au menu principal, entrez \"menu\"");
            String s = scanner.nextLine();
            switch (s) {
                case "tous":
                    new DisplayAllBooksUseCase();
                    break;
                case "menu":
                    endUser = true;
                    break;
                default:
                    MessageFactory.getMessage().send("Merci d'entrer une commande correcte");

            }
        }

    }


}
