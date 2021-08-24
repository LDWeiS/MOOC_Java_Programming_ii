package ticTacToe;

import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {
    
    private boolean xTurn = true;
    private boolean gameWon = false;
    
    @Override
    public void start(Stage window){
        // Use borderpane layout for main window
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        // Describe turn
        Label turnInfo = new Label("Turn: X");
        turnInfo.setFont(Font.font("Monospaced", 40));
        
        // Game board
        GridPane gameBoard = new GridPane();
        gameBoard.setAlignment(Pos.CENTER);
        gameBoard.setVgap(10);
        gameBoard.setHgap(10);
        // gameBoard.setPadding(new Insets(10, 10, 10, 10));
        
        // Buttons
        Button[][] board = new Button[3][3]; // 3 by 3 array for buttons
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++){
                Button btn = new Button(" ");
                board[row][col] = btn;
                btn.setFont(Font.font("Monospaced", 40));
                gameBoard.add(btn, row, col);
                
                // TODO set button action
                btn.setOnMouseClicked((event) -> {
                    if (!btn.getText().contains(" ")) {
                        return;
                    }
                    
                    if (xTurn) {
                        btn.setText("X");
                        gameWon = checkState(board);
                        
                        if (gameWon) {
                            turnInfo.setText("The end!");
                            return;
                        }

                        xTurn = false;
                        turnInfo.setText("Turn: O");
                        
                    } else if (!xTurn) {
                        btn.setText("O");
                        gameWon = checkState(board);
                        
                        if (gameWon) {
                            turnInfo.setText("The end!");
                            return;
                        }                        
                        
                        xTurn = true;
                        turnInfo.setText("Turn: X");
                    }
                    
                    if (boardComplete(board)){
                        turnInfo.setText("The end!");
                        return;
                    }
                });
            }
        }
        
        // Set main window layout
        layout.setTop(turnInfo);
        layout.setCenter(gameBoard);
        
        //Display window
        Scene mainDisplay = new Scene(layout);
        
        window.setScene(mainDisplay);
        window.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
        System.out.println("Hello world!");
    }
    
    public boolean checkState(Button[][] board) {
        //Check vertical
        for (int col = 0; col < board[0].length; col++) {
            if (!board[0][col].getText().equals(" ")) {
                if (board[0][col].getText().equals(board[1][col].getText()) && board[0][col].getText().equals(board[2][col].getText())){
                    return true;
                }
            }
        }
        
        //Check horizontal
        for (int row = 0; row < board.length; row++) {
            if (!board[row][0].getText().equals(" ")) {
                if (board[row][0].getText().equals(board[row][1].getText()) && board[row][0].getText().equals(board[row][2].getText())){
                    return true;
                }
            }
        }
        
        if (!board[0][0].getText().equals(" ")) {
            if (board[0][0].getText().equals(board[1][1].getText()) && board[0][0].getText().equals(board[2][2].getText())){
                    return true;
            }
        }
        
        if (!board[2][0].getText().equals(" ")) {
            if (board[2][0].getText().equals(board[1][1].getText()) && board[2][0].getText().equals(board[0][2].getText())) {
                return true;
            }
        }

        return false;
    }
    
    public boolean boardComplete(Button[][] board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++){
                if (board[row][col].getText().equals(" ")){
                    return false;
                }
            }
        }
        
        return true;
    }

}
