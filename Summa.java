import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.lang.Math; 
//import java.util.*;
import java.util.regex.*;
import java.sql.*;

/* 
<applet code="Summa" width=400 height=400>
</applet>
*/
 
public class Summa extends Applet implements ItemListener,ActionListener
{
	//Connection con=DriverManager.getconnection();
	double d=0.0;
	TextField t1;
	List l;
	String choice=" ";
	Button b[]=new Button[10];
	Button add,sub,mul,div,clear,mod,EQ,dot;
	char[] operators=new char[50];
	public void init()	
	{
		l=new List(2,false);
		GridLayout gl=new GridLayout(7,3);
		setLayout(gl);
		l.add("Basic operations");
		l.add("Conversion");
		l.add("Matrix Operations");
		t1=new TextField(10);
		add(t1);
		add(l);
		for(int i=0;i<10;i++)
		{
			b[i]=new Button(""+i);	
		}
		add=new Button("+");
		sub=new Button("-");
		mul=new Button("*");
		div=new Button("/");
		mod=new Button("%");
		dot=new Button("dot");
		clear=new Button("AC");
		EQ=new Button("=");
		t1.addActionListener(this);
		add(t1);
		for(int i=0;i<10;i++)
		{
			add(b[i]);	//adding numkeys
		}
		add(add);
		add(sub);
		add(mul);
		add(div);
		add(mod);
		add(dot);
		add(clear);
		add(EQ);
		for(int i=0;i<10;i++)
		{
			b[i].addActionListener(this);
		}
		l.addItemListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		mod.addActionListener(this);
		clear.addActionListener(this);
		EQ.addActionListener(this);
		dot.addActionListener(this);
	}
 	int w=0;
	public void actionPerformed(ActionEvent ae) 
	{
		if(choice=="Basic Operations")
		{
		System.out.println("choice");
		String str=ae.getActionCommand();
		char ch = str.charAt(0);	//converting string to character
		if (Character.isDigit(ch))	//Character class contains isDigit
		{	
			t1.setText(t1.getText()+str);
		}
		else
		if(str.equals("+"))
		{
			t1.setText(t1.getText()+"+");
			operators[w]='+';w++;
		}
		else if(str.equals("-"))
		{
			t1.setText(t1.getText()+"-");
			operators[w]='-';w++;
		}
		else if(str.equals("*"))
		{
			t1.setText(t1.getText()+"*");
			operators[w]='*';w++;
		}
		else if(str.equals("/"))
		{
			t1.setText(t1.getText()+"/");
			operators[w]='/';w++;
		}
		else if(str.equals("%"))
		{
			t1.setText(t1.getText()+"%");
			operators[w]='%';w++;
		}
		else if(str.equals("dot"))
		{
			t1.setText(t1.getText()+".");
		}
		else if(str.equals("="))
		{
			int n1,o=0;
			String g=t1.getText();		//g is the mathematical expression
			String[] s=g.split("\\+|-|/|%");	//splitting the numbers only
			n1=w;		//contains the operators
			d=d+Double.parseDouble(s[o]);
			o++;
			t1.setText("");
			for(int i=0;i<n1;i++)
			{
				char OP;
				OP=operators[i];
				if(OP=='+'){
					String a1;
					a1=s[o];
					d=d+Double.parseDouble(a1);
					o++;}
				if(OP=='-'){
					String a1;
					a1=s[o];
					d=d-Double.parseDouble(a1);
					o++;}
				if(OP=='*'){
					String a1;
					a1=s[o];
					d=d*Double.parseDouble(a1);
					o++;}
				if(OP=='/'){
					String a1;
					a1=s[o];
					d=d/Double.parseDouble(a1);
					o++;}
				if(OP=='%'){
					String a1;
					a1=s[o];
					d=d%Double.parseDouble(a1);
					o++;}		
			}
			t1.setText(Double.toString(d));
			w=0;d=0.0;
		}	
		else if(str.equals("AC"))
		{
			t1.setText("");
			d=0.0;
			w=0;
		}
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		choice=l.getSelectedItem();
		System.out.println(choice);
	}
}

