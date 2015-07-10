import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.Component.*;
import java.util.*;

public class SBoard implements ActionListener {
	int rows, columns, count;
	JPanel panel, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	public SBoard() {
		this.rows = 9;
		this.columns = 9;

		JFrame frame = new JFrame("Sudoku");
		JPanel panel = new JPanel();
		JPanel mainPanel = new JPanel(new GridLayout(3, 3));

		frame.setLocation(600, 400);
		//frame.add(panel2);
		panel = setPanel(1);
		panel2 = setPanel(2);
		panel3 = setPanel(3);
		panel4 = setPanel(4);
		panel5 = setPanel(5);
		panel6 = setPanel(6);
		panel7 = setPanel(7);
		panel8 = setPanel(8);
		panel9 = setPanel(9);
		
		mainPanel.add(panel);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		mainPanel.add(panel8);
		mainPanel.add(panel9);

		frame.add(mainPanel);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public JPanel setPanel(int section) {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3,3));
		count = 1;
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				SButton gridButton = new SButton(section,i,k);
				gridButton.setText("" + count);
				pan.add(gridButton);
				count++;
			}
		}
		return pan;
	}

	public void actionPerformed(ActionEvent e){
		// if( e.getSource() instanceof TButton && thisIsPlayerBoard == true) {
		// 	//System.out.println("Row: " + (((TButton)e.getSource()).getRow()));
		// 	//System.out.println("Column: " + (((TButton)e.getSource()).getColumn()));
		// 	setMove(((TButton)e.getSource()).getRow(), ((TButton)e.getSource()).getColumn());
		// 	//((TButton)e.getSource()).status('H');
  //  		}
  //  		//System.out.println(((TButton)e.getSource()).getStatus());

	}
}