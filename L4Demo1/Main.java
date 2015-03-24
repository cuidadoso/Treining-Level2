package blankwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Main {
  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    RowLayout layout = new RowLayout(SWT.VERTICAL);
    //layout.marginLeft = 12;
    //layout.marginTop = 0;
    //layout.justify = true;
    shell.setLayout(layout);
    new Button(shell, SWT.PUSH).setText("one");
    new Button(shell, SWT.PUSH).setText("two");
    new Button(shell, SWT.PUSH).setText("three");
    new Button(shell, SWT.PUSH).setText("four");
    new Button(shell, SWT.PUSH).setText("five");
    new Button(shell, SWT.PUSH).setText("six");
    Button b = new Button(shell, SWT.PUSH);
    b.setText("seven");
    //b.setLayoutData(new RowData(100, 100));

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}

