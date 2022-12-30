
package tictactoe;


import java.util.ArrayList;

public class BestMoves {
    private Estimate estimate = new Estimate();
    private Field field = new Field();

    public int maxScore(Integer[] scores){
        int maxScore = -200000000;
        for(int i = 0;i<scores.length;i++){
            if(scores[i]!=null&&scores[i]>maxScore){
                maxScore = scores[i];
            }
        }
        return maxScore;
    }
    ArrayList<Integer> moves(Integer[] scores){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxScore = maxScore(scores);
        for(int i = 0;i<scores.length;i++){
            //if(scores[i]!=null&&scores[i]<=maxScore&&scores[i]>maxScore-5) {
            if(scores[i]!=null && scores[i]==maxScore) {
                moves.add(i);
            }
        }
        return moves;
    }

    ArrayList<Integer> process(Matrix matrix,String symbol1,String symbol2){
        field.setMatrix(matrix);

        Integer[] scores = new Integer[field.getLength()];
        for(int i = 0;i<field.getLength();i++){
            if(field.move(symbol2,i)!=-1){
                scores[i] = estimate.process(field.getMatrix(),symbol2,symbol1);
                field.resetMove(i);
            }
        }

        return moves(scores);
    }

}
