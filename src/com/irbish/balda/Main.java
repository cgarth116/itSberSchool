package com.irbish.balda;

import java.io.*;
import java.util.*;

public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    //help metod's
    private static boolean  wordCheckByLetterOccurrence(String userWord, LinkedList<Character> lettersForUse){
        var userWordForLetter = userWord.toCharArray();
        LinkedList<Character> tmp = (LinkedList<Character>) lettersForUse.clone();

        for (Character letter : userWordForLetter){
            if(!tmp.contains(letter)){
                return false;
            }
            tmp.remove(letter);
        }
        return true;
    }
    private static boolean  checkInProgramDictionary(String userWord, HashMap dictionary) {
        if (!dictionary.containsKey(userWord)) {
            return false;
        }
        return true;
    }
    private static int      enterCountPlayers(int countPlayers){
        var in = new Scanner(System.in);
        while (countPlayers == 0) {
            System.out.print("Введите кол-во игроков(1-10): ");
            countPlayers = in.nextInt();
            if (countPlayers <= 0 || countPlayers > 10){
                countPlayers = 0;
            }
        }
        return countPlayers;
    }
    private static String   enterWord(String message){
        var in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    private static void     resultGame(Map<Integer, LinkedHashSet<String>> wordHistoryAll){
        Queue<Integer> whoWin = new LinkedList();                                   //list of winners
        var y = wordHistoryAll.get(1).size();
        var countPlayers = wordHistoryAll.size();
        System.out.println(ANSI_PURPLE + "\nРезультаты игры:\n" + ANSI_RESET);
        for(int i = 1; i <= countPlayers; i++){
            int countWord = wordHistoryAll.get(i).size();
            System.out.println("Игроком №" + i + " было составлено " + countWord + " слов(а)\n");
            if (countWord != 0) {
                System.out.println("Слова: \"" + String.join("\", \"", wordHistoryAll.get(i)) + "\"\n");
                if (countWord > y) {
                    while (whoWin.poll() != null) ;
                    y = countWord;
                    whoWin.offer(i);
                } else {
                    if (countWord == y) {
                        whoWin.offer(i);
                    }
                }
            }
        }
        while(!whoWin.isEmpty()) {
            System.out.println(ANSI_PURPLE + "Поздравляем игрока №" + whoWin.poll() + " с победой!!!" + ANSI_RESET);
        }
    }
    private static HashMap  addWordInDictionary(BufferedReader reader, HashMap dictionary) throws IOException {
        try{
            String str = reader.readLine();
            while (str != null) {
                dictionary.put(str, 0);
                str = reader.readLine();
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return dictionary;
    }
    private static HashMap  loadDictionary() throws IOException {
        var dictionary = new HashMap<String, Integer>();
        File dictionaryRus = new File("./src/com/irbish/balda/russianDictionary.txt");
        File dictionaryEng = new File("./src/com/irbish/balda/englishDictionary.txt");

        try {
            //add russian dictionary
            FileReader frRus = new FileReader(dictionaryRus);
            BufferedReader readerRus = new BufferedReader(frRus);
            dictionary = addWordInDictionary(readerRus, dictionary);

            //add english dictionary
            FileReader frEng = new FileReader(dictionaryEng);
            BufferedReader readerEng = new BufferedReader(frEng);
            dictionary = addWordInDictionary(readerEng, dictionary);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return dictionary;
    }
    private static void     fillingLettersToCompose(LinkedList<Character> lettersForUse, String inputWord){
        for(char ch : inputWord.toCharArray()){
            lettersForUse.add(ch);
        }
    }

    public static void main(String[] args) throws IOException {
        int y = 0;
        var lettersForUse = new LinkedList<Character>();                            //letters to compose word's
        var wordHistoryAll = new HashMap<Integer, LinkedHashSet<String>>();         //dictionary of entered words
        var dictionary = new HashMap<String, Integer>();                            //rus-eng dictionary
        Queue<Integer> playerQueue = new LinkedList();                              //queue for players

        //add rus-eng dictionary
        try {
            dictionary = loadDictionary();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        //input initial conditions
        var countPlayers = enterCountPlayers(0);
        var inputWord = enterWord("Введите начальное слово:");

        for(int i = 1; i <= countPlayers; i++){                                     //create queue players, history dic
            playerQueue.offer(i);
            wordHistoryAll.put(i, new LinkedHashSet());
        }
        Integer whoseMove = playerQueue.poll();                                     //get first player

        fillingLettersToCompose(lettersForUse, inputWord);                          //filling letters to compose word's

        //let's play now
        while(whoseMove != null) {
            var userWord = enterWord("\nХод игрока №" + whoseMove + ":");

            while (!userWord.isEmpty() || !userWord.isBlank()) {
                if (!wordCheckByLetterOccurrence(userWord, lettersForUse) ||
                        !checkInProgramDictionary(userWord, dictionary)) {
                            System.out.println(ANSI_RED + "Слово \"" + userWord +
                                                "\" не подходит\\не найдено в словаре программы" + ANSI_RESET);
                            userWord = enterWord(ANSI_YELLOW + "Повторный ход игрока №" + whoseMove + ":" + ANSI_RESET);
                        continue;
                }

                y = 1;
                while(y <= countPlayers ){
                    if (wordHistoryAll.get(y).contains(userWord)) {
                        System.out.println(ANSI_RED + "Слово \"" + userWord + "\" уже было" + ANSI_RESET);
                        userWord = enterWord(ANSI_YELLOW + "Повторный ход игрока №" + whoseMove + ":" + ANSI_RESET);
                        break;
                    }
                    y++;
                }
                if (y <= countPlayers){
                    continue;
                }
                wordHistoryAll.get(whoseMove).add(userWord);
                System.out.println("Игрок №" + whoseMove + " : Счет увеличен на +1(Итого: " +
                                    wordHistoryAll.get(whoseMove).size() + ")\n");
                playerQueue.offer(whoseMove);                                       //put player in queue for next move
                whoseMove = playerQueue.poll();                                     //get player from queue who must move

                userWord = enterWord("Ход игрока №" + whoseMove + ":");
            }
            System.out.println(ANSI_BLUE + "Игрок №" + whoseMove + " выбывает из игры (((" + ANSI_RESET);
            whoseMove = playerQueue.poll();
        }

        //let's see result
        resultGame(wordHistoryAll);
    }
}
