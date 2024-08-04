package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Students {
	private JTextField nameField,usnField,addressField,ageField,catField,sgpa1Field,sgpa2Field,sgpa3Field,sgpa4Field;
	private JTextArea displayArea;
	private JFrame frame;
	private JButton compute,display,done;
	private String usn,name,address,category;
	public double sgpa1,sgpa2,sgpa3,sgpa4;
	private int age;
	ArrayList<String> studentCollection;
	String studentDetails;
	
	public Students() {
		studentCollection=new ArrayList();
		
		frame=new JFrame("Student Details");
		frame.setVisible(true);
		frame.setSize(900, 500);
		frame.setLayout(new GridLayout(11,2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nameField=new JTextField();
		frame.add(new JLabel("NAME: "));
		frame.add(nameField);
		
		usnField=new JTextField();
		frame.add(new JLabel("USN: "));
		frame.add(usnField);
		
		ageField=new JTextField();
		frame.add(new JLabel("AGE: "));
		frame.add(ageField);
		
		addressField=new JTextField();
		frame.add(new JLabel("ADDRESS: "));
		frame.add(addressField);
		
		catField=new JTextField();
		frame.add(new JLabel("Category: "));
		frame.add(catField);
		
		sgpa1Field=new JTextField();
		frame.add(new JLabel("SGPA1: "));
		frame.add(sgpa1Field);
		
		sgpa2Field=new JTextField();
		frame.add(new JLabel("SGPA2: "));
		frame.add(sgpa2Field);
		
		sgpa3Field=new JTextField();
		frame.add(new JLabel("SGPA3: "));
		frame.add(sgpa3Field);
		
		sgpa4Field=new JTextField();
		frame.add(new JLabel("SGPA4: "));
		frame.add(sgpa4Field);
		
		compute=new JButton("Compute CGPA");
		frame.add(compute);
		compute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				compute_cgpa(e);
			}
		});
		
		
		display=new JButton("Display");
		frame.add(display);
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display_details(e);
			}
		});
		
		
		done=new JButton("DONE");
		frame.add(done);
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				done_form(e);
			}
		});
		displayArea=new JTextArea();
		frame.add(displayArea);
		
	}
	
	
	private boolean validate() {
		
	        if (nameField.getText().isEmpty() || usnField.getText().isEmpty() || ageField.getText().isEmpty() ||
	                addressField.getText().isEmpty() || sgpa1Field.getText().isEmpty() || sgpa2Field.getText().isEmpty() ||
	                sgpa3Field.getText().isEmpty() || sgpa4Field.getText().isEmpty() || catField.getText().isEmpty())
	        {
	            JOptionPane.showMessageDialog(frame, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	        
	        
	        name=nameField.getText();
			usn=usnField.getText();
			address=addressField.getText();
			category=catField.getText();
			age=Integer.parseInt(ageField.getText());
			studentDetails = String.format("Name: %s, USN: %s, Age: %d, Address: %s, SGPA1: %.2f, SGPA2: %.2f, SGPA3: %.2f, SGPA4: %.2f, Category: %s",
                    name, usn, age, address, sgpa1, sgpa2, sgpa3, sgpa4, category);
            studentCollection.add(studentDetails);
	        return true;
	        
	}
	
	
	
	public void compute_cgpa(ActionEvent e) {
		if(validate()) {
			sgpa1=Double.parseDouble(sgpa1Field.getText());
			sgpa2=Double.parseDouble(sgpa2Field.getText());
			sgpa3=Double.parseDouble(sgpa3Field.getText());
			sgpa4=Double.parseDouble(sgpa4Field.getText());
		
		System.out.println(sgpa1);
		double cgpa;
		cgpa=(sgpa1+sgpa2+sgpa3+sgpa4)/4;
		JOptionPane.showMessageDialog(null, "Computed CGPA: " + cgpa, "Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void done_form(ActionEvent e) {
		if(validate()) {
			
            JOptionPane.showMessageDialog(null, "Student details stored.", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public void display_details(ActionEvent e) {
		if(validate()) {
			StringBuilder allDetails = new StringBuilder();
            for (String details : studentCollection) {
                allDetails.append(details).append("\n");
            }
            displayArea.setText(allDetails.toString());
		}
	}
	
	public static void main(String []args) {
		Students obj=new Students();
	}

	
}
