
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.border.LineBorder;
import java.io.*;
import javax.imageio.ImageIO;
import java.lang.*;



public class First extends JFrame{



	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	int sw = d.width;
	int sh = d.height;
	JLabel background = new JLabel(new ImageIcon("images/background.jpg"));
	JButton data;
	JButton bt;
	JLabel []la;
	Choice ch;
	float[] dash = {2f,2f};
	int choose = 0;


public First()
{
super();

     setSize(sw,sh);
     setDefaultCloseOperation(3);
	background.setLayout(null);
	add(background);

	addText();
	addSelectButton();
	addChoice();
	System.out.println("hiii");
setVisible(true);
}

	public void addText()
	{
	   JLabel text= new JLabel("<html><font size='3' color=white >Select the number of Digit: </font></html>  ");
	   text.setBounds(sw/2 - 200,sh/2 -100,200,30);
	   text.setFont(new Font("cooper",1,25));
	   background.add(text);
	}

	public void addChoice()
	{
	ch = new Choice();
	ch.setBounds(sw/2 ,sh/2 -100,80,30);
	ch.add("   1   ");
	ch.add("   2   ");
	ch.add("   3   ");
	ch.add("   4   ");
	ch.add("   5   ");
	ch.add("   6   ");
	ch.add("   7   ");
	ch.add("   8   ");
	ch.add("   9   ");
	ch.add("   10   ");
	background.add(ch);
	bt.addMouseListener(new ShowBinary());
	}

class ShowBinary extends MouseAdapter
{
  public void mousePressed(MouseEvent evt)
  {
		bt.setVisible(false);
		addCardLayout();
		repaint();		
  } 

}

	public void addSelectButton()
	{
	LineBorder line = new LineBorder(Color.green,1,true);
	 bt = new JButton();
	try{
	  Image img= ImageIO.read(new File("images/index.png")).getScaledInstance(100,30,Image.SCALE_DEFAULT);
	bt.setIcon(new ImageIcon(img));
	  }catch( IOException e){}
	
	bt.setBounds(sw/2-60,sh/2 - 10,100,30);
	bt.setBorder(line);
	bt.setVisible(true);
	background.add(bt);
	}

	public void addCardLayout()
	{
		LineBorder line2 = new LineBorder(Color.gray,2,true);
		int x = (ch.getSelectedIndex()+1)/2 + 1;
		la = new JLabel[ch.getSelectedIndex() + 1];
		LineBorder line = new LineBorder(Color.green,1,true);
	for(int i=0 ; i <= ch.getSelectedIndex() ; i++)
	  {
		la[i] = new JLabel("0",SwingConstants.CENTER);
		la[i].setBackground(Color.white);
		la[i].setBorder(line);
		la[i].setOpaque(true);
		la[i].setBounds((6-x)*(sw/12) + (sw/12)*(i+1),sh/2 ,60,30);
		la[i].addMouseListener(new SetBinary(i));
		background.add(la[i]);
	  }
		
		data = new JButton("");
		try{
	 	 Image img= ImageIO.read(new File("images/index.png")).getScaledInstance(100,30,Image.SCALE_DEFAULT);
		data.setIcon(new ImageIcon(img));
	 	 }catch( IOException e){}

		data.setBounds(sw/2 - 30 ,sh/2 + 90,80,30);
		data.addMouseListener(new Class());
		data.setBorder(line2);
		background.add(data);

		JButton refresh = new JButton("REFRESH");
		refresh.setBounds(sw/2 - 100 ,sh/2 + 250,200,30);
      		  refresh.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent evt)
		  {
			new First();
	 	 }
		});
		background.add(refresh);
		
	}

class Class extends MouseAdapter
{

	public void mousePressed(MouseEvent evt)
	{
	new Graph();	
	}
}


class SetBinary extends MouseAdapter
{
	int index;
	public SetBinary(int x)
	{
	index = x;
	}

	public void mousePressed(MouseEvent evt)
	{
		if(la[index].getText() == "0")
			la[index].setText("1");
		else
			la[index].setText("0");
	}
}

public static void main(String ...args)
	{
	setDefaultLookAndFeelDecorated(true);
	new First();
	}













class Graph extends JFrame
{


	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	int sw = d.width;
	int sh = d.height;
	JLabel graphLabel;

