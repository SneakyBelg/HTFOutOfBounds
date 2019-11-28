package edu.ap.matthias_verschorren.htf1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseDecoder {
    private static final Map<String, Character> morseAlphabet = new HashMap<>();
    
    static {
        morseAlphabet.put(".-", 'a');
        morseAlphabet.put("-...", 'b');
        morseAlphabet.put("-.-.", 'c');
        morseAlphabet.put("-..", 'd');
        morseAlphabet.put(".", 'e');
        morseAlphabet.put("..-.", 'f');
        morseAlphabet.put("--.", 'g');
        morseAlphabet.put("....", 'h');
        morseAlphabet.put("..", 'i');
        morseAlphabet.put(".---", 'j');
        morseAlphabet.put("-.-", 'k');
        morseAlphabet.put(".-..", 'l');
        morseAlphabet.put("--", 'm');
        morseAlphabet.put("-.", 'n');
        morseAlphabet.put("---", 'o');
        morseAlphabet.put(".--.", 'p');
        morseAlphabet.put("--.-", 'q');
        morseAlphabet.put(".-.", 'r');
        morseAlphabet.put("...", 's');
        morseAlphabet.put("-", 't');
        morseAlphabet.put("..-", 'u');
        morseAlphabet.put("...-", 'v');
        morseAlphabet.put(".--", 'w');
        morseAlphabet.put("-..-", 'x');
        morseAlphabet.put("-.--", 'y');
        morseAlphabet.put("--..", 'z');
        morseAlphabet.put("-----", '0');
        morseAlphabet.put(".----", '1');
        morseAlphabet.put("..---", '2');
        morseAlphabet.put("...--", '3');
        morseAlphabet.put("....-", '4');
        morseAlphabet.put(".....", '5');
        morseAlphabet.put("-....", '6');
        morseAlphabet.put("--...", '7');
        morseAlphabet.put("---..", '8');
        morseAlphabet.put("----.", '9');
    }
    
    public static String decodeMorseString(String morseString) {
        StringBuilder decoded = new StringBuilder();

        String[] words = morseString.split("\\s{2}");
        for (String word : words) {
            decoded.append(' ');
            String[] letters = word.split("\\s");
            for (String letter : letters) {
                decoded.append(morseAlphabet.get(letter));
            }
        }

        return decoded.substring(1);
    }
}
