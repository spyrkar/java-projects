package gr.aueb.cf.project;

import java.util.Scanner;

public class Project5 {

    public static void main(String[] args) {
        boolean[][] theaterSeats = new boolean[30][12];
        String columns = "ABCDEFGHIJKL";

        while(true) {
            System.out.println("Καλωσήρθατε! Επιλέξτε την επιθυμητή ενέργεια:");
            System.out.println("1. Κράτηση θέσης");
            System.out.println("2. Ακύρωση κράτησης");
            System.out.println("3. Έξοδος");
            Scanner in = new Scanner(System.in);
            int selection = in.nextInt();
            in.nextLine();
            if (selection == 3) {
                return;
            }

            if (selection == 1) {
                System.out.println("Παρακαλώ εισάγετε τη στήλη και τη σειρά της θέσης που επιθυμείτε να κατοχυρώσετε: π.χ. Α1");
                String choice = in.nextLine();
                if (choice.length() >= 2 && choice.length() <= 3) {
                    char choiceColumn = choice.charAt(0);
                    int column = columns.indexOf(choiceColumn);
                    int row = Integer.parseInt(choice.substring(1));
                    book(theaterSeats, column, row);
                } else {
                    System.out.println("Μη έγκυρη καταχώρηση, προσπαθήστε ξανά!");
                }
            } else if (selection == 2) {
                System.out.println("Παρακαλώ εισάγετε τη στήλη και τη σειρά της θέσης που επιθυμείτε να ακυρώσετε: π.χ. Α1");
                String choice = in.nextLine();
                if (choice.length() >= 2 && choice.length() <= 3) {
                    char choiceColumn = choice.charAt(0);
                    int column = columns.indexOf(choiceColumn);
                    int row = Integer.parseInt(choice.substring(1));
                    cancel(theaterSeats, column, row);
                } else {
                    System.out.println("Μη έγκυρη καταχώρηση, προσπαθήστε ξανά!");
                }
            }
        }
    }

    public static void book(boolean[][] theaterSeats, int column, int row) {
        if (row >= 0 && row <= 30 && column >= 0 && column < 12) {
            if (!theaterSeats[row - 1][column]) {
                theaterSeats[row - 1][column] = true;
                System.out.println("Η κράτησή σας πραγματοποιήθηκε με επιτυχία!");
            } else {
                System.out.println("H θέση που επιλέξατε είναι κρατημένη. Επιλέξτε μία άλλη θέση.");
            }

        } else {
            System.out.println("Υπήρξε σφάλμα στην επιλογή της θέσης, προσπαθήστε ξανά!");
        }
    }

    public static void cancel(boolean[][] theaterSeats, int column, int row) {
        if (row >= 0 && row <= 30 && column >= 0 && column < 12) {
            if (theaterSeats[row - 1][column]) {
                theaterSeats[row - 1][column] = false;
                System.out.println("Η ακύρωση της κράτησης πραγματοποιήθηκε με επιτυχία!");
            } else {
                System.out.println("H θέση που επιλέξατε δεν είναι κρατημένη. Επιλέξτε μία άλλη θέση.");
            }

        } else {
            System.out.println("Υπήρξε σφάλμα στην επιλογή της θέσης, προσπαθήστε ξανά!");
        }
    }
}
