/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import controller.SureYonetici;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import view.MainPage;

/**
 *
 * @author Orhan
 */
public class BaslatListener implements ActionListener {
    
    
    JLabel sure;
    JLabel puan;
    JPanel pnl;
    Timer tmr;
    
    public BaslatListener(JLabel sure,JLabel puan,JPanel pnl)
    {
        this.sure = sure;
        this.puan = puan;
        this.pnl = pnl;
    }
    
    SureYonetici timeAdmin;
    public void gameEnding(int score){
        timeAdmin.gameEnding(score);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        timeAdmin = new SureYonetici(sure, puan, (JButton) ae.getSource(), pnl);
        timeAdmin.gameStart();
    }
    
}
