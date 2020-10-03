import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 */

/**
 * All UiViews must contain a controller
 * 
 * @author stewartpowell
 *
 */
public abstract class UiView {

    /** The SWT Display used for the UI presenter */
    private Display display;
    /** The SWT Shell used for the UI presenter */
    private final Shell shell;

    /**
     * Constructor of the UiView
     */
    public UiView() {
        this.display = new Display();
        this.shell = new Shell(display);
    }

    /**
     * Gets the Display of the UI presenter
     * 
     * @return the display of the UI presenter
     */
    public Display getDisplay() {
        return display;
    }

    /**
     * Sets the Display of the UI presenter
     * 
     * @param display the new Display of the UI presenter
     */
    public void setDisplay(Display display) {
        this.display = display;
    }

    /**
     * Gets the shell of the UI presenter
     * 
     * @return the shell of the UI presenter
     */
    public Shell getShell() {
        return shell;
    }

}
