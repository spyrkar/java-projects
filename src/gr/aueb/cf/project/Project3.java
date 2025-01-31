package gr.aueb.cf.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project3 {


    public static void main(String[] args) {
        File inFile = new File("C:/Users/User/CodingFactory/JAVA/project3text.txt");
        int[][] charactersTable = new int[128][2];

        for(int i = 0; i < charactersTable.length; ++i) {
            charactersTable[i][0] = i;
            charactersTable[i][1] = 0;
        }

        try (Scanner in = new Scanner(inFile)) {
            while(in.hasNextLine()) {
                String line = in.next();
                char[] characters = line.toCharArray();

                for(char ch : characters) {
                    int var10002 = charactersTable[ch][1]++;
                }
            }

            System.out.println("Ταξινομημένη εκτύπωση ανά χαρακτήρα:");

            for(int i = 0; i <= charactersTable.length - 1; ++i) {
                if (charactersTable[i][1] >= 1) {
                    System.out.printf("%s %d\n", (char)charactersTable[i][0], charactersTable[i][1]);
                }
            }

            System.out.println("Ταξινομημένη εκτύπωση ανά συχνότητα εμφάνισης:");
            int[][] sortedByFrequency = mergeSort(charactersTable, 0, charactersTable.length - 1);

            for(int i = 0; i <= sortedByFrequency.length - 1; ++i) {
                if (sortedByFrequency[i][1] >= 1) {
                    System.out.printf("%s %d\n", (char)sortedByFrequency[i][0], sortedByFrequency[i][1]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[][] mergeSort(int[][] array, int s, int n) {
        if (n - s <= 0) {
            return new int[][]{{array[s][0], array[s][1]}};
        } else {
            int mid = (n + s) / 2;
            int[][] left = mergeSort(array, s, mid);
            int[][] right = mergeSort(array, mid + 1, n);
            return merge(left, right);
        }
    }

    public static int[][] merge(int[][] left, int[][] right) {
        int[][] merged = new int[left.length + right.length][2];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length) {
            if (left[i][1] < right[j][1]) {
                merged[k][0] = right[j][0];
                merged[k][1] = right[j][1];
                ++j;
                ++k;
            } else {
                merged[k][0] = left[i][0];
                merged[k][1] = left[i][1];
                ++i;
                ++k;
            }
        }

        while(i < left.length) {
            merged[k][0] = left[i][0];
            merged[k][1] = left[i][1];
            ++i;
            ++k;
        }

        while(j < right.length) {
            merged[k][0] = right[j][0];
            merged[k][1] = right[j][1];
            ++j;
            ++k;
        }

        return merged;
    }
}
