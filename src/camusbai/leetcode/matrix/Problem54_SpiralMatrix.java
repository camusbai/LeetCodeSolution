package camusbai.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem54_SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix1 = {{0}};
        List<Integer> result = new Problem54_SpiralMatrix().spiralOrder(matrix1);

        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length==0) {
            return result;
        }

        Visitor visitor = new Visitor(matrix);
        while (visitor.hasNext()) {
            result.add(visitor.move());
        }

        result.add(visitor.move());

        return result;
    }

    public static class Visitor {
        int[][] matrix;
        boolean[][] visited;
        int rowSize, colSize;
        Position currPos;
        Direction direction;

        public Visitor(int[][] matrix) {
            this.matrix = matrix;
            this.rowSize = matrix.length;
            this.colSize = matrix[0].length;
            visited = new boolean[rowSize][colSize];
            currPos = new Position(0, 0);
            direction = Direction.RIGHT;
        }

        public boolean hasNext() {
            switch (direction) {
                case RIGHT:
                    if (currPos.col == colSize - 1 || visited[currPos.row][currPos.col + 1]) {
                        direction = Direction.DOWN;
                        return currPos.checkDownUnvisited(visited);
                    } else {
                        return currPos.checkRightUnvisited(visited);
                    }
                case DOWN:
                    if (currPos.row == rowSize - 1 || visited[currPos.row + 1][currPos.col]) {
                        direction = Direction.LEFT;
                        return currPos.checkLeftUnvisited(visited);
                    } else {
                        return currPos.checkDownUnvisited(visited);
                    }
                case LEFT:
                    if (currPos.col == 0 || visited[currPos.row][currPos.col - 1]) {
                        direction = Direction.UP;
                        return currPos.checkUpUnvisited(visited);
                    } else {
                        return currPos.checkLeftUnvisited(visited);
                    }
                case UP:
                    if (currPos.row == 0 || visited[currPos.row -1][currPos.col]) {
                        direction = Direction.RIGHT;
                        return currPos.checkRightUnvisited(visited);
                    } else {
                        return currPos.checkUpUnvisited(visited);
                    }
            }

            return false;
        }

        /**
         * move to next pos and return previous pos value
         */
        public int move() {
            int num = matrix[currPos.row][currPos.col];
            visited[currPos.row][currPos.col] = true;
            switch (direction) {
                case RIGHT:
                    currPos.col++;
                    break;
                case DOWN:
                    currPos.row++;
                    break;
                case LEFT:
                    currPos.col--;
                    break;
                case UP:
                    currPos.row--;
                    break;
            }
            return num;
        }

        private static class Position{
            int row, col;

            Position(int row, int col) {
                this.row = row;
                this.col = col;
            }

            boolean checkRightUnvisited(boolean[][] visited) {
                if (col < visited[0].length - 1) {
                    return !visited[row][col + 1];
                } else {
                    return false;
                }
            }

            boolean checkLeftUnvisited(boolean[][] visited) {
                if (col >0) {
                    return !visited[row][col - 1];
                } else {
                    return false;
                }
            }

            boolean checkUpUnvisited(boolean[][] visited) {
                if (row > 0) {
                    return !visited[row-1][col];
                } else {
                    return false;
                }
            }

            boolean checkDownUnvisited(boolean[][] visited) {
                if (row < visited.length - 1) {
                    return !visited[row + 1][col];
                } else {
                    return false;
                }
            }

        }

        private enum Direction{
            RIGHT,
            DOWN,
            LEFT,
            UP
        }
    }
}
