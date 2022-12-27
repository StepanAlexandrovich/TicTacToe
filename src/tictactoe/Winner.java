package tictactoe;

class Winner {
    private Matrix matrix;
    
    String getWinner(Matrix matrix){
        this.matrix = matrix;
        
        int filling = 0;
        for(int i = 0;i<matrix.getLength();i++){
            if(matrix.getSymbol(i)!=PS.symbolEmpty){ filling++; }
                
            for(int a=-1;a<=1;a++){
                for(int b=-1;b<=1;b++){
                    if(!(a==0&&b==0)){ 
                        if(check(matrix.getX(i),matrix.getY(i),a,b,PS.symbolStart))  { return PS.symbolStart; }
                        if(check(matrix.getX(i),matrix.getY(i),a,b,PS.symbolFinish)) { return PS.symbolFinish; }
                        if(filling==matrix.getLength()) { return PS.draw; }
                    }
                }    
            }
                   
        }
        
        return PS.process;
    }
      
    private boolean check(int x,int y,int a,int b,String symbol){ 
        for(int i = 0;i<PS.lengthVector;i++ ){
            int newX = x+a*i;
            int newY = y+b*i;
            
            if(!matrix.range(newX,newY) || 
                    matrix.getSymbol(newX,newY)!=symbol){ 
                return false; 
            }
        }
        return true;
    }
    
    
}
