package Core.Gui;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class GuiPanel extends JPanel implements ActionListener, MouseListener {
	
	protected int guiLeft, guiRight, guiTop, guiBottom, xSize, ySize;
	private Font font = new Font("Tahoma", Font.PLAIN, 12);
	
	public GuiPanel(int xSize, int ySize) {
		this(xSize, ySize, true);
	}
	
	public GuiPanel(int xSize, int ySize, boolean init) {
		super();
		
		this.setLayout(null);
		
		this.guiLeft = 0;
		this.guiTop = 10;
		this.xSize = xSize;
		this.ySize = ySize;
		this.guiRight = this.xSize - 5;
		this.guiBottom = this.ySize - 30;
		
		this.setupKeyBindings(this.getInputMap(), this.getActionMap());
		
		if (init) this.initGui();
		
	}
	
	/**
	 * Sets up all basic buttons, text fields, etc. Called by the main
	 * constructor.
	 */
	protected void initGui() {
	}
	
	protected void setupKeyBindings(InputMap inputMap, ActionMap actionMap) {
	}
	
	public JLabel createLabel(int x, int y, int width, int height, String str) {
		JLabel label = new JLabel(str);
		label.setBounds(x, y, width, height);
		this.add(label);
		return label;
	}
	
	public JTextField createTextFeld(int x, int y, int width, int height, int maxChars,
			ActionListener actlis) {
		JTextField ret = new JTextField(maxChars);
		ret.setBounds(x, y, width, height);
		ret.addActionListener(actlis);
		this.add(ret);
		return ret;
	}
	
	@SuppressWarnings("rawtypes")
	public JList createJList(int x, int y, int width, int height, Object[] content) {
		JList list = new JList<Object>(content);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
			}
			
		});
		JScrollPane pane = new JScrollPane();
		pane.setBounds(x, y, width, height);
		pane.setViewportView(list);
		this.add(pane);
		return list;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawScreen(g);
	}
	
	protected void drawScreen(Graphics g) {
		g.setFont(font);
		Graphics2D g2d = (Graphics2D) g.create();
		FontMetrics fm = g2d.getFontMetrics();
		
		this.drawBackground(g2d);
		
		this.drawForeground(g2d, fm);
		
		g2d.dispose();
		
	}
	
	/**
	 * Create Graphics2D before using and DISPOSE of it afterwards!
	 * 
	 * @serialData
	 *             Graphics2D g2d = (Graphics2D) g.create();
	 * @serialData
	 *             g2d.dispose();
	 * 
	 * @param text
	 * @param g2d
	 */
	public void drawString(Graphics2D g2d, String text, int x, int y) {
		/*
		Graphics2D g2d = (Graphics2D) g.create();
		String text = "Look ma, no hands";
		FontMetrics fm = g2d.getFontMetrics();
		int x = (getWidth() - fm.stringWidth(text)) / 2;
		int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
		g2d.drawString(text, x, y);
		g2d.dispose();
		 */
		g2d.drawString(text, x, y);
	}
	
	protected void drawForeground(Graphics2D g2d, FontMetrics fm) {
		
	}
	
	protected void drawBackground(Graphics2D g2d) {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof GuiButton) {
			this.buttonPressed((GuiButton) e.getSource());
		}
	}
	
	public void buttonPressed(GuiButton buttonPressed) {
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		Component[] comps = this.getComponents();
		boolean onComp = false;
		for (int i = 0; i < comps.length; i++) {
			if (comps[i].contains(e.getX(), e.getY())) {
				onComp = true;
				break;
			}
		}
		if (!onComp) {
			this.requestFocusInWindow();
		}
		 */
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
