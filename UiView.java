import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
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
    /** The type of view */
    private final Views type;

    /**
     * Constructor of the UiView
     * 
     * @param buttonLayout the layout of the buttons: true for horizontal and false
     *                     for negative
     * @param model        the model containing the shell of the view
     * @param type         the type of view
     * @param groupType    the type of group: i.e. SWT.NONE, SWT.V_SCROLL...
     */
    public UiView(boolean buttonLayout, SemanticControl model, Views type, int groupType) {
        this.buttons = new LinkedList<>();
        this.model = model;
        model.getShell().setLayout(new GridLayout());
        model.getShell().setLayoutData(new GridData());
        this.buttonGroup = new Composite(model.getShell(), groupType);
        this.groupLabel = new Label(buttonGroup, SWT.NONE);
        this.buttonGroup.setLayout(new GridLayout());
        this.buttonGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        this.type = type;
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
    public abstract void removeButton(String label);

    /**
     * Adds many button to the presenter
     * 
     * @param list the list of labels to attach to the buttons
     */
    public abstract void addManyButtons(List<Object> list);

    /**
     * Gets the type of view
     * 
     * @return the type of view
     */
    public Views getType() {
        return type;
    }

}
