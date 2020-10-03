import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.widgets.Button;

/**
 * All UiViews must contain a controller
 * 
 * @author stewartpowell
 *
 */
public abstract class UiView {

    /** This list of one or many buttons */
    private final List<Button> buttons;

    /**
     * Constructor of the UiView
     */
    public UiView() {
        this.buttons = new LinkedList<>();
    }

    /**
     * Gets the list of buttons
     * 
     * @return the list of buttons
     */
    public List<Button> getButtons() {
        return buttons;
    }

    /**
     * Adds a button to the presenter
     * 
     * @param label the label attached to the button
     */
    public abstract void addButton(String label);

    /**
     * Adds many button to the presenter
     * 
     * @param list the list of labels to attach to the buttons
     */
    public abstract void addManyButtons(List<Object> list);

}
