package rocks.zipcodewilmington.tictactoe;

import jdk.swing.interop.SwingInterOpUtils;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Boolean xIsWinning = false;
    Boolean oIsWinning = false;
    Boolean isTie = true;
    String winnerName = "";
    Character[][] matrix = new Character[3][3];

    public Board(Character[][] matrix) {
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }
    public Boolean isInFavorOfX() {
        getWinner();
        return xIsWinning;
    }

    public Boolean isInFavorOfO() {
        getWinner();
        return oIsWinning;
    }

    public Boolean isTie() {
        getWinner();
        return isTie;
    }

    public String getWinner() {
        boolean diagWin = false;
        if(matrix[1][1].equals(matrix[0][0]) && matrix[1][1].equals(matrix[2][2])){
            if(matrix[1][1].toString().equalsIgnoreCase("X")){
                xIsWinning();
                diagWin = true;
            }else if(matrix[1][1].toString().equalsIgnoreCase("O")){
                oIsWinning();
                diagWin = true;
            }
        }else{
            isTie = true;
        }
        if(!diagWin) {
            if (matrix[1][1].equals(matrix[0][2]) && matrix[1][1].equals(matrix[2][0])) {
                if (matrix[1][1].toString().equalsIgnoreCase("X")) {
                    xIsWinning();
                    diagWin = true;
                } else if (matrix[1][1].toString().equalsIgnoreCase("O")) {
                    oIsWinning();
                    diagWin = true;
                }
            } else {
                isTie = true;
            }
        }
        for(int i = 0; i<3; i++) {
            if(diagWin){
                break;
            }

            if(matrix[i][0].equals(matrix[i][1]) && matrix[i][0].equals(matrix[i][2])){
                if(matrix[i][0].toString().equalsIgnoreCase("x")){
                    xIsWinning();
                    break;
                }else if(matrix[i][0].toString().equalsIgnoreCase("o")){
                    oIsWinning();
                    break;
                }
            }else{
                isTie = true;
            }
            if(matrix[0][i].equals(matrix[1][i]) && matrix[0][i].equals(matrix[2][i])){
                if(matrix[0][i].toString().equalsIgnoreCase("x")){
                    xIsWinning();
                    break;
                }else if(matrix[0][i].toString().equalsIgnoreCase("o")){
                    oIsWinning();
                    break;
                }
            }else{
                isTie = true;
            }
        }
        return winnerName;
    }

    public String xIsWinning(){
        xIsWinning = true;
        oIsWinning = false;
        winnerName  = "X";
        isTie = false;
        return winnerName;
    }

    public String oIsWinning(){
        oIsWinning = true;
        xIsWinning = false;
        winnerName = "O";
        isTie = false;
        return winnerName;
    }
}

