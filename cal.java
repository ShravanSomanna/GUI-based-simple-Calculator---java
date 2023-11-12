package src;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class cal implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons=new JButton[10];
	JButton[] functionButtons =new JButton[9];
	JButton addbtn,subbtn,mulbtn,divbtn,negbtn;
	JButton decbtn,equbtn,delbtn,clrbtn;
	JPanel panel;
	
	Font myFont = new Font(" ",Font.PLAIN,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	
	cal(){
	frame=new JFrame("CALCULATOR");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(420, 550);
	frame.setLayout(null);
	
	//ENHANCEMENT -> add new fields such as pow , sqrt
	textfield=new JTextField();
	textfield.setBounds(50, 25, 300, 50);
	textfield.setFont(myFont);
	textfield.setEditable(false);
	
	addbtn=new JButton("+");
	subbtn=new JButton("-");
	mulbtn=new JButton("*");
	divbtn=new JButton("/");
	decbtn=new JButton(".");
	equbtn=new JButton("=");
	delbtn=new JButton("del");
	clrbtn=new JButton("clr");
	negbtn=new JButton("(-)");
	
	functionButtons[0]=addbtn;
	functionButtons[1]=subbtn;
	functionButtons[2]=mulbtn;
	functionButtons[3]=divbtn;
	functionButtons[4]=decbtn;
	functionButtons[5]=equbtn;
	functionButtons[6]=delbtn;
	functionButtons[7]=clrbtn;
	functionButtons[8]=negbtn;
	
	for(int i=0;i<9;i++) {
		functionButtons[i].addActionListener(this);
		functionButtons[i].setFont(myFont);
		functionButtons[i].setFocusable(false);
	}
	
	
	for(int i=0;i<10;i++) {
		numberButtons[i]=new JButton(String.valueOf(i));
		numberButtons[i].addActionListener(this);
		numberButtons[i].setFont(myFont);
		numberButtons[i].setFocusable(false);
	}
	
	negbtn.setBounds(50,430,100,50);
	delbtn.setBounds(150,430,100,50);
	clrbtn.setBounds(250, 430, 100, 50);
	
	panel=new JPanel();
	panel.setBounds(50, 100, 300, 300);
	panel.setLayout(new GridLayout(4,4,10,10));
	panel.setBackground(Color.gray);
	
	panel.add(numberButtons[1]);
	panel.add(numberButtons[2]);
	panel.add(numberButtons[3]);
	panel.add(addbtn);
	
	panel.add(numberButtons[4]);
	panel.add(numberButtons[5]);
	panel.add(numberButtons[6]);
	panel.add(subbtn);
	
	panel.add(numberButtons[7]);
	panel.add(numberButtons[8]);
	panel.add(numberButtons[9]);
	panel.add(mulbtn);
	
	panel.add(decbtn);
	panel.add(numberButtons[0]);
	panel.add(divbtn);
	panel.add(equbtn);
	
	
	
	
	//frame.add -> adds the specific to the framewindow
	
	frame.add(panel);
	frame.add(delbtn);
	frame.add(clrbtn);
	frame.add(negbtn);
	
	frame.add(textfield);              //adds a textfield with above properties
	frame.setVisible(true);
	
	
	
	
	
	
	}
	public static void main(String[] args) {
		cal calc=new cal();
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
	for(int i=0;i<10;i++) {
		if(e.getSource()==numberButtons[i]) {
			textfield.setText(textfield.getText().concat(String.valueOf(i)));
		}
	}
		if(e.getSource()==decbtn) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addbtn) {
			//textfield.setText(textfield.getText().concat("+"));
			num1=Double.parseDouble(textfield.getText());
			operator='+';
			textfield.setText("");
			
		}
		
		if(e.getSource()==subbtn) {
			//textfield.setText(textfield.getText().concat("-"));
			num1=Double.parseDouble(textfield.getText());
			operator='-';
			textfield.setText("");
			
		}
		
		if(e.getSource()==mulbtn) {
			num1=Double.parseDouble(textfield.getText());
			operator='*';
			textfield.setText("");
			
		}
		
		if(e.getSource()==divbtn) {
			num1=Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
			
		}
		
		if(e.getSource()==equbtn) {
			num2=Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
					result=num1+num2;
					break;
			case '-':
					result=num1-num2;
					break;
			case '*':
					result=num1*num2;
					break;
			case '/':
					result=num1/num2;
					break;
					
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrbtn) {
			textfield.setText(" ");
			
	}
		
		if(e.getSource()==delbtn) {
			String str=textfield.getText();
			textfield.setText("");
			for(int i=0;i<str.length()-1;i++) {
				textfield.setText(textfield.getText()+str.charAt(i));
			}
		}
			
		if(e.getSource()==negbtn) {
			double temp=Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
			}
		}	
}



