package camusbai.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1178_numValidWordForPuzzle {
    public static void main(String[] args) {
        P1178_numValidWordForPuzzle mObj = new P1178_numValidWordForPuzzle();
        String[] words = new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        List<Integer> result = mObj.findNumOfValidWords(words, puzzles);
        System.out.println(result);
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length < 1 || puzzles == null || puzzles.length < 1) {
            return result;
        }

        int[] wordsBitMask = convertToBitMask(words);
        int[] puzzleBitMasks = convertToBitMask(puzzles);

        int[] wordsCharCount = new int[words.length];
        Arrays.fill(wordsCharCount, -1);

        for (int i = 0; i < puzzleBitMasks.length; i++) {
            int puzzleBitMask = puzzleBitMasks[i];
            if (puzzleBitMask == -1) {
                result.add(0);
                continue;
            }
            int cnt = 0;
            int puzzleFirstCharMask = bitMaskOfWord(puzzles[i], 1);
            for (int j = 0; j < wordsBitMask.length; j++) {
                int wordBitMask = wordsBitMask[j];
                if (wordBitMask == -1) {
                    continue;
                }

                wordsCharCount[j] = wordsCharCount[j] == -1 ? countOneInBitMask(wordBitMask) : wordsCharCount[j];
                if (wordsCharCount[j] > 7) {
                    continue;
                }

                boolean firstCharOfPuzzleExist = (puzzleFirstCharMask & wordBitMask) > 0;
                if (!firstCharOfPuzzleExist) {
                    continue;
                }

                boolean allCharOfWordExist = (puzzleBitMask | wordBitMask) == puzzleBitMask;
                if (allCharOfWordExist) {
                    cnt++;
                }
            }
            result.add(cnt);
        }
        return result;
    }

    private int[] convertToBitMask(String[] input) {
        if (input == null || input.length < 1) {
            return null;
        }

        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = bitMaskOfWord(input[i], input[i].length());
        }
        return result;
    }

    private int bitMaskOfWord(String lowercaseAlphabetOnly, int lengthLeftToRight) {
        if (lowercaseAlphabetOnly == null || lowercaseAlphabetOnly.length() < 1) {
            return -1;
        }

        int base = 0;
        for (char c : lowercaseAlphabetOnly.toCharArray()) {
            if (lengthLeftToRight < 1) {
                return base;
            }

            int bitNum = c - 'a';
            if (bitNum < 0 || bitNum > 25) {
                return -1;
            }
            int mask = 1 << bitNum;
            base = base | mask;
            lengthLeftToRight--;
        }

        return base;
    }

    private int countOneInBitMask(int wordMask) {
        int cnt = 0;
        while (wordMask > 0) {
            if ((wordMask & 1) == 1) {
                cnt++;
            }
            wordMask = wordMask >> 1;
        }
        return cnt;
    }
}