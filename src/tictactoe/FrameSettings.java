package tictactoe;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

class FrameSettings extends JFrame{
    private Listener listener = new Listener();
    private Button button;
    
    FrameSettings(String text){
       super(text); 
        
       new Button("restart");
       new Button("switchX0").setText(PS.getSymbolUser());
       new Button("switchLevel").setText("level"+(PS.getLevel()));
       new Button("close"); 
       
       this.setLocation(450,500);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       this.setLayout(new FlowLayout(FlowLayout.CENTER));
       
       this.setSize(300,100);
       this.setVisible(true);
    }
    
    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            button = (Button)arg0.getSource();
            
            switch(button.text){
                case "restart":     restart();       break;
                case "switchX0":    switchX0();      break;
                case "switchLevel": switchLevel();   break;
                case "close":       System.exit(0);  break;
            }     
        }
        
    }
    
    private class Button extends JButton{
        String text;
        Button(String text){
            this.text = text;
            this.addActionListener(listener);
            this.setText(text);
            
            FrameSettings.this.add(this);
        }
    }
    
    private void switchX0(){
        ((JButton)button).setText(PS.switchPcUser());
    }
                        
    private void switchLevel(){
        ((JButton)button).setText("level"+(PS.switchLevel()));
    }
    
    void restart(){}
    
    
}
