/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import controller.OyunYonetici;
import inherit.CustomJToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Orhan
 */
public class ToggleButtonListener implements ActionListener
{
    
    int adet;
    OyunYonetici game;
    
    public ToggleButtonListener(int adet,BaslatListener bl)
    {
        
        this.adet = adet;
        game = new OyunYonetici(adet,bl);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        CustomJToggleButton jtb = (CustomJToggleButton)ae.getSource();
        game.buttonClicked(jtb);
        
    }
    
}
