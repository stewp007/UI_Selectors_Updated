
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
 * @author stewartpowell The Full List of labeled Check boxes UI presenter Used
 *         for M-From-N Semantic Control
 */
public class FullListView extends UiView {
    /**
     * Constructor for the Full List View class
     * 
     * @param model the model associated with the shell and display
     * @param type  the type of view
     */
    public FullListView(SemanticControl model, Views type) {
        super(model, type);
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
                    } else {
                        getModel().getCurrValue().remove(source.getText());
                    }
                }
            });
            this.getButtons().add(newButton);
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

    /**
     * Adds a new button to the presenter
     * 
     * @param button the new button to add
     */
    public void addButton(Button button) {
        System.out.println("Adding button");
        if ((button.getStyle() & SWT.CHECK) != SWT.CHECK) {
            System.out.println("Invalid Button type: " + button.getStyle());
        } else {
            Button newButton = buttonExists(button.getText());
            if (newButton == null) {
                getButtons().add(button);
                System.out.println("Adding new new button");
                for (Control child : getButtonGroup().getChildren()) {
                    if (child instanceof Button && child.isVisible()) {
                        child.moveBelow(button);
                    }
                }
                this.setNumButtons(getNumButtons() + 1);
            } else {
                System.out.println("Adding new button");
                newButton.setVisible(button.isVisible());
                newButton.setSelection(button.getSelection());
                newButton.setGrayed(button.getGrayed());
                newButton.setEnabled(button.getEnabled());
                for (Control child : getButtonGroup().getChildren()) {
                    if (child instanceof Button && !child.isVisible()) {
                        child.moveBelow(newButton);
                    }
                }
            }
        }
    }

    @Override
    public void addManyButtons(List<Object> labels) {
        for (int i = 0; i < labels.size(); i++) {
            addButton((String) labels.get(i));
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
}
