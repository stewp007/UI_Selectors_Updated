
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * 
 */

/**
 * @author stewartpowell The Full List of labeled Check boxes UI presenter Used
 *         for M-From-N Semantic Control
 */
public class FullListView extends UiView {

    /** The group of check boxes */
    private final Group checkGroup;
    /** The name of the group of check boxes */
    private final Label groupLabel;
    /** The layout of the group of check boxes (Vertical as default) */
    private final RowLayout buttonLayout;
    /** The model that contains the shell and display */
    private final SemanticControl model;
    /** The number of check boxes of the presenter */
    private int numBoxes;

    /**
     * Constructor for the Full List View class
     * 
     * @param numBoxes     the number of check boxes of the presenter
     * @param buttonLayout Layout of the Buttons: true for horizontal and false for
     *                     vertical
     * @param model        the model associated with the shell and display
     */
    public FullListView(int numBoxes, boolean buttonLayout, SemanticControl model
    /* @SuppressWarnings("javadoc") Shell shell */) {
        super();
        this.model = null;
        this.checkGroup = new Group(model.getShell(), SWT.FILL);
        this.groupLabel = new Label(checkGroup, SWT.CHECK);
        this.groupLabel.setText("Test");
        if (buttonLayout) {
            this.buttonLayout = new RowLayout(SWT.HORIZONTAL);
        } else {
            this.buttonLayout = new RowLayout(SWT.VERTICAL);
        }
        model.getShell().setLayout(new RowLayout());
        this.checkGroup.setLayout(this.buttonLayout);
        this.numBoxes = numBoxes;
    }

    /**
     * Get the group of check boxes in the presenter
     * 
     * @return the group of check boxes in the presenter
     */
    public Composite getCheckGroup() {
        return checkGroup;
    }

    /**
     * Adds text to the label of the group of check boxes
     * 
     * @param label the new label of the group of check boxes
     */
    public void addGroupLabel(String label) {
        this.getGroupLabel().setText(label);
    }

    /**
     * Adds a new check box to the list of check boxes
     * 
     * @param label the label attached to the new check box
     */
    @Override
    public void addButton(String label) {
        Button newButton = new Button(this.checkGroup, SWT.CHECK);
        newButton.setText(label);
        this.getButtons().add(newButton);
        this.setNumBoxes(getNumBoxes() + 1);
    }

    /**
     * Adds a new check box to the list of check boxes
     * 
     * @param labels the label attached to the new check box
     */
    @Override
    public void addManyButtons(List<Object> labels) {
        for (int i = 0; i < labels.size(); i++) {
            Button newButton = new Button(this.checkGroup, SWT.CHECK);
            newButton.setText(labels.get(i).toString());
            this.getButtons().add(newButton);
            this.setNumBoxes(getNumBoxes() + 1);
            System.out.println("Added new button: " + labels.get(i).toString());
        }
    }

    /**
     * Gets the total number of check boxes
     * 
     * @return the total number of check boxes
     */
    public int getNumBoxes() {
        return numBoxes;
    }

    /**
     * Sets the total number of check boxes
     * 
     * @param numBoxes the total number of check boxes
     */
    public void setNumBoxes(int numBoxes) {
        this.numBoxes = numBoxes;
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
     * Gets the row layout of the group of check boxes
     * 
     * @return the row layout of the group of check boxes
     */
    public RowLayout getButtonLayout() {
        return buttonLayout;
    }

    /**
     * Gets the model associated with this view
     * 
     * @return the model associated with this view
     */
    public SemanticControl getModel() {
        return model;
    }
}
