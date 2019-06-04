/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import inherit.CustomJToggleButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import listeners.BaslatListener;
import listeners.ToggleButtonListener;

/**
 *
 * @author Orhan
 */
public class KutuOlustur 
{

    int adet;
    String layout;
    JPanel panel;
    BaslatListener bl;
    
    public KutuOlustur(int adet,String layout,JPanel panel,BaslatListener bl)
    {
        
        this.adet = adet;
        this.layout = layout;
        this.panel = panel;
        this.bl = bl;

    }
    
    public void update(int adet,String layout)
    {
        
        this.adet = adet;
        this.layout = layout;
        olustur();
        
    }
    
    private void olustur()
    {
        
        panel.removeAll();
        panel.repaint();
        if(adet > 0)
        {
            if(adet%2==1)
            {
                adet++;
            }

        }
        
        if(layout.equals("GridLayout"))
        {
            
            int div = calculate();
            panel.setLayout(new GridLayout(div,(adet/div)));
            
        }
        else if(layout.equals("FlowLayout"))
        {
            
            panel.setLayout(new FlowLayout());
            
        }
        diziOlustur();
        diziKaristir();
        ToggleButtonListener tgl = new ToggleButtonListener(adet, bl);
        for(int i=0;i<adet;i++)
        {
            
            CustomJToggleButton jtb = new CustomJToggleButton(tgl, String.valueOf(arr.get(i)));
            panel.add(jtb);
            
        }
        panel.validate();
    }
    
    ArrayList arr = new ArrayList();
    
    private void diziOlustur()
    {
        
        for(int i=0;i<adet/2;i++)
        {
            for(int k=0;k<2;k++)
            {
                arr.add(i);
            }
        }
        
    }
   
    private void diziKaristir()
    {
        
        for(int i=0;i<100;i++)
        {
            
            int sayi = (int)(Math.random() * (adet-1));
            int sayi2 = (int)(Math.random() * (adet-1));
            Object temp = arr.get(sayi);
            arr.set(sayi,arr.get(sayi2));
            arr.set(sayi2,temp);
            
        }
        
    }
    
    private int calculate()
    {
        
        int temp = adet;
        for(int i=1;i<adet;i++)
        {
            if(adet%i==0)
            {
                if(i>temp)
                    break;
                temp = adet/i;
            }
        }
        return temp;
    }
    
}
