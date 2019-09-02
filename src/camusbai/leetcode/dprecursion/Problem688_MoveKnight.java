package camusbai.leetcode.dprecursion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Problem688_MoveKnight {
    String st = "{\"name\":\"King\", \"alias\":\"Ominous\"}";

    public static void main(String[] args) {
//        System.out.println(new Problem688_MoveKnight().knightProbability(3, 2, 0, 0));
        System.out.println(new Problem688_MoveKnight().knightProbability(8, 20, 6, 4));
    }

    public double knightProbability(int N, int K, int r, int c) {
        int[][] shifts = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

//        int[] inBoardCnt = new int[]{0};
//        movePieceRecur(r, c, shifts, N, K, inBoardCnt);

        int inBoardCnt = movePieceIter(r, c, shifts, N, K);

        Double divisor = Math.pow(8, K);
        return inBoardCnt / divisor;

    }

    private void movePieceRecur(int r, int c, int[][] shifts, int N, int K, int[] inBoardCnt) {
        if (K == 0) {
            inBoardCnt[0]++;
            return;
        }

        for (int i = 0; i < shifts.length; i++) {
            int nr = shifts[i][0] + r;
            int nc = shifts[i][1] + c;

            if (nr > -1 && nr < N && nc > -1 && nc < N) {
                int nk = K - 1;
                movePieceRecur(nr, nc, shifts, N, nk, inBoardCnt);
                //TODO below will generate abnormal behavior, investigate WHY!
//                movePieceRecur(nr, nc, shifts, N, --K, inBoardCnt);
            }
        }
    }

    private int movePieceIter(int r, int c, int[][] shifts, int N, int K) {
        Stack<Coordinate> stack = new Stack<>();

        stack.push(new Coordinate(r, c, 0));
        int inBoardCnt = 0;

        Map<Coordinate, List<Coordinate>> validNeighbor = new HashMap<>();

        while (!stack.isEmpty()) {
            Coordinate co = stack.pop();
            if (co.depth < K) {
                for (int i = 0; i < shifts.length; i++) {
                    int nr = shifts[i][0] + co.row;
                    int nc = shifts[i][1] + co.col;

                    if (nr > -1 && nr < N && nc > -1 && nc < N) {
                        int depth = co.depth + 1;
                        stack.push(new Coordinate(nr, nc, depth));
                    }
                }

            } else {
                inBoardCnt++;
            }
        }

        return inBoardCnt;
    }

    static class Coordinate {
        int row, col;
        int depth;

        Coordinate(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }


    }
}
