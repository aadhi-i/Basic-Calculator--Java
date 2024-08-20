import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Calculator implements ActionListener {

	JFrame frame;
	JTextField txtfield;
	JButton[] numButton=new JButton[10];
	JButton[] funButton=new JButton[9];
	JButton addB,subB,mulB,divB;
	JButton decB,eqB,delB,clrB,negB;
	
	JPanel panel;
	
	Font myfnt=new Font("",Font.BOLD,30);
	double num1=0,num2=0,result=0;
	char ope;
	
	public Calculator() {
		frame=new JFrame("Calculator");
		frame.setSize(420,550);
		frame.setLayout(null);
		
		txtfield=new JTextField();
		txtfield.setBounds(50,25,300, 50);
		txtfield.setFont(myfnt);
		txtfield.setEditable(false);
		
		addB=new JButton("+");
		subB=new JButton("-");
		mulB=new JButton("*");
		divB=new JButton("/");
		decB=new JButton(".");
		eqB=new JButton("=");
		delB=new JButton("C");
		clrB=new JButton("AC");
		clrB.setBackground(Color.red);
		clrB.setOpaque(true);
		negB=new JButton("(-)");
		funButton[0]=addB;
		funButton[1]=subB;
		funButton[2]=mulB;
		funButton[3]=divB;
		funButton[4]=decB;
		funButton[5]=eqB;
		funButton[6]=delB;
		funButton[7]=clrB;
		funButton[8]=negB;
		
		for(int i=0;i<9;i++) {
			funButton[i].addActionListener(this);
			funButton[i].setFont(myfnt);
			funButton[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++) {
			numButton[i]=new JButton(String.valueOf(i));
			numButton[i].addActionListener(this);
			numButton[i].setFont(myfnt);
			numButton[i].setFocusable(false);
		}
		
		negB.setBounds(50,430,100,50);
		delB.setBounds(150,430,100,50);
		clrB.setBounds(250,430,100,50);
		
		panel=new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.LIGHT_GRAY);
		
		panel.add(numButton[1]);
		panel.add(numButton[2]);
		panel.add(numButton[3]);
		panel.add(addB);
		panel.add(numButton[4]);
		panel.add(numButton[5]);
		panel.add(numButton[6]);
		panel.add(subB);
		panel.add(numButton[7]);
		panel.add(numButton[8]);
		panel.add(numButton[9]);
		panel.add(mulB);
		panel.add(decB);
		panel.add(numButton[0]);
		panel.add(eqB);
		panel.add(divB);
		
		frame.add(panel);
		frame.add(negB);
		frame.add(txtfield);
		frame.add(delB);
		frame.add(clrB);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource()==numButton[i]) {
				txtfield.setText(txtfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decB) {
			txtfield.setText(txtfield.getText().concat(String.valueOf(".")));
		}
		if(e.getSource()==addB) {
			num1=Double.parseDouble(txtfield.getText());
			ope='+';
			txtfield.setText("");
		}
		if(e.getSource()==subB) {
			num1=Double.parseDouble(txtfield.getText());
			ope='-';
			txtfield.setText("");
		}
		if(e.getSource()==mulB) {
			num1=Double.parseDouble(txtfield.getText());
			ope='*';
			txtfield.setText("");
		}
		if(e.getSource()==divB) {
			num1=Double.parseDouble(txtfield.getText());
			ope='/';
			txtfield.setText("");
		}
		
		
		if(e.getSource()==eqB) {
			num2=Double.parseDouble(txtfield.getText());
			
			switch(ope) {
			case'+': result=num1+num2;break;
			case'-': result=num1-num2;break;
			case'*': result=num1*num2;break;
			case'/': result=num1/num2;break;
			
			}
			txtfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrB) {
			txtfield.setText("");
		}
		if(e.getSource()==delB) {
			String s=txtfield.getText();
			txtfield.setText("");
			for(int i=0;i<s.length()-1;i++) {
				txtfield.setText(txtfield.getText()+s.charAt(i));
			}
		}
		if(e.getSource()==negB) {
			double temp=Double.parseDouble(txtfield.getText());
			temp*=-1;
			txtfield.setText(String.valueOf(temp));
		}
		
	}
}
