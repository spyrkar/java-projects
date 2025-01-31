package gr.aueb.cf.project;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        File inFile = new File("C:/Users/User/CodingFactory/JAVA/numbers.txt");
        File outFile = new File("C:/Users/User/CodingFactory/JAVA/combinations.txt");
        int n = 6;
        int[] row = new int[6];
        int count = 0;
        int THRESHOLD = 4;

        try {
            label145: {
                try (Scanner sc = new Scanner(inFile)) {
                    try (PrintStream ps = new PrintStream(outFile)) {
                        ArrayList<Integer> numbers = new ArrayList();

                        while(sc.hasNextInt()) {
                            int num = sc.nextInt();
                            if (num >= 1 && num <= 49) {
                                numbers.add(num);
                                ++count;
                            } else {
                                System.err.println("Number " + num + " is not between 1 and 49");
                            }
                        }

                        if (count < 6) {
                            System.err.println("The file must contain at least 6 numbers");
                            return;
                        }

                        if (count <= 49) {
                            Integer[] sortedArray = (Integer[])numbers.toArray(new Integer[0]);
                            Arrays.sort(sortedArray);

                            for(int i = 0; i <= numbers.size() - n; ++i) {
                                for(int j = i + 1; j <= numbers.size() - n + 1; ++j) {
                                    for(int k = j + 1; k <= numbers.size() - n + 2; ++k) {
                                        for(int l = k + 1; l <= numbers.size() - n + 3; ++l) {
                                            for(int x = l + 1; x <= numbers.size() - n + 4; ++x) {
                                                for(int y = x + 1; y < numbers.size(); ++y) {
                                                    row[0] = (Integer)numbers.get(i);
                                                    row[1] = (Integer)numbers.get(j);
                                                    row[2] = (Integer)numbers.get(k);
                                                    row[3] = (Integer)numbers.get(l);
                                                    row[4] = (Integer)numbers.get(x);
                                                    row[5] = (Integer)numbers.get(y);
                                                    if (!isEven(row, 4) && !isOdd(row, 4) && !moreThanTwoConsecutive(row) && !theSameEnding(row, 4) && !isInSameTen(row, 4)) {
                                                        ps.printf("%d\t%d\t%d\t%d\t%d\t%d\n", numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(l), numbers.get(x), numbers.get(y));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            break label145;
                        }

                        System.err.println("The file must contain at most 49 numbers");
                    }
                }

                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean isEven(int[] arr, int threshold) {
        long evenCount = 0L;
        evenCount = Arrays.stream(arr).filter((num) -> num % 2 == 0).count();
        return evenCount >= (long)threshold;
    }

    public static boolean isOdd(int[] arr, int threshold) {
        long oddsCount = 0L;
        oddsCount = Arrays.stream(arr).filter((num) -> num % 2 != 0).count();
        return oddsCount >= (long)threshold;
    }

    public static boolean moreThanTwoConsecutive(int[] arr) {
        int consecutiveCount = 0;

        for(int i = 0; i <= 3; ++i) {
            if (arr[i] == arr[i + 1] - 1 && arr[i] == arr[i + 2] - 2) {
                ++consecutiveCount;
                break;
            }
        }

        return consecutiveCount >= 1;
    }

    public static boolean theSameEnding(int[] arr, int threshold) {
        int[] endings = new int[10];

        for(int num : arr) {
            ++endings[num % 10];
        }

        return Arrays.stream(endings).anyMatch((e) -> e >= 4);
    }

    public static boolean isInSameTen(int[] arr, int threshold) {
        int[] ten = new int[5];

        for(int num : arr) {
            ++ten[num / 10];
        }

        return Arrays.stream(ten).anyMatch((t) -> t >= threshold);
    }
}

