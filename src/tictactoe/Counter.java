package tictactoe;

class Counter {
    private String s0 = PS.symbolStart;
    private String s1 = PS.symbolFinish;
    
    private Field field = new Field();
    private Winner winner = new Winner();
    
    private int bestMove;
    
    int process(String symbol,Matrix matrix){
        field.setMatrix(matrix);
        if(symbol.equals(s0)) { recursion(s1,s0,PS.getDepth()); }else
        if(symbol.equals(s1)) { recursion(s0,s1,PS.getDepth()); }    
        return bestMove;
    }
    
    int recursion(String s0,String s1,int depth){ 
        String result = winner.getWinner(field.getMatrix());
        
        if(result.equals(s0))      { return 1; } else 
        if(result.equals(PS.draw)) { return 0; } else 
        if(depth == 0)                    { return 0; } else {
            
            bestMove = -1;
            int score = -1,maxScore = -2,bestMoveS1 = -1;
            for(int i = 0;i<field.getLength();i++){
                if(field.move(s1,i)){
                    score = recursion(s1,s0,depth-1);
                    if(score>=maxScore){ 
                        maxScore = score; 
                        bestMoveS1 = i;
                    }
                    field.resetMove(i);
                }   
            }        
            bestMove = bestMoveS1;
        
            return -maxScore;
        }   

    }
    
}
