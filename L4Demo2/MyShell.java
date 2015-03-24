package demo3;

import java.text.DateFormat;
import java.util.*;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class MyShell {

	private Shell sShell = null;  
	private Button myButton = null;
	private Label myLabel = null;
	private int count = 0;

	public static void main(String[] args) {
		Display display = Display.getDefault();
		MyShell thisClass = new MyShell();
		thisClass.createSShell();
		thisClass.sShell.open();

		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	private void createSShell() {
		FormData formData = new FormData();
		formData.bottom = new FormAttachment(30, 0);
		formData.left = new FormAttachment(40, 0);
		FormData formData_lab = new FormData();
		formData_lab.top = new FormAttachment(myButton, 10);
		formData_lab.width = 100;
		formData_lab.left = new FormAttachment(40, 0);
		FormLayout formLayout = new FormLayout();
		formLayout.spacing = 0;
		formLayout.marginWidth = 5;
		formLayout.marginHeight = 5;
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setLayout(formLayout);
		sShell.setSize(new Point(300, 181));
		myButton = new Button(sShell, SWT.PUSH);
		myButton.setText("OK");
		myButton.setLayoutData(formData);
		myButton.setToolTipText("This is a good button!");
		myLabel = new Label(sShell, SWT.SHADOW_OUT | SWT.BORDER | SWT.HORIZONTAL | SWT.WRAP);
		myLabel.setText("");
		myLabel.setLayoutData(formData_lab);
		myButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				count++;
				System.out.println("widgetSelected(), count = " + count);
				DateFormat df  = 
					DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.GERMANY);				
				String str = df.format(new Date());
				myLabel.setText(str);
				
			}
		});
	}

}
