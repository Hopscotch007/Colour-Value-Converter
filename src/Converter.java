import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Converter extends JFrame {

  // Main Method
  public static void main(String[] args) {
    ConverterGUI frame = new ConverterGUI();
    frame.pack();
    frame.setTitle("Colour Value Converter (8bit and 5bit values)");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

class ConverterGUI extends JFrame {
  // Text fields for Number 1, Number 2, and Result
  private JTextField r1, g1, b1, r2, g2, b2;

  // Buttons "Add", "Subtract", "Multiply" and "Divide"
  private JButton to5, to8;

  // Default Constructor
  public ConverterGUI() {
	// Panel p0 for the instructions
	JPanel p0 = new JPanel();
	p0.setLayout(new FlowLayout());
	p0.add(new JLabel("8bit (0-255) values in the left 3 boxes, 5bit (0-31) values in the right 3 boxes. It will only convert if you provide numbers in all 3 of the values, also it rounds to 4 decimal places"));
	
	
    // Panel p1 to hold text fields and labels
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(new JLabel("8bit Values RGB:"));
    p1.add(r1 = new JTextField(6));
    p1.add(g1 = new JTextField(6));
    p1.add(b1 = new JTextField(6));
    p1.add(new JLabel("5bit Values RGB:"));
    p1.add(r2 = new JTextField(6));
    p1.add(g2 = new JTextField(6));
    p1.add(b2 = new JTextField(6));

    // Panel p2 to hold buttons
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(to5 = new JButton("8bit to 5bit"));
    p2.add(to8 = new JButton("5bit to 8bit"));

    // Add panels to the frame
    setLayout(new BorderLayout());
    add(p0, BorderLayout.NORTH);
    add(p1, BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);

    // Register listeners
    to5.addActionListener(new ActionListener()
      {public void actionPerformed(ActionEvent e)
         {calculate(true);
         }
      });
    to8.addActionListener(new ActionListener()
      {public void actionPerformed(ActionEvent e)
         {calculate(false);
         }
      });
  }

  // Calculate and show the result in jtfResult
  private void calculate(boolean operator) {
	double rN1 = 0, gN1 = 0, bN1 = 0, rN2 = 0, gN2 = 0, bN2 = 0;
	// Obtain Values, use try/catch to get rid of non numbers
	try{  
		if(operator){
			rN1 = Double.parseDouble(r1.getText().trim());
			gN1 = Double.parseDouble(g1.getText().trim());
			bN1 = Double.parseDouble(b1.getText().trim());
		}
		else{
			rN1 = Double.parseDouble(r2.getText().trim());
			gN1 = Double.parseDouble(g2.getText().trim());
			bN1 = Double.parseDouble(b2.getText().trim());
		}
	}  
	catch(NumberFormatException nfe){  
	      return;  
	}  
	
    // Perform selected operation and set the text
    if(operator){
    	rN2 = (rN1*31)/255;
    	gN2 = (gN1*31)/255;
    	bN2 = (bN1*31)/255;
    	r2.setText(String.valueOf(Math.round(rN2*10000.0)/10000.0));
    	g2.setText(String.valueOf(Math.round(gN2*10000.0)/10000.0));
    	b2.setText(String.valueOf(Math.round(bN2*10000.0)/10000.0));
    }
    else{
    	rN2 = (rN1*255)/31;
    	gN2 = (gN1*255)/31;
    	bN2 = (bN1*255)/31;
    	r1.setText(String.valueOf(Math.round(rN2*10000.0)/10000.0));
    	g1.setText(String.valueOf(Math.round(gN2*10000.0)/10000.0));
    	b1.setText(String.valueOf(Math.round(bN2*10000.0)/10000.0));
    }
  }
}