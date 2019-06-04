/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import inherit.CustomJToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Orhan
 */
public class SureYonetici 
{

    JLabel sure;
    JLabel puan;
    JButton btn;
    JPanel pnl;
    Timer tmr;
    int saat;
    int dakika;
    int saniye;
    
    public SureYonetici(JLabel sure,JLabel puan,JButton btn,JPanel pnl)
    {
        
        this.sure = sure;
        this.puan = puan;
        this.btn = btn;
        this.pnl = pnl;
    
    }
    
    public void gameStart()
    {
        
        saniye = 0;
        dakika = 0;
        saat = 0;
        puan.setText("0");
        sure.setText("00:00:00");
        btn.setEnabled(false);
        for(int i=0;i<pnl.getComponentCount();i++)
        {
            
            CustomJToggleButton ctb = (CustomJToggleButton)pnl.getComponent(i);
            ctb.setSelected(false);
            ctb.setEnabled(true);
            ctb.setText("");
            
        }
        DecimalFormat dFormat = new DecimalFormat("00");
        tmr = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                saniye++;
                if(saniye > 59)
                {
                    dakika++;
                    saniye = 0;
                }
                if(dakika > 59)
                {
                    saat++;
                    dakika = 0;
                }
                
                sure.setText(dFormat.format(saat) + ":" + dFormat.format(dakika) + ":" + dFormat.format(saniye));
                
            }
        });
        tmr.start();
 
    }
    
    public void gameEnding(int score)
    {
        
        puan.setText(String.valueOf(score));
        tmr.stop();
        
        
    }
    
    
}
