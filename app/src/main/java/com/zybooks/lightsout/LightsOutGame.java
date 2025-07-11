package com.zybooks.lightsout;

import java.util.Random;

public class LightsOutGame {

    public static final int GRID_SIZE = 3;              // sets the game board size to 3x3 (Constant)

    private final boolean[][] mLightsGrid;              // Lights that make up the grid, 2D boolean array, stores state of each light where true = light on & false = light off


    public LightsOutGame() {                            // Constructor: when new game created, initializes the grid 3x3 of false
        mLightsGrid = new boolean[GRID_SIZE][GRID_SIZE];
    }

    public void newGame() {                             // Start new game: creates a Random generator for random booleans
        Random randomNumGenerator = new Random();
        for (int row = 0; row < GRID_SIZE; row++) {     // fills each cell with random true or false, every new game = unique light pattern
            for (int col = 0; col < GRID_SIZE; col++) {
                mLightsGrid[row][col] = randomNumGenerator.nextBoolean();
            }
        }
    }

    public boolean isLightOn(int row, int col) {        // Check Light Status: returns true if light at that position ON, false if OFF
        return mLightsGrid[row][col];
    }

    public void selectLight(int row, int col) {         // Toggle Light: simulates tap/click on light, toggles it and its neighbors (up/down/left/right)
        mLightsGrid[row][col] = !mLightsGrid[row][col];                 // toggles the selected light
        if (row > 0) {                                                  // if there is a light above, toggle it
            mLightsGrid[row - 1][col] = !mLightsGrid[row - 1][col];
        }
        if (row < GRID_SIZE - 1) {                                      // if there is a light below, toggle it
            mLightsGrid[row + 1][col] = !mLightsGrid[row +1][col];
        }
        if (col > 0) {                                                  // if there is a light left, toggle it
            mLightsGrid[row][col - 1] = !mLightsGrid[row][col - 1];
        }
        if (col < GRID_SIZE - 1) {                                      // if there is a light right, toggle it
            mLightsGrid[row][col + 1] = !mLightsGrid[row][col + 1];
        }
    }

    public boolean isGameOver() {               // loops through every cell, if any are ON the game is not over, all off = game over (You won)
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (mLightsGrid[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void turnAllLightsOff() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                mLightsGrid[row][col] = false;
            }
        }
    }


}
