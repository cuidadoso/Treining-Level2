package demo3;

import java.text.*;
import java.util.*;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class MyThread extends Thread {
	
	private Display display;
	private Label label;
	
	public MyThread (Display disp, Label lab)
	{
		display = disp;
		label = lab;
	}
	public void run () {
            try
            {
                    while (true)
                    {	    
				DateFormat df=DateFormat.getTimeInstance(DateFormat.MEDIUM);				
				String    str=df.format(new Date());

                        if (!display.isDisposed())	label.setText (str);
                        else         			break;
                        Thread.sleep(1000);
                    }
            }
            catch (Exception e) { e.printStackTrace(); }
	}
}


	
