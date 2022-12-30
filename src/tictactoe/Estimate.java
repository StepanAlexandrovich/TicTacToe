package tictactoe;

import javax.swing.JButton;

public class Estimate {
    private Matrix matrix;
    private int[] plus = new int[]{0,1,5,25*2,125*3,625*4};
    private int[] minus = new int[]{0,2,10,50*2,250*3,1250*4};

    int process(Matrix matrix,String symbol1,String symbol2){
        this.matrix = matrix;

        int score = 0;
        for(int i = 0;i<matrix.getLength();i++){

            for(int a=-1;a<=1;a++){
                for(int b=-1;b<=1;b++){
                    if(!(a==0&&b==0)){
                        int x = matrix.getX(i);
                        int y = matrix.getY(i);
                        score+=plus[ score(x,y,a,b,symbol1) ] - minus[ score(x,y,a,b,symbol2) ];
                    }
                }
            }
        }

        return score;
    }

    private int score(int x,int y,int a,int b,String symbol){
        int score = 0;
        for(int i = 0;i<PS.lengthVector;i++ ) {
            int newX = x + a * i;
            int newY = y + b * i;

            if (!matrix.range(newX, newY) ||
                    (matrix.getSymbol(newX, newY) != symbol &&
                            matrix.getSymbol(newX, newY) != PS.symbolEmpty)) {
                return 0;
            } else if (matrix.getSymbol(newX, newY).equals(symbol)) { score++; }

        }
        return score;
    }

}
