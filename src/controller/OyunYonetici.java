/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import inherit.CustomJToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import listeners.BaslatListener;
import view.MainPage;

/**
 *
 * @author Orhan
 */
public class OyunYonetici 
{
    int adet;
    CustomJToggleButton btn2 = null;
    int durum = 0;
    int puan = 0;
    Timer tmr;
    BaslatListener bsltListen;
    
    public OyunYonetici(int adet,BaslatListener bl)
    {
        
        this.adet = adet;
        this.bsltListen = bl;
        
    }
    
    public void buttonClicked(CustomJToggleButton jtb)
    {
        if(jtb.isSelected())
        {
            
            jtb.setText(String.valueOf(jtb.getName()));
            jtb.setEnabled(false);
            
            tmr = new Timer(250,new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {

                    if(btn2 == null)
                    {
                        btn2 = jtb;
                    }
                    else
                    {
                
                        if(btn2.getText().equals(jtb.getText()))
                        {
                    
                                puan+=50;
                                btn2 = null;
                                durum++;
                                
                                if(durum == (adet/2))
                                {
                        
                                    puan *= adet;
                                    MainPage.gameEnding(puan);
                                    //bsltListen.gameEnding(puan);
                                    JOptionPane.showMessageDialog(null, "Oyun Bitti");
                        
                                }
   
                        }
                        else
                        {
                            puan-=20;
                            btn2.setText("");
                            btn2.setSelected(false);
                            btn2.setEnabled(true);
                    
                            jtb.setText("");
                            jtb.setSelected(false);
                            jtb.setEnabled(true);
                    
                            btn2 = null;
                        }
                    }
                    tmr.stop();
                }
            });
                tmr.start();
        }
    }
          
    
    
}
