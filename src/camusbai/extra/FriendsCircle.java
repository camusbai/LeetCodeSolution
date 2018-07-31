package camusbai.extra;

import java.security.InvalidParameterException;

/**
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature, i.e., if A is friend of B and B is friend of C, then A is also friend of C.
 * A friend circle is a group of students who are directly or indirectly friends.
 * You are given a N×N−matrix M which consists of characters Y or N.
 * If M[i][j]=Y, then ith and jth students are friends with each other, otherwise not.
 * You have to print the total number of friend circles in the class
 */
public class FriendsCircle {
    public static int countCircles(String[] relationMatrix) {
        if(relationMatrix==null)
            return 0;

        int count = 0;
        int size = relationMatrix.length;
        boolean[] visited = new boolean[size];
        for (int x = 0; x < size - 1; x++) {
            if (visited[x] == false) {
                char[] rowX = relationMatrix[x].toCharArray();
                if(rowX.length!=size)
                    throw new InvalidParameterException("input relationMatrix isn't N*N matrix");
                boolean circleExists = false;
                for (int y = x + 1; y < size - 1; y++) {
                    if(rowX[y]=='Y'){
                        circleExists = true;
                        visited[y] = true;
                    }
                }
                if(circleExists)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] matrix = {"YYNN","YYYN","NYYN","NNNY"};
        String[] m0 = new String[0];
        System.out.println(countCircles(matrix));
    }
}
