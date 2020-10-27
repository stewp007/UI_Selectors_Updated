

package swt_widgets;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloSwt {
  public static void main(String[] args) {
	  
	  
    Display display = new Display();
    Shell shell = new Shell(display);

    shell.setText("Hello, world, Finally!");

    shell.open();
    // Set up the event loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        // If no more entries in the event queue
        display.sleep();
      }
    }
    display.dispose();
    
    
	  
  }
  
}

