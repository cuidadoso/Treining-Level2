package demo4;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class Main extends ApplicationWindow  {
  public Main() {
    super(null);
  }

  public void run() {
    // Don't return from open() until window closes
    setBlockOnOpen(true);

    open();
    Display.getCurrent().dispose();
  }

  protected Control createContents(Composite parent) {
    Label label = new Label(parent, SWT.CENTER);
    label.setText("Hello, World");
    return label;
  }
  public static void main(String[] args) {
        new Main().run();
  }
}

