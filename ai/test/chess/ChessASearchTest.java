package chess;

import static chess.ChessASearch.E;
import static chess.ChessASearch.K;
import static chess.ChessASearch.P;
import static chess.ChessASearch.getPosition;
import static org.junit.Assert.*;

import chess.ChessASearch.State;
import org.junit.Test;

public class ChessASearchTest {
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

    @Test
    public void canBeatPawn() {
        int[][] desk = new int[][] {
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
        assertTrue(State.canBeatPawn(desk,  getPosition('a', 1)));
        assertTrue(State.canBeatPawn(desk,  getPosition('a', 2)));
        assertTrue(State.canBeatPawn(desk,  getPosition('b', 1)));
        assertTrue(State.canBeatPawn(desk,  getPosition('h', 8)));
        assertTrue(State.canBeatPawn(desk,  getPosition('c', 7)));
        
        assertFalse(State.canBeatPawn(desk,  getPosition('a', 8)));
        assertFalse(State.canBeatPawn(desk,  getPosition('h', 1)));
        assertFalse(State.canBeatPawn(desk,  getPosition('g', 2)));
    }

    @Test
    public void moveString() {
        assertEquals("a8", State.moveString(new int[] { 0, 0 }));
        assertEquals("a1", State.moveString(new int[] { 7, 0 }));
        assertEquals("h1", State.moveString(new int[] { 7, 7 }));
        assertEquals("h8", State.moveString(new int[] { 0, 7 }));
        assertEquals("e4", State.moveString(new int[] { 4, 4 }));
    }
}