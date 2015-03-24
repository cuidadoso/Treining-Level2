package demo3;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;

public class MyTimeShell {

	private Shell sShell = null;
	private Label timeLabel = null;

	public static void main(String[] args) {
		Display display = Display.getDefault();
		MyTimeShell thisClass = new MyTimeShell();
		thisClass.createSShell();
		thisClass.sShell.open();

		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setSize(new Point(300, 200));
		sShell.setLayout(null);
		timeLabel = new Label(sShell, SWT.NONE);
		timeLabel.setBounds(new Rectangle(7, 4, 62, 20));
		timeLabel.setText("");

		MyThread mt = new MyThread (Display.getCurrent(), timeLabel);
                mt.setDaemon(true);
		mt.start();
	}
}
