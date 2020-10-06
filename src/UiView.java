import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * All UiViews must contain a controller
 * 
 * @author stewartpowell
 *
 */
public abstract class UiView {

    /** This list of one or many buttons */
    private final List<Button> buttons;
    /** The group of check boxes */
    private final Composite buttonGroup;
    /** The name of the group of check boxes */
    private final Label groupLabel;
    /** The model that contains the shell and display */
    private final SemanticControl model;
    /** The current number of buttons of the presenter */
    private int numButtons;
    /** The type of view */
    private final Views type;

    /**
     * Constructor of the UiView
     * 
     * @param model the model containing the shell of the view
     * @param type  the type of view
     */
    public UiView(SemanticControl model, Views type) {
        this.buttons = new LinkedList<>();
        this.model = model;
        model.getShell().setLayout(new GridLayout(2, false));
        model.getShell().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        this.buttonGroup = new Composite(model.getShell(), SWT.NONE);
        this.groupLabel = new Label(buttonGroup, SWT.NONE);
        this.buttonGroup.setLayout(new GridLayout(1, true));
        this.buttonGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        this.type = type;
        this.numButtons = 0;
        initViews();
    }

    /**
     * Initializes the views of the controller
     */
    public void initViews() {
        if ((type == Views.DOUBLE) && this instanceof FullListView) {
            System.out.println("Not for this view.");
        } else {
            for (Object value : model.getAllValues()) {
                if (value != null) {
                    addButton((String) value);
                }
            }
        }
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
     * Get the group of check boxes in the presenter
     * 
     * @return the group of check boxes in the presenter
     */
    public Composite getButtonGroup() {
        return buttonGroup;
    }

    /**
     * Gets the name of the group of check boxes
     * 
     * @return the name of the group of check boxes
     */
    public Label getGroupLabel() {
        return groupLabel;
    }

    /**
     * Gets the model associated with this view
     * 
     * @return the model associated with this view
     */
    public SemanticControl getModel() {
        return model;
    }

    /**
     * Sets the title of the group of buttons
     * 
     * @param title the title of the group of check boxes
     */
    public void setGroupTitle(String title) {
        this.groupLabel.setText(title);
    }

    /**
     * Adds a colored background to the group of buttons
     * 
     * @param color the color of the background from SWT class
     */
    public void setGroupBackground(int color) {
        getButtonGroup().setBackground(Display.getCurrent().getSystemColor(color));
    }

    /**
     * Helper function to see if a button already exists
     * 
     * @param label the label attach to the button
     * @return the button if it exists, or null otherwise
     */
    public Button buttonExists(String label) {
        Button exists = null;
        for (Button button : getButtons()) {
            if (button.getText().equals(label)) {
                button.setVisible(true);
                exists = button;
                break;
            }
        }
        return exists;
    }

    /**
     * Adds a button to the presenter
     * 
     * @param label the label attached to the button
     */
    public abstract void addButton(String label);

    /**
     * Removes a button from the presenter. (Instead of disposing, the button
     * visibility is set to false, with the ability to reuse the button later)
     * 
     * @param label the label attached to the button to be removed
     */
    public void removeButton(String label) {
        for (Button button : getButtons()) {
            if (button.getText().equals(label) && button != null) {
                button.setVisible(false);

                for (Control child : getButtonGroup().getChildren()) {
                    if (child instanceof Button && child.isVisible()) {
                        child.moveAbove(button);
                    }
                }
                getButtonGroup().update();

            }
        }
    }

    /**
     * Adds many button to the presenter
     * 
     * @param labels the list of labels to attach to the buttons
     */
    public abstract void addManyButtons(List<Object> labels);

    /**
     * Gets the type of view
     * 
     * @return the type of view
     */
    public Views getType() {
        return type;
    }

    /**
     * Gets the number of buttons
     * 
     * @return the current number of buttons
     */
    public int getNumButtons() {
        return numButtons;
    }

    /**
     * Sets the number of buttons
     * 
     * @param i the new number of boxes
     */
    public void setNumButtons(int i) {
        numButtons = i;
    }

}
