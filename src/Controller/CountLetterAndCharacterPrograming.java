/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Library;
import View.Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Xuan Vinh
 */
public class CountLetterAndCharacterPrograming extends Menu<String>{
    static String[] mc = {"Letter Count", "Character Count", "Exit"};
    private Map<Character, Integer> charCounter =  new HashMap<Character, Integer>();
    private Map<String, Integer> letterCounter = new HashMap<String, Integer>();
    String str;
    Library l;
    
    public CountLetterAndCharacterPrograming() {
        super("Count Menu", mc);
        l = new Library();
        str = l.getString("Input string: ");
        count(str);
    }
    
    public void execute(int n) {
        switch (n) {
            case 1: // Print Character count
                System.out.println(letterCounter);
                break;
            case 2: // Print Letter count
                System.out.println(charCounter);
                break;
            case 3: // Exit
                System.exit(0);
        }
    }

    public void count(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            String cleanToken = removeSpecialCharacters(token);
            if (isAllLetters(cleanToken)) {
                if (!letterCounter.containsKey(cleanToken)) {
                    letterCounter.put(cleanToken, 1);
                } else {
                    letterCounter.put(cleanToken, letterCounter.get(cleanToken) + 1);
                }
            }
        }
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (!charCounter.containsKey(ch)) {
                    charCounter.put(ch, 1);
                } else {
                    charCounter.put(ch, charCounter.get(ch) + 1);
                }
            }
        }
    }
    
    private boolean isAllLetters(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }
    
    private String removeSpecialCharacters(String str) {
        StringBuilder cleanToken = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch) || Character.isWhitespace(ch)) {
                cleanToken.append(ch);
            }
        }
        return cleanToken.toString();
    }
}