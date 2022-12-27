package tictactoe;

class Matrix {
    private Point[] points;
    private int width,height,length;
    
    Matrix(int width,int height){
        points = new PointMaker().createPoints(width,height);
        
        length = points.length;
        this.width = width;
        this.height = height; 
    }
    
    ///////   IN   //////
    private Point getPoint(int index){ 
        return points[index];
    }
    
    private Point getPoint(int x,int y){ 
        return points[width * y + x];
    }
    
    ///// OUTSIDE //////
    int getLength(){ return length; }
     
    int getX(int index){
       return getPoint(index).x; 
    }
    
    int getY(int index){
       return getPoint(index).y; 
    }
    
    String getSymbol(int index){
        return getPoint(index).symbol;
    }
    
    String getSymbol(int x,int y){
        return getPoint(x,y).symbol;
    }
    
    void setSymbol(int index,String symbol){
        getPoint(index).symbol = symbol;
    }
    
    void setSymbol(int x,int y,String symbol){
        getPoint(x,y).symbol = symbol;
    }
    
    // check //
    boolean range(int x,int y){
        if(x>=0&&x<width&&y>=0&&y<height){
            return true; 
        }
        return false;
    }
    
    // action //
    void fill(String symbol){
        for(Point point:points){
            point.symbol = symbol;
        }
    }
    
    Matrix copy(){
        Matrix matrix = new Matrix(width,height);
        for(int i = 0;i<length;i++){
            matrix.setSymbol(i,getSymbol(i));
        }
        return matrix;
    }
    
}
