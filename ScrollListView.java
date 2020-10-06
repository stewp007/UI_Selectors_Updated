import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * 
 */

/**
 * @author stewartpowell
 *
 */
public class ScrollListView extends UiView {
    /** The number of check boxes of the presenter */
    private int numBoxes;
    /** The containing group for the scrollGroup and buttons */
    private final Group viewGroup;
    /** A scrollable group of check boxes */
    private final ScrolledComposite scrollGroup;
    /** The group of check boxes */
    private final Composite buttonGroup;

    /**
     * Constructor for the Full List View class
     * 
     * @param numBoxes     the number of check boxes of the presenter
     * @param buttonLayout Layout of the Buttons: true for horizontal and false for
     *                     vertical
     * @param model        the model associated with the shell and display
     * @param type         the type of view
     */
    public ScrollListView(int numBoxes, boolean buttonLayout, SemanticControl model, Views type) {
        super(model, type);
        this.viewGroup = new Group(model.getShell(), SWT.NONE);
        this.scrollGroup = new ScrolledComposite(this.viewGroup, SWT.V_SCROLL);

        this.buttonGroup = new Composite(scrollGroup, SWT.NONE);
        // this.groupLabel = new Label(buttonGroup, SWT.NONE);
        this.buttonGroup.setLayout(new GridLayout());
        this.buttonGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        /* Possibility to move to its own function */
        /*
         * this.scrollGroup.setLayout(new GridLayout(1, false));
         * this.scrollGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
         */
        this.scrollGroup.setContent(getButtonGroup());
        setGroupLayout();
        scrollGroup.setExpandHorizontal(true);
        scrollGroup.setExpandVertical(true);
        scrollGroup.setMinSize(buttonGroup.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        /*
         * this.scrollGroup.setExpandHorizontal(true);
         * this.scrollGroup.setExpandVertical(true);
         * this.scrollGroup.setMinSize(scrollGroup.computeSize(SWT.DEFAULT,
         * SWT.DEFAULT));
         */
        this.numBoxes = numBoxes;
    }

    /**
     * Sets pre-filled layout data for the viewGroup and scrollGroup
     */
    private void setGroupLayout() {
        viewGroup.setLayout(new GridLayout(1, false));
        GridData scrollData = new GridData(SWT.FILL, SWT.FILL, true, false);
        scrollData.heightHint = 400;
        viewGroup.setLayoutData(scrollData);
        scrollGroup.setLayout(new GridLayout(1, false));
        scrollGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        buttonGroup.setLayout(new GridLayout());
        this.buttonGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
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
        System.out.println("new button = " + newButton);
        if (newButton == null) {
            newButton = new Button(getButtonGroup(), SWT.CHECK);
            newButton.setText(label);
            newButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
            newButton.setVisible(true);
            this.getButtons().add(newButton);
            System.out.println(getButtons());
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
                newButton = new Button(getButtonGroup(), SWT.CHECK);
                newButton.setText(labels.get(i).toString());
                newButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
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
                getScrollGroup().update();

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

    /**
     * Gets the scrollable group of buttons
     * 
     * @return the scrollable group of buttons
     */
    public ScrolledComposite getScrollGroup() {
        return scrollGroup;
    }

    /**
     * Gets the view group
     * 
     * @return the group containing the scrollcomposite and the buttongroup
     */
    public Group getViewGroup() {
        return viewGroup;
    }

    /**
     * Sets the name of the View group
     * 
     * @param name the name of the View group
     */
    public void setViewGroupName(String name) {
        getViewGroup().setText(name);
    }

    @Override
    public Composite getButtonGroup() {
        return super.getButtonGroup();
    }
}
