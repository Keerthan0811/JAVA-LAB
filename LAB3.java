package lab3;
import java.util.*;

public class Contacts {
	public long number;
	public String name;
	public Date date;

	public Contacts(long number,String name){
		this.name=name;
		this.number=number;
		this.date=new Date();
	}
	public String toString() {
		return "NAME: "+this.name+" NUMBER: "+this.number+" DATE: "+this.date+"\n";
	}
}

package lab3;

import java.util.Date;

public class MissedCalls {
	public long number;
	public String name;
	public Date date;
	
	public MissedCalls(long number,String name) {
		this.name =name;
		this.number=number;
		this.date=new Date();
	}
	public MissedCalls(long number) {
		this.number=number;
		this.name="Private Caller";
		this.date=new Date();
	}
	public String toString() {
		return "NAME: "+this.name+" NUMBER: "+this.number+" DATE: "+this.date+"\n";
	}
}

package lab3;
import java.sql.*;
import java.util.*;

public class Telephone {
	static LinkedList<Contacts> contacts;
	static LinkedList<MissedCalls> missedcalls;
	static Scanner sc=new Scanner(System.in);
	public Telephone() {
		contacts=new LinkedList<Contacts>();
		missedcalls=new LinkedList<MissedCalls>();
	}
	public static void main(String [] args) {
		Telephone obj=new Telephone();
		
		contacts.add(new Contacts(789124678,"Keerthan"));
		contacts.add(new Contacts(789123578,"Aditya"));
		contacts.add(new Contacts(959124678,"Paavan"));
		contacts.add(new Contacts(789128978,"Kartik"));
		contacts.add(new Contacts(789349678,"Suhas"));
		
		long number;
		int choice;
		while(true) {
			System.out.println("Enter the choice \n1.Add MissedCall \n2.Diaplsy Calls \n3.Delete options"
					+ " ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:	System.out.println("Enter the missedcall number: ");
					number=sc.nextLong();
					boolean found=false;
					String missedname=null;
					
					for(Contacts c:contacts) {
						if(c.number==number) {
							found=true;
							missedname=c.name;
							break;
						}
					}
					if(missedcalls.size()>3) {
						missedcalls.removeFirst();
					}
					if(found) {
						missedcalls.addLast(new MissedCalls(number,missedname));
					}
					else {
						missedcalls.addLast(new MissedCalls(number));
					}
					break;
					
			case 2:	int i=1;
					for(MissedCalls m:missedcalls) {
						System.out.println("index "+(i++)+" details: "+m);
					}
					break;
					
			case 3:	System.out.println(missedcalls);
					System.out.println("Enter the choice \n1.Delete missedcall \n2.Delete contact details");
					int ch=sc.nextInt();
					if(ch==1) {
						System.out.println("Enter the number to delete");
						number=sc.nextLong();
						for(MissedCalls m:missedcalls) {
							if(m.number==number) {
								missedcalls.remove(m);
								break;
							}
						}
					}
					else if(ch==2) {
						System.out.println("Enter the number to delete deatils");
						number=sc.nextLong();
						for(Contacts m:contacts) {
							if(m.number==number) {
								contacts.remove(m);
								break;
							}
						}
						for(MissedCalls m:missedcalls) {
							if(m.number==number) {
								missedcalls.remove(m);
								break;
							}
						}
						break;
						
			}
		}
		
	}
		
		
}
}
