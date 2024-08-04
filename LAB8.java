package lab8;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Customer {
	JFrame frame;
	JTextField cnamef,cnof,statef,creditf;
	JButton submit;
	String cname,state,credit;
	int cno;
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	Customer(){
		frame=new JFrame("Details");
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(5,5));
		
		cnamef=new JTextField(20);
		frame.add(new JLabel("Customer name"));
		frame.add(cnamef);
		
		cnof=new JTextField(20);
		frame.add(new JLabel("Customer number"));
		frame.add(cnof);
		
		statef=new JTextField(20);
		frame.add(new JLabel("State"));
		frame.add(statef);
		
		creditf=new JTextField(20);
		frame.add(new JLabel("Credit Limit"));
		frame.add(creditf);
		
		submit=new JButton("Submit");
		frame.add(submit);
		submit.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				submit_details();
			}
		});
		try 
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Keerthan@11");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void submit_details() {
		cname=cnamef.getText();
		state=statef.getText();
		cno=Integer.parseInt(cnof.getText());
		credit=creditf.getText();
		
		String query="insert into cust values(?,?,?,?)";
		
		try {
			st=con.prepareStatement(query);
			st.setInt(1, cno);
			st.setString(2, cname);
			st.setString(3, state);
			st.setString(4, credit);
			st.executeUpdate();
			rs=st.executeQuery("select * from cust");
			rs.next();
			int i=1;
			while(rs.next()) {
				
				JFrame fr=new JFrame(" "+ i++);
				fr.setVisible(true);
				fr.setLayout(new GridLayout(4,2));
				fr.setSize(300,300);
				
				fr.add(new JLabel("Cust number"));
				fr.add(new JLabel(""+rs.getInt("custn")));
				
				fr.add(new JLabel("Cust name"));
				fr.add(new JLabel(rs.getString("custna")));
				
				fr.add(new JLabel("State"));
				fr.add(new JLabel(rs.getString("state2")));
				
				fr.add(new JLabel("Credit Limit"));
				fr.add(new JLabel(rs.getString("cred")));
				
			}
			
		}catch(Exception e) {e.printStackTrace();}
		
	}
	public static void main(String []args) {
		Customer obj=new Customer();
	}
}
