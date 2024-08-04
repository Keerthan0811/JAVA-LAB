package lab7;

public class Item {
	String name,id;
	int price;
	
	Item(String name,String id,int price){
	this.name=name;
	this.id=id;
	this.price=price;
	}
	
	public String toString() {
	return("ItemName "+name+" ItemId: "+id+" ItemPrice : "+price);
	}

}



package lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.*;
public class Shop implements ActionListener{
	String user="user1";
	String pass="1234";
	String un="";
	String pw;
	int id;
	JTextField userid,phno,Itemid,quan,name;
	JButton submit;
	double total=0.0;
	
	static HashMap<Long,Integer>users=new HashMap<Long,Integer>();
	static ArrayList<Item> it=new ArrayList<Item>();
	
	Shop(){
		
	while(!un.equals(user)|| !pw.equals(pass)) {
	un=JOptionPane.showInputDialog(null,"Enter username");
	
		if(!un.equals(user)) {
			JOptionPane.showMessageDialog(null, "Invalid user");
		}
		else {
			
			if(un.equals(user)) {
			pw=JOptionPane.showInputDialog(null,"Enter 	password");
				if(pw.equals(pass)) {
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Invalid 	pass");
				} 
			}	
		}
	}
	
	long ph=Long.parseLong(JOptionPane.showInputDialog(null,"Enter 	phno"));
	
	if(users.containsKey(ph)) {
		
		id=users.get(ph);
		JOptionPane.showMessageDialog(null, "Welcome"+id);
	}else {
		
	id=Integer.parseInt(JOptionPane.showInputDialog(null,"New user,Enter new id"));
	users.put(ph,id);
	
	}
	
	JFrame frm=new JFrame("Details");
	
	JLabel name1=new JLabel("User");
	JLabel ph1=new JLabel("Pn");
	JLabel id1=new JLabel("Itemid");
	JLabel q1=new JLabel("Quant");
	JLabel n1=new JLabel("It_name");
	
	userid=new JTextField(20);
	phno=new JTextField(20);
	Itemid=new JTextField(20);
	quan=new JTextField(20);
	name=new JTextField(20);
	
	submit=new JButton("Submit");
	
	frm.add(name1);
	userid.setText(String.valueOf(id));
	userid.setEditable(false);
	frm.add(userid);
	
	frm.add(ph1);
	phno.setText(String.valueOf(ph));
	frm.add(phno);
	
	frm.add(id1);
	frm.add(Itemid);
	
	frm.add(q1);
	frm.add(quan);
	
	frm.add(n1);
	frm.add(name);
	
	frm.add(submit);
	
	submit.addActionListener(this);
	
	frm.setSize(300,300);
	frm.setVisible(true);
	frm.setLayout(new GridLayout(6,2));
}
	public void actionPerformed(ActionEvent e) 
	{
		String itid=Itemid.getText();
		int itq=Integer.parseInt(quan.getText());
		String itna=name.getText();
		String discounts[]= {"5","10","15"};
		
		int r=JOptionPane.showOptionDialog(null, "select disc","Disc",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
				null,discounts,discounts[1]);
		
		for(Item ii :it) {
		if(ii.id.equals(itid)) {
		total=itq*ii.price;
		}
		} 
		total=total-(total*0.01*Integer.parseInt(discounts[r]));
		String t=String.valueOf(total);
		JOptionPane.showMessageDialog(null,"Total for "+itna+" is"+t);
	}
	public static void main(String[] args)
	{
		it.add(new Item("Bat","1",5000));
		it.add(new Item("Gloves","2",2000));
		it.add(new Item("Ball","3",600));
		Shop obj=new Shop();
	}
}
