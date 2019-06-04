/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import controller.KutuOlustur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Orhan
 */
public class KutuOlusturListener implements ActionListener
{
    
    private int adet;
    BaslatListener bl;
    private String layout;
    KutuOlustur kutu;
    JButton button;
    
    public KutuOlusturListener(int adet,String layout,JPanel panel,BaslatListener bl,JButton button)
    {
        
        this.adet = adet;
        this.layout = layout;
        this.button = button;
        kutu = new KutuOlustur(adet, layout, panel, bl);
          
    }
    
    public void adetGuncelle(int gelen)
    {
        adet = gelen;
    }
    
    public void layoutGuncelle(String gelen)
    {
        layout = gelen;
    }
   
    public void actionPerformed(ActionEvent ae)
    {
        
        kutu.update(adet, layout);
        button.setEnabled(true);
        
    }
}
