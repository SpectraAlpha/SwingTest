package digital.clock;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class ClockThread extends Thread{
	private Windows w;

	public ClockThread(Windows w) {
		this.w = w;
		start();
		}
	
	/*AbstractAction escape  = new AbstractAction() {
        
		private static final long serialVersionUID = 1L;
		@Override
        public void actionPerformed(ActionEvent e) {
            //Abort program
            w.frame.dispose();
        }
    };
    */
    
	
	public void run() {
		while(true) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String formatDate = sdf.format(date);
			String[] dateArr = formatDate.split(":");
			w.textField.setText(dateArr[0]);
			w.textField_1.setText(dateArr[1]);
			w.textField_2.setText(dateArr[2]);
			
			/*
			//This may Slow it down
	        // Hotkey set to exit cause there is no close button
	        // Add a hotkey (Escape + Control) to close the frame
	        KeyStroke escapeControlKeyStroke = KeyStroke.getKeyStroke("ESCAPE control pressed");
	        InputMap inputMap = w.frame.getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW);
	        inputMap.put(escapeControlKeyStroke, "Escape");
	        ActionMap actionMap = w.frame.getRootPane().getActionMap();
	        actionMap.put("Escape", escape);
			*/ 
			
		}
	
	
	
	}

}
