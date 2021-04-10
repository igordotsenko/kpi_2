package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ChessASearch {
    static final int E = -1; // Empty
    static final int P = 0; // Pawn
    static final int K = 1; // Knight
    
    private static int[][] desk = new int[][] {
      // a  b  c  d  e  f  g  h
        {E, E, E, E, E, E, E, E}, // 8
        {E, E, E, E, P, P, P, E}, // 7
        {E, E, E, E, P, E, P, E}, // 6
        {E, E, E, E, P, P, P, E}, // 5
        {E, P, P, P, E, E, E, E}, // 4
        {E, P, E, P, E, E, E, E}, // 3
        {E, P, P, P, E, E, E, E}, // 2
        {E, E, E, E, E, E, E, E}, // 1
    };

    public static void main(String[] args) {
        int[] knightPosition = getPosition('f', 7);
        placeKnight(desk, knightPosition);
        Set<State> uniqueStates = new HashSet<>();
        
        State initialState = new State(
            State.copyDesk(desk), knightPosition, 0, pawnsLeft(desk), null
        );
        PriorityQueue<State> queue = new PriorityQueue<>(initialState.makeMoves());
        uniqueStates.add(initialState);

        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.isEnd()) {
                System.out.println("Done in " + state.movesMade + " moves");
                System.out.println("Moves list: " + String.join(",", state.getAllMovesMade()));
                return;
            }
            for (State s : state.makeMoves()) {
                if (uniqueStates.add(s)) queue.add(s);
            }
        }
    }
    
    private static void placeKnight(int[][] desk, int[] knightPosition) {
        desk[knightPosition[0]][knightPosition[1]] = K;
    }
    
    static int[] getPosition(char vert, int hor) {
        return new int[] { 8-hor, vert -'a'};
    }
    
    private static int pawnsLeft(int[][] desk) {
        return (int) Stream.of(desk)
            .flatMapToInt(IntStream::of)
            .filter(i -> i == P)
            .count();
    }
    
    
    
    // We need to know how many moves made, how many pawns are still on the dest and if we can beat the pawn with the next move
    public static class State implements Comparable<State> {
        private static int[][] knightMoves = new int[][] {
            {1, 2},  {-1, 2},
            {1, -2}, {-1, -2},
            {2, 1},  {-2, 1},
            {2, -1}, {-2, -1},
        };
        
        final int[][] desk;
        final int[] knightPosition;
        final int movesMade;
        final int pawnsLeft;
        final boolean canBeatPawn;
        final State prevState;

        public State(int[][] desk, int[] knightPosition, int movesMade, int pawnsLeft,
            State prevState) {
            this.desk = desk;
            this.knightPosition = Arrays.copyOf(knightPosition, knightPosition.length);
            this.movesMade = movesMade;
            this.pawnsLeft = pawnsLeft;
            this.prevState = prevState;
            this.canBeatPawn = canBeatPawn(desk, knightPosition);
        }

        public List<State> makeMoves() {
            // Don't forget to replace knight with an empty space
            List<State> newStates = new ArrayList<>();
            
            for (int[] move : knightMoves) {
                int newRow = knightPosition[0] + move[0];
                int newCol = knightPosition[1] + move[1];
                
                if (isDeskField(newCol) && isDeskField(newRow) && !isPrevPosition(prevState, newRow, newCol)) {
                    int[][] newDesk = copyDesk(desk);
                    int newPawnsLeft = isPawn(desk, newRow, newCol) ? pawnsLeft-1 : pawnsLeft;
                    int[] newKnightPosition = new int[] {newRow, newCol};
                    moveKnight(newDesk, knightPosition, newRow, newCol);
                    State nextState = new State(newDesk, newKnightPosition, movesMade+1, newPawnsLeft, this);
                    newStates.add(nextState);
                }
            }
            
            return newStates;
        }

        public boolean isEnd() {
            return pawnsLeft == 0;
        }

        public List<String> getAllMovesMade() {
            Stack<String> movesReversed = new Stack<>();
            State s = this;
            while (s != null) {
                movesReversed.add(moveString(s.knightPosition));
                s = s.prevState;
            }

            List<String> moves = new ArrayList<>(movesReversed.size());
            movesReversed.pop(); // Delete the initial position
            while (!movesReversed.empty()) {
                moves.add(movesReversed.pop());
            }
            return moves;
        }

        private boolean isPrevPosition(State prevState, int newRow, int newCol) {
            return prevState != null 
                && prevState.knightPosition[0] == newRow 
                && prevState.knightPosition[1] == newCol;
        }
        
        private void moveKnight(int[][] newDesk, int[] currentKnightPosition, int newRow, int newCol) {
            newDesk[currentKnightPosition[0]][currentKnightPosition[1]] = E;
            newDesk[newRow][newCol] = K;
        }

        static String moveString(int[] knightPosition) {
            return "" + ((char) (knightPosition[1] +'a')) +(8-knightPosition[0]) ;
        }

        private static int[][] copyDesk(int[][] src) {
            return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
        }

        static boolean canBeatPawn(int[][] desk, int[] knightPosition) {
            for (int[] move : knightMoves) {
                int newRow = knightPosition[0] + move[0];
                int newCol = knightPosition[1] + move[1];
                if (isDeskField(newCol) && isDeskField(newRow) && isPawn(desk, newRow, newCol)) { 
                    return true;
                }
            }
            return false;
        }

        static private boolean isPawn(int[][] desk, int row, int col) {
            return desk[row][col] == P;
        }

        static private boolean isDeskField(int i) {
            return i >= 0 && i <= 7;
        }


        @Override
        public int compareTo(State o) {
            // -1 means higher priority
            int pawnsCmp = Integer.compare(pawnsLeft, o.pawnsLeft);
            if (pawnsCmp != 0) return pawnsCmp;
            
            int movesCmp = Integer.compare(movesMade, o.movesMade);
            if (movesCmp != 0) return movesCmp;
            
            
            return Boolean.compare(canBeatPawn, o.canBeatPawn);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            State state = (State) o;

            return Arrays.deepEquals(desk, state.desk);
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(desk);
        }
    }
}
