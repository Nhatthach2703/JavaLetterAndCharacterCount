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
        super("PROGRAMMING", mc);
        l = new Library();
        str = l.getString("Input string: ");
    }
    
    public void execute(int n) {
        count(str);
        switch (n) {
            case 1: // Print Character count
                System.out.println(letterCounter);
                break;
            case 2: // Print Letter count
                System.out.println(charCounter);
                break;
            case 3:
                System.exit(0);
        }
    }

    public void count(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isAllLetters(token)) {
                if (!letterCounter.containsKey(token)) {
                    letterCounter.put(token, 1);
                } else {
                    letterCounter.put(token, letterCounter.get(token) + 1);
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
}