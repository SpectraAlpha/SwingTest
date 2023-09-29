package digital.clock;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.formdev.flatlaf.IntelliJTheme;

import javax.swing.JLabel;






public class Windows {

	protected JFrame frame;
	protected JTextField textField;
	protected JTextField textField_1;
	protected JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windows window = new Windows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Windows() {
		//IntelliJTheme.setup(Windows.class.getResourceAsStream("/HighContrast.theme.json"));
		//Error In the Imported FlatLaf Theme 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 300); // Suggested by Prashant Sharma
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		//Adding font
		Font f =null ;
		try {
			f = Font.createFont(Font.TRUETYPE_FONT,digital.clock.Windows.class.getResourceAsStream("/Garamoni.ttf"));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 546, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Use Text for now
		
		textField = new JTextField("10");
		textField.setFont(f.deriveFont(Font.BOLD,100f));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(null);
		textField.setForeground(new Color(0, 0, 0));
		textField.setEditable(false);
		textField.setBounds(26, 84, 119, 112);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("00");
		textField_1.setFont(f.deriveFont(Font.BOLD,100f));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBorder(null);
		textField_1.setEditable(false);
		textField_1.setBounds(201, 84, 119, 112);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("00");
		textField_2.setFont(f.deriveFont(Font.BOLD,100f));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		textField_2.setBounds(385, 84, 119, 112);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		// Using SVG FILE -- Suspended 
		// Maybe Ill use JPG
		/*
		SVGPanel svgPanel = new SVGPanel("path");
		svgPanel.setBounds(26, 84, 119, 112);
		panel.add(svgPanel);
		
		SVGPanel svgPanel_1 = new SVGPanel("path");
		svgPanel_1.setBounds(201, 84, 119, 112);
		panel.add(svgPanel_1);
		
		SVGPanel svgPanel_2 = new SVGPanel("path");
		svgPanel_2.setBounds(385, 84, 119, 112);
		panel.add(svgPanel_2);
		*/
		
		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setFont(f.deriveFont(Font.BOLD,100f));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(152, 84, 45, 112);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setFont(f.deriveFont(Font.BOLD,100f));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(330, 84, 45, 112);
		panel.add(lblNewLabel_1);
		
		
		AbstractAction escape  = new AbstractAction() {
	          
			private static final long serialVersionUID = 1L;
			

			@Override
            public void actionPerformed(ActionEvent e) {
                //Abort program
                frame.dispose();
            }
        };

        // Hotkey set to exit cause there is no close button
        // Add a hotkey (Escape + Control) to close the frame
        KeyStroke escapeControlKeyStroke = KeyStroke.getKeyStroke("ESCAPE control pressed");
        InputMap inputMap = frame.getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(escapeControlKeyStroke, "escape");
        ActionMap actionMap = frame.getRootPane().getActionMap();
        actionMap.put("escape", escape);
		
		new ClockThread(this);
	
		
		
        
        
        
	}
}
