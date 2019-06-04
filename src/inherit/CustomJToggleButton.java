package inherit;


import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Orhan
 */
public class CustomJToggleButton extends JToggleButton
{
    
    ActionListener al;
    String text;
    
    
    public CustomJToggleButton(ActionListener al,String text)
    {
        
        this.al = al;
        this.text = text;
        
        this.addActionListener(al);
        this.setName(text);
        this.setText(text);
        this.setSelected(true);
        this.setEnabled(false);
        
        this.setPreferredSize(new Dimension(50,50));
        
        
    }
    
       
}
