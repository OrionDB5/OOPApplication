/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca;

/**
 *
 * @author Benedetto
 */
import java.awt.*;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;


public class MyCanvas extends Canvas{
	
	public void paint(Graphics g) {
		Toolkit t=Toolkit.getDefaultToolkit();
		Image i=t.getImage("p3.gif");
		g.drawImage(i, 50,60,this);
			
			
	}
		public static void main(String[] args) {
		MyCanvas m=new MyCanvas();
		JFrame f=new JFrame();
		f.add(m);
		f.setSize(400,400);
		//f.setLayout(null);
		f.setVisible(true);
	}

}