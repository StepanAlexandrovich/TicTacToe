package tictactoe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class FrameGame extends JFrame{
    private Core core = new Core();
    
    private int width = PS.width;
    private int height = PS.height;
    private int sideButton = 100;
    private Button[] buttons = new Button[width*height];
    private MyKeyAdapter myKeyAdapter = new MyKeyAdapter(); 
    
    FrameGame(){ 
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(width*sideButton,height*sideButton));
        
        int index = 0;
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                panel.add(buttons[index] = new Button(x,y,index));
                index++;
            }
        } 
        
        this.add(panel);
        this.pack();
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        startPosition();
    }
    
    private void startPosition(){
        update(core.startPosition());
    }
    
    private void update(Matrix matrix){
        for(int i = 0;i<buttons.length;i++){
            buttons[i].setText(matrix.getSymbol(i));
        }
    }
    
    private class Button extends JButton{
        public int index;
    
        Button(int x,int y,int index){
            this.index = index; 
            this.setBounds(x*sideButton,y*sideButton,sideButton,sideButton);
            this.addActionListener(myKeyAdapter);
        }
     
    }
    
    private class MyKeyAdapter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) { 
            int indexUser = ((Button)e.getSource()).index;
            
            if(core.moveUser( indexUser) ){ 
                core.movePC(); 
            }
            
            update(core.getMatrix());
            
            if(core.gameOver()){
                frameSettings();
            }
        }
    }
    
    private void frameSettings(){
        new FrameSettings(core.getResult()){ 
            @Override
            void restart(){
                this.dispose();
                startPosition();
            }
        };  
    }
    
    public static void main(String[] args) {
        new FrameGame();
    }
      
}