	public Graph()
	{
	setSize(sw,sh);
	setLayout(null);
     	setDefaultCloseOperation(3);	
	Axis axis = new Axis();
	getContentPane().add(axis);
	
	addData();
	addLabels();
        setVisible(true);
	}

	public void addData()
	{
	int len = la.length;
	int partition = 600/len;
	int x = 400;
	JLabel labb[] = new JLabel[len]; 
		for(int i = 0 ; i < la.length ; i++)
		{
		  labb[i] = new JLabel(la[i].getText());
		  labb[i].setBounds(x + partition/2,100,x + partition,100);
		  add(labb[i]);
		x = x + partition;
		}
	}

	public void addLabels()
	{
	graphLabel = new JLabel();
	graphLabel.setBounds(0,600,sw,sh);
	graphLabel.setOpaque(true);
	graphLabel.setBackground(Color.red);
	graphLabel.setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
	add(graphLabel);
	
	addAllOptions();
	}	

	public void addAllOptions()
	{
	JLabel showdata = new JLabel();
	showdata.setOpaque(true);
	showdata.setBackground(Color.yellow);
	graphLabel.add(showdata);

	JButton uni = new JButton("UNIPOLAR");
        uni.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		choose = 1;
		repaint();
	  }
	});
	graphLabel.add(uni);

	JButton nrzl = new JButton("NRZ-L");
        nrzl.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		choose = 2;
		repaint();
	  }
	});
	graphLabel.add(nrzl);

	JButton nrzi = new JButton("NRZ-I");
        nrzi.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		choose = 3;
		repaint();
	  }
	});
	graphLabel.add(nrzi);

	JButton manchest = new JButton("MANCHESTER");
        manchest.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		choose = 4;
		repaint();
	  }
	});
	graphLabel.add(manchest);

	JButton diffmanchest = new JButton("DIFFERENTIAL MANCHESTER");
        diffmanchest.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		choose = 5;
		repaint();
	  }
	});
	graphLabel.add(diffmanchest);

	JButton ami = new JButton("AMI");
        ami.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		choose = 6;
		repaint();
	  }
	});
	graphLabel.add(ami);

	JButton pseudo = new JButton("PSEUDOTERNARY");
        pseudo.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		choose = 7;
		repaint();
	  }
	});
	graphLabel.add(pseudo);


	JButton B8ZS = new JButton("B8ZS");
        pseudo.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		choose = 8;
		repaint();
	  }
	});
	graphLabel.add(B8ZS);


	JButton HDB3 = new JButton("HDB3");
        pseudo.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		choose = 9;
		repaint();
	  }
	});
	graphLabel.add(HDB3);


	JButton back = new JButton("BACK");
		try{
	 	 Image img= ImageIO.read(new File("images/back.png")).getScaledInstance(100,30,Image.SCALE_DEFAULT);
		back.setIcon(new ImageIcon(img));
	 	 }catch( IOException e){}
        back.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		new First();
	  }
	});
	LineBorder line3 = new LineBorder(Color.green,2,true);
	back.setBorder(line3);
	graphLabel.add(back);

	}
}


class Axis extends JComponent{

public Axis(){
setSize(sw,sh);
}

public void paint(Graphics g)
	{
	Graphics2D gd = (Graphics2D) g;
       gd.setColor(Color.red);
       gd.setStroke(new BasicStroke(2f));
	g.drawLine(400,300,1100,300);
       gd.setColor(Color.red);
       gd.setStroke(new BasicStroke(2f));
	g.drawLine(400,100 ,400,500);

       gd.setColor(Color.black);
       gd.setStroke(new BasicStroke(4f));
	g.drawLine(0,600 ,sw,600);

	if(choose == 1)
		unipolar(g);

	if(choose == 2)
		nrz_L(g);

	if(choose == 3)
		nrz_I(g);

	if(choose == 4)
		manchester(g);

	if(choose == 5)
		diffManchester(g);

	if(choose == 6)
		ami(g);

	if(choose == 7)
		pseudoter(g);
	

	if(choose == 8)
		B8ZS(g);
		
	}

