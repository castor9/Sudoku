import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SButton extends JButton {
	int section, row, col;
	public SButton(int section, int row, int col) {
		this.section = section;
		this.row = row;
		this.col = col;
	}
}