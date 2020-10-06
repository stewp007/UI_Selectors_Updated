import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;

/**
 * 
 * @author Will Array of bullets with labels Used
 *         for M-From-N Semantic Control
 *
 */
public class RadioButtonView extends UiView {

	/**
	 * Constructor
	 * 
	 * @param model the model associated with the shell and display
	 * @param type the type of view
	 */
	public RadioButtonView(SemanticControl model, Views type) {
		super(model, type);
	}

	@Override
	public void addButton(String label) {
		Button newButton = buttonExists(label);
        if (newButton == null) {
            System.out.println("New Visible: " + label);
            newButton = new Button(this.getButtonGroup(), SWT.RADIO);
            newButton.setText(label);
            newButton.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
//                    Button source = (Button) e.getSource();
//                    if (source.getSelection()) {
//                        getModel().getCurrValue().add(source.getText());
//                    } else {
//                        getModel().getCurrValue().remove(source.getText());
//                    }
                }
            });
            this.getButtons().add(newButton);
//            this.setNumButtons(getNumButtons() + 1);
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

}