	public void unipolar(Graphics g)
	{
		Graphics2D gud = (Graphics2D) g;
		int x = 400;
		int y = 200;
		int len = la.length;
		int partition = 600/len;
	
		for (int i=0 ; i< len ; i++)
		{
			if(la[i].getText() == "0")
			{
				if(y == 200)
				{
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,300);
				y = 300;
				}
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
			}else
			   {
				if(y == 300)
				{
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,200);
				y = 200;
				}	
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
			   }
			x=x + partition;
				gud.setColor(Color.pink);
				gud.setStroke(new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1f,dash,2f));
				g.drawLine(x,150,x,450);


		}
	}

	public void nrz_L(Graphics g)
	{
		Graphics2D gud = (Graphics2D) g;
		int x = 400;
		int y = 200;
		int len = la.length;
		int partition = 600/len;

		for(int i = 0 ; i < len ; i++)
		{
			if(la[i].getText() == "0")
			{
				if(y == 200)
				{
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,400);
				y = 400;
				}
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
			}else
			   {
				if(y == 400)
				{
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,200);
				y = 200;
				}	
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
			   }
			x=x + partition;
				gud.setColor(Color.pink);
				gud.setStroke(new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1f,dash,2f));
				g.drawLine(x,150,x,450);		
		}
	}


	public void nrz_I(Graphics g)
	{
		Graphics2D gud = (Graphics2D) g;
		int x = 400;
		int y = 200;
		int len = la.length;
		int partition = 600/len;
		
		for(int i = 0 ; i < len ; i++)
		{
	
			if(la[i].getText() == "0")
			{
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
			}else
			   {
				if(y == 400)
				{	
					y = 200;
				}else{
					y = 400;
				     }
	
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
				
				if(y == 400)
				{
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,200,x,y);		
				}else
				   {
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,400,x,y);
				   }
			   }
			x=x + partition;
				gud.setColor(Color.pink);
				gud.setStroke(new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1f,dash,2f));
				g.drawLine(x,150,x,450);				 
		}
	}


	public void manchester(Graphics g)
	{
		Graphics2D gud = (Graphics2D) g;
		int x = 400;
		int y = 200;
		int len = la.length;
		int partition = 600/len;

		for(int i =0 ; i < len ; i++)
		{
			if(la[i].getText() == "0")
			{	

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition/2,y);
				x=x + partition/2;

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,400);
				y = 400;

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition/2,y);
				x=x + partition/2;
				
			}else
			   {
				if(y == 200)
				  {
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,400);
				y = 400;
				  }
				
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition/2,y);
				x=x + partition/2;

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,200);	
				y = 200;	
		
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition/2,y);
				x=x + partition/2;
			   }
				gud.setColor(Color.pink);
				gud.setStroke(new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1f,dash,2f));
				g.drawLine(x,150,x,450);

		}
	}


	public void diffManchester(Graphics g)
	{
		Graphics2D gud = (Graphics2D) g;
		int x = 400;
		int y = 200;
		int len = la.length;
		int partition = 600/len;

		for(int i = 0 ; i < len;i++)
		{
			if(la[i].getText() == "0")
			{	
				int y1_pre = y;
				if(y == 400)
				{
					if(i > 0){	
					gud.setColor(Color.black);
					gud.setStroke(new BasicStroke(3f));
					g.drawLine(x,y,x,200);
					}
				y = 200;
				}else{
					if(i > 0){
					gud.setColor(Color.black);
					gud.setStroke(new BasicStroke(3f));
					g.drawLine(x,y,x,400);
					}
				y = 400;
				     }

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition/2,y);
				x=x + partition/2;

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,y1_pre);
				y = y1_pre;

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition/2,y);
				x=x + partition/2;
				
			}else
			   {

				int y2_pre = y;
				if(y == 400)
				{	
					y = 200;
				}else{
					y = 400;
				     }

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y2_pre,x + partition/2,y2_pre);
				x=x + partition/2;

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y2_pre,x,y);	
					
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition/2,y);
				x=x + partition/2;
			   }
				gud.setColor(Color.pink);
				gud.setStroke(new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1f,dash,2f));
				g.drawLine(x,150,x,450);
		}	
	}


	public void ami(Graphics g)
	{
		Graphics2D gud = (Graphics2D) g;
		int x = 400;
		int y = 300;
		int y_pre = 400;
		int len = la.length;
		int partition = 600/len;

		for(int i = 0 ; i < len ; i++)
		{
			if(la[i].getText() == "0")
			{
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,300);
	
				y = 300;

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
			}else
			   {
				if(y_pre == 400)
				{
				     if(i > 0){
						gud.setColor(Color.black);
						gud.setStroke(new BasicStroke(3f));
						g.drawLine(x,y,x,200);
					      }
				 y_pre = 200;
				 y = 200;
				}else{
					if(i > 0){
						gud.setColor(Color.black);
						gud.setStroke(new BasicStroke(3f));
						g.drawLine(x,y,x,400);
						}
				y_pre = 400;
				y = 400;
				    }


				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
											
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,300);					
			   }
			x=x + partition;
				gud.setColor(Color.pink);
				gud.setStroke(new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1f,dash,2f));
				g.drawLine(x,150,x,450);
		}
	}


		public void pseudoter(Graphics g)
	{
		Graphics2D gud = (Graphics2D) g;
		int x = 400;
		int y = 300;
		int y_pre = 400;
		int len = la.length;
		int partition = 600/len;
		float[] dash = {2f,2f};

		for(int i = 0 ; i < len ; i++)
		{
			if(la[i].getText() == "1")
			{
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,300);
	
				y = 300;

				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
			}else
			   {
				if(y_pre == 400)
				{
				     if(i > 0){
						gud.setColor(Color.black);
						gud.setStroke(new BasicStroke(3f));
						g.drawLine(x,y,x,200);
					      }
				 y_pre = 200;
				 y = 200;
				}else{
					if(i > 0){
						gud.setColor(Color.black);
						gud.setStroke(new BasicStroke(3f));
						g.drawLine(x,y,x,400);
						}
				y_pre = 400;
				y = 400;
				    }


				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x + partition,y);
											
				gud.setColor(Color.black);
				gud.setStroke(new BasicStroke(3f));
				g.drawLine(x,y,x,300);					
			   }
				x=x + partition;
				gud.setColor(Color.pink);
				gud.setStroke(new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1f,dash,2f));
				g.drawLine(x,150,x,450);
		}
	}


	public void B8ZS(Graphics g)
	{
	Graphics2D gud = (Graphics2D) g;
	int zeros = 0;
	int count = 0;
	int len = la.length;
System.out.println("b8zs");
	  if(len > 7)
	   {
		for(int i = 0 ; i < len ; i++)
		{
		  if(la[i].getText() == "0")
			{
			zeros++;
  			  if(zeros == 8)
				{
				B8ZS2(g,i-8);
				zeros = 0;
				count++;
				}
			}else{
				zeros = 0;
			     }	
		}

		if(zeros < 8 && count == 0)
		{
		choose = 6;
		repaint();
		}
		
		System.out.println(zeros);
	   }else{
		choose = 6;
		repaint();
		}
	
	}

	public void B8ZS2(Graphics g,int n)
	{
		Graphics2D gud = (Graphics2D) g;
		int x = 400;
		int y = 300;
		int y_pre = 400;
		int len = la.length;
		int partition = 600/len;

		for(int i = 0 ; i < len ; i++)
		{

			if(i >= n && i<= n+8)
			{
			}
		     else{
				if(la[i].getText() == "0")
				{
					gud.setColor(Color.black);
					gud.setStroke(new BasicStroke(3f));
					g.drawLine(x,y,x,300);
		
					y = 300;

					gud.setColor(Color.black);
					gud.setStroke(new BasicStroke(3f));
					g.drawLine(x,y,x + partition,y);
				}else
				   {
					if(y_pre == 400)
					{
					     if(i > 0){
							gud.setColor(Color.black);
							gud.setStroke(new BasicStroke(3f));
							g.drawLine(x,y,x,200);
						      }
					 y_pre = 200;
					 y = 200;
					}else{
						if(i > 0){
							gud.setColor(Color.black);
							gud.setStroke(new BasicStroke(3f));
							g.drawLine(x,y,x,400);
							}
					y_pre = 400;
					y = 400;
					    }


					gud.setColor(Color.black);
					gud.setStroke(new BasicStroke(3f));
					g.drawLine(x,y,x + partition,y);
												
					gud.setColor(Color.black);
					gud.setStroke(new BasicStroke(3f));
					g.drawLine(x,y,x,300);					
				   }
			 }
			x=x + partition;
				gud.setColor(Color.pink);
				gud.setStroke(new BasicStroke(3f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1f,dash,2f));
				g.drawLine(x,150,x,450);
		}	
	}
	
}

}


