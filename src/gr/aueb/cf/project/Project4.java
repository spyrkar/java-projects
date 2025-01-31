package gr.aueb.cf.project;

import java.util.Scanner;

public class Project4 {

    public static void main(String[] args) {
        char[][] tictactoe = new char[3][3];
        char count = '1';
        int numberOfPlays = 1;

        for(int i = 0; i < tictactoe.length; ++i) {
            for(int j = 0; j < tictactoe.length; ++j) {
                tictactoe[i][j] = count++;
            }
        }

        System.out.println("Καλώσηρθατε στο παιχνίδι τρίλιζα. Ακολουθούν οι θέσεις τις τρίλιζας:");
        printBoard(tictactoe);
        Scanner in = new Scanner(System.in);

        while(numberOfPlays <= 9) {
            System.out.println();
            if (numberOfPlays % 2 != 0) {
                System.out.println("Παρακαλείται ο πρώτος παίκτης να διαλέξει τη θέση που θα τοποθετήσει το Χ");
                int choice = in.nextInt();
                if (choice >= 1 && choice <= 9) {
                    if (tictactoe[(choice - 1) / 3][(choice - 1) % 3] != 'X' && tictactoe[(choice - 1) / 3][(choice - 1) % 3] != 'O') {
                        tictactoe[(choice - 1) / 3][(choice - 1) % 3] = 'X';
                        printBoard(tictactoe);
                        if (isWinner(tictactoe, 'X')) {
                            System.out.println("Ο παίκτης 1 κερδίζει! Συγχαρητήρια!");
                            break;
                        }

                        ++numberOfPlays;
                    } else {
                        System.out.println("Έχει ήδη χρησιμοποιηθεί αυτή η θέση, παρακαλώ διαλέξτε κάποια από τις διαθέσιμες θέσεις");
                    }
                } else {
                    System.out.println("Πρέπει να διαλέξετε μία από τις διαθέσιμες θέσεις που βλέπετε στο σχήμα");
                    printBoard(tictactoe);
                }
            } else {
                System.out.println("Παρακαλείται ο δεύτερος παίκτης να διαλέξει τη θέση που θα τοποθετήσει το O");
                int choice = in.nextInt();
                if (choice >= 1 && choice <= 9) {
                    if (tictactoe[(choice - 1) / 3][(choice - 1) % 3] != 'X' && tictactoe[(choice - 1) / 3][(choice - 1) % 3] != 'O') {
                        tictactoe[(choice - 1) / 3][(choice - 1) % 3] = 927;
                        printBoard(tictactoe);
                        if (isWinner(tictactoe, 'Ο')) {
                            System.out.println("Ο παίκτης 2 κερδίζει! Συγχαρητήρια!");
                            break;
                        }

                        ++numberOfPlays;
                    } else {
                        System.out.println("Έχει ήδη χρησιμοποιηθεί αυτή η θέση, παρακαλώ διαλέξτε κάποια από τις διαθέσιμες θέσεις");
                    }
                } else {
                    System.out.println("Πρέπει να διαλέξετε μία από τις διαθέσιμες θέσεις που βλέπετε στο σχήμα");
                    printBoard(tictactoe);
                }
            }
        }

        System.out.println("Το παιχνίδι έληξε χωρίς νικητή. Ισοπαλία.");
    }

    public static void printBoard(char[][] gameboard) {
        for(int i = 0; i < gameboard.length; ++i) {
            for(int j = 0; j < gameboard.length; ++j) {
                System.out.printf(" %c ", gameboard[i][j]);
            }

            System.out.println();
        }

    }

    public static boolean isWinner(char[][] gameboard, char choice) {
        for(int i = 0; i < 3; ++i) {
            if (gameboard[i][0] == choice && gameboard[i][1] == choice && gameboard[i][2] == choice) {
                return true;
            }
        }

        for(int j = 0; j < 3; ++j) {
            if (gameboard[0][j] == choice && gameboard[1][j] == choice && gameboard[2][j] == choice) {
                return true;
            }
        }

        if (gameboard[0][0] == choice && gameboard[1][1] == choice && gameboard[2][2] == choice) {
            return true;
        } else if (gameboard[0][2] == choice && gameboard[1][1] == choice && gameboard[2][0] == choice) {
            return true;
        } else {
            return false;
        }
    }
}
