package geo_shape;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class App extends JFrame implements WindowListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1789312406935644634L;

	JRadioButton Circle,Triangle,Rect;
	JRadioButton perimeter,area;
	JPanel jp1,jp2,jp3;
	JButton	jb1;
	ButtonGroup group1,group2;
	JTextField	 jtf;
	JTextArea	jta;
	String	para;
	public App(){
//		jp.add(new JRadioButton("Circle"));
//		jp.setLayout(new GridLayout(3,1));
//		jp.add(new JButton("button"));
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(3,1));
		jp1.add(Circle=new JRadioButton("Circle"));
		jp1.add(Triangle=new JRadioButton("Triangle"));
		jp1.add(Rect=new JRadioButton("Rect"));
		group1=new ButtonGroup();
		Circle.setActionCommand("Circle");
		Triangle.setActionCommand("Triangle");
		Rect.setActionCommand("Rect");
		group1.add(Circle);
		group1.add(Triangle);
		group1.add(Rect);

		add(jp1,BorderLayout.WEST);
		jp2=new JPanel();
		jp2.setLayout(new GridLayout(3,1));
		jp2.add(perimeter=new JRadioButton("perimeter"));
		jp2.add(area=new JRadioButton("area"));
		group2=new ButtonGroup();
		group2.add(perimeter);
		group2.add(area);
		add(jp2,BorderLayout.CENTER);
		
		jp3=new JPanel();
		jp3.setLayout(new GridLayout(3,1));
		jp3.add(jtf=new JTextField("perimete"));
		para=jtf.getText();
		
		jp3.add(jb1=new JButton("Calc"));
		ActionListener listener=new OKListener();
		jb1.addActionListener(listener);
		jp3.add(jta=new JTextArea());

		add(jp3,BorderLayout.EAST);
		
//		setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
//		add(new JLabel("first name"));
//		add(new JTextField(8));
//		add(new JRadioButton("Circle"));
		
	}
//	jp.setLayout(new GridLayout(3,1));
//		setLayout(new FlowLayout());
//		JFrame frame=new JFrame("window");
//		choice_shape=new CheckboxGroup();
//		circle=new Checkbox("circle",true,choice_shape);
//		triangle=new Checkbox("triangle",false,choice_shape);
//		rect=new Checkbox("rec",true,choice_shape);
//		
//		add(circle);
//		add(triangle);
//		add(rect);
//		jp.add(new JRadioButton("Circle"));
		
	
	public void windowClosing(WindowEvent e){
		
		System.out.println("closing");
		dispose();
	}
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("open");
		
	}
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("close");
		
	}
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		App wc=new App();
		wc.setTitle("~~~~~~~~~~~~~~~");
		wc.setLocationRelativeTo(null);
		wc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wc.setSize(400,200);
		wc.setVisible(true);
	}
	class OKListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int shape,type;
			int i=0,j=0;
			float convert1;
			String text,input1;
			String str=group1.getSelection().getActionCommand();
			input1=jtf.getText();
			convert1=Float.parseFloat(input1);
			Enumeration<AbstractButton> buttons=group1.getElements();
			while(buttons.hasMoreElements()){
				AbstractButton btn=buttons.nextElement();
				if(btn.isSelected()){
					text=btn.getText();
					break;
				}
				i++;
			}
			buttons=group2.getElements();
			while(buttons.hasMoreElements()){
				AbstractButton btn=buttons.nextElement();
				if(btn.isSelected()){
					text=btn.getText();
					break;
				}
				j++;
			}
			if(i==3){
				
			}
			if(i==0){
				Circle cir=new Circle(convert1);
				
				jta.setText(cir.area()+"");
				
			}
			System.out.println();
			
//			Object ob=e.getSource();
//			String str=jtf.getText();
//			float input1=Float.parseFloat(str);
//			
//			boolean b=Circle.isSelected();
//			System.out.println(str);
			
//			float area,peri;
			
//			area=Float.parseFloat(str);
//			System.out.println(area);
		}
	}

}



