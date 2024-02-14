package src;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader inputFile = new FileReader("input.txt");
            FileWriter outputFile = new FileWriter("output.txt");
            BufferedReader reader = new BufferedReader(inputFile);
            BufferedWriter writer = new BufferedWriter(outputFile);

            String line;
            while ((line = reader.readLine()) != null) {

                String[] numbers = line.trim().split("\\s+");

                for (String numberStr : numbers) {
                    int number = Integer.parseInt(numberStr);

                    if (isPrime(number)) {
                        writer.write(number + " is prime\n");
                    } else {
                        writer.write(number + " is not prime\n");
                    }
                }
            }

            reader.close();
            writer.close();
            inputFile.close();
            outputFile.close();

            System.out.println("Output successfully written to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}