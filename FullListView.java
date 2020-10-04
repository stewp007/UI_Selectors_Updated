
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;

/**
 * 
 */

/**
 * @author stewartpowell The Full List of labeled Check boxes UI presenter Used
 *         for M-From-N Semantic Control
 */
public class FullListView extends UiView {

    /** The number of check boxes of the presenter */
    private int numBoxes;

    /**
     * Constructor for the Full List View class
     * 
     * @param numBoxes     the number of check boxes of the presenter
     * @param buttonLayout Layout of the Buttons: true for horizontal and false for
     *                     vertical
     * @param model        the model associated with the shell and display
     * @param type         the type of view
     */
    public FullListView(int numBoxes, boolean buttonLayout, SemanticControl model, Views type) {
        super(buttonLayout, model, type, SWT.NONE);
        this.numBoxes = numBoxes;
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

    @Override
    public void addButton(String label) {
        Button newButton = buttonExists(label);
        if (newButton == null) {
            newButton = new Button(this.getButtonGroup(), SWT.CHECK);
            newButton.setText(label);
            newButton.setVisible(true);
            this.getButtons().add(newButton);
            for (Control child : getButtonGroup().getChildren()) {
                if (child instanceof Button && child.isVisible()) {
                    newButton.moveBelow(child);
                }
            }
            getButtonGroup().update();
            this.setNumBoxes(getNumBoxes() + 1);
        }
        for (Control child : getButtonGroup().getChildren()) {
            if (child instanceof Button && !child.isVisible()) {
                child.moveBelow(newButton);
            }
        }
        getButtonGroup().update();
    }

    @Override
    public void addManyButtons(List<Object> labels) {
        for (int i = 0; i < labels.size(); i++) {
            Button newButton = buttonExists((String) labels.get(i));
            if (newButton == null) {
                newButton = new Button(this.getButtonGroup(), SWT.CHECK);
                newButton.setText(labels.get(i).toString());
                newButton.setVisible(true);
                this.getButtons().add(newButton);
                this.setNumBoxes(getNumBoxes() + 1);
                System.out.println("Added new button: " + labels.get(i).toString());
            }
            for (Control child : getButtonGroup().getChildren()) {
                if (child instanceof Button && !child.isVisible()) {
                    child.moveBelow(newButton);
                }
            }
            getButtonGroup().update();

        }
    }

    @Override
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
}
