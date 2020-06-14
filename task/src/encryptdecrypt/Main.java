package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        String mode = "";
        String data = "";
        String in = "";
        String out = "";
        int key = 0;

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                case "-out":
                    out = args[i + 1];
                default:
                    System.out.println("Unexpected argument!");
            }
        }

        mode = mode.equals("") ? "enc" : mode;

        process(mode, key, data, in, out);

    }

    public static void encodeAndWriteIntoFile(String output, String file) {
        File outputFile = new File(file);
        try (PrintWriter printWriter = new PrintWriter(outputFile)) {
            printWriter.print(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void process(String mode, int key, String data, String in, String out) {
        String output;
        if (!data.equals("")) {
            output = doTheThing(mode, key, data);
            if (!out.equals("")) {
                encodeAndWriteIntoFile (output, out);
            }
            System.out.println(output);
        }
        if (!in.equals("")) {
            try {
                String input = readFileAsString(in);
                output = doTheThing(mode, key, input);

                if (!out.equals("")) {
                    encodeAndWriteIntoFile (output, out);
                    return;
                }
                System.out.println(output);

            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static String doTheThing(String mode, int key, String data) {
        switch (mode) {
            case "enc":
                return encrypt(data, key);
            case "dec":
                return decrypt(data, key);
            default:
                return "Unexpected mode";
        }
    }

    public static String encrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int ascii = (int) (input.charAt(i)) + key;
            output.append((char) (ascii));
        }
        return(output.toString());
    }

    public static String decrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int ascii = (int) (input.charAt(i)) - key;
            output.append((char) ascii);
        }
        return(output.toString());
    }

}