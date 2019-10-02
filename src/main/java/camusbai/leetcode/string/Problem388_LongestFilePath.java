package camusbai.leetcode.string;

import java.util.Stack;

/**
 * "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents
 * <p>
 * dir
 * subdir1
 * subdir2
 * file.ext
 */
public class Problem388_LongestFilePath {
    public static void main(String[] args) {
//        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String input = "dir\n    file.txt";
        System.out.println(new Problem388_LongestFilePath().lengthLongestPath(input));

    }

    public int lengthLongestPath(String input) {
        if (input == null || input.length() < 1) {
            return 0;
        }

        char[] characters = input.toCharArray();
        int i = 0;
        int prevLevel = 0;
        int wordLen = 0;
        int maxLen = 0;
        boolean foundFile = false;
        Stack<Integer> pathLengths = new Stack<>();
        pathLengths.push(0);

        while (i < characters.length) {
            char c = characters[i];
            if (c == '\n') {
                int pathLen = pathLengths.peek() + wordLen + 1;
                wordLen = 0;
                pathLengths.push(pathLen);
                i++;
                if (foundFile) {
                    maxLen = Math.max(maxLen, pathLengths.peek() - 1);
                    foundFile = false;
                }
            } else if (c == '\t') {
                int level = 0;
                while (i < characters.length && characters[i] == '\t') {
                    level++;
                    i++;
                }

                for (int j = 0; j <= (prevLevel - level); j++) {
                    pathLengths.pop();
                }
                prevLevel = level;
            } else {
                if (c == ' ' && characters[i - 1] == '\n') {
                    if (i + 3 < characters.length && characters[i + 1] == ' ' && characters[i + 2] == ' ' && characters[i + 3] == ' ') {
                        i = i + 4;
                        continue;
                    }
                }

                if (c == '.') {
                    foundFile = true;
                }

                i++;
                wordLen++;
            }

        }

        if (wordLen != 0 && foundFile) {
            int pathLen = pathLengths.peek() + wordLen;
            maxLen = Math.max(maxLen, pathLen);
        }

        return maxLen;
    }
}
