import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;

/**
 * 
 */

/**
 * @author stewartpowell
 *
 */
public class DoubleListView extends UiView {
    /** The Second view that shows the selections */
    private final FullListView choiceView;

    /**
     * Constructor for the DoubleList view presenter
     * 
     * @param model the model associated with the shell and display
     */
    public DoubleListView(SemanticControl model) {
        super(model, Views.DOUBLE);
        choiceView = new FullListView(model, Views.DOUBLE);

    }

    /**
     * Creates a new button for the choiceView presenter
     * 
     * @param source the button to get the text of our new button from
     * @return the new button for our choiceView presenter
     */
    public Button getNewChoiceButton(Button source) {
        Button tempButton = new Button(choiceView.getButtonGroup(), SWT.CHECK);
        tempButton.setText(source.getText());
        tempButton.setVisible(true);
        tempButton.setSelection(true);
        tempButton.setGrayed(true);
        tempButton.setEnabled(false);
        return tempButton;
    }

    /**
     * Checks if a button already exists in the choiceView presenter
     * 
     * @param label the name of the button to check if it exists
     * @return the existing button or null if it doesn't exist
     */
    public Button choiceButtonExists(String label) {
        Button exists = null;
        for (Button button : choiceView.getButtons()) {
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
            System.out.println("New Visible: " + label);
            newButton = new Button(this.getButtonGroup(), SWT.CHECK);
            newButton.setText(label);
            newButton.setVisible(true);
            newButton.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    Button source = (Button) e.getSource();
                    if (source.getSelection()) {
                        getModel().getCurrValue().add(source.getText());
                        Button tempButton = choiceButtonExists(source.getText());

                        if (tempButton == null) {
                            tempButton = getNewChoiceButton(source);
                        } else {
                            tempButton.setVisible(true);
                            tempButton.setSelection(true);
                            tempButton.setGrayed(true);
                            tempButton.setEnabled(false);
                        }
                        choiceView.getButtons().add(tempButton);
                        for (Control child : choiceView.getButtonGroup().getChildren()) {
                            if (child instanceof Button && !child.isVisible()) {
                                child.moveBelow(tempButton);
                            }
                        }
                        choiceView.getButtonGroup().layout();
                        getModel().getShell().layout();
                        getModel().getShell().redraw();
                    } else {
                        getModel().getCurrValue().remove(source.getText());
                        choiceView.removeButton(source.getText());
                        for (Control child : choiceView.getButtonGroup().getChildren()) {
                            if (child instanceof Button && child.isVisible()) {
                                source.moveBelow(child);
                            }
                        }
                        choiceView.getButtonGroup().layout();
                        getModel().getShell().layout();
                        getModel().getShell().redraw();
                    }
                }

            });
            this.getButtons().add(newButton);
            for (Control child : getButtonGroup().getChildren()) {
                if (child instanceof Button && !child.isVisible()) {
                    child.moveBelow(newButton);
                }
            }
            this.setNumButtons(getNumButtons() + 1);
        } else {
            newButton.setVisible(true);
            System.out.println("Now Visible: " + newButton.getText());
            for (Control child : getButtonGroup().getChildren()) {
                if (child instanceof Button && !child.isVisible()) {
                    child.moveBelow(newButton);
                }
            }
        }
        getButtonGroup().update();
    }

    @Override
    public void addManyButtons(List<Object> labels) {
        for (int i = 0; i < labels.size(); i++) {
            addButton((String) labels.get(i));
        }
    }

    /**
     * Sets a name to the results view presenter
     * 
     * @param label the name of the results view
     */
    public void setChoiceViewName(String label) {
        choiceView.setGroupTitle(label);
    }

    /**
     * Gets the choice view of this presenter
     * 
     * @return the choiceView of this presenter
     */
    public FullListView getChoiceView() {
        return choiceView;
    }

}
