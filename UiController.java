import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

/**
 * 
 */

/**
 * @author stewartpowell
 *
 */
public class UiController {

    /** The list of views associated with the controller/model */
    private List<UiView> views;
    /** The model associated with the controller */
    private SemanticControl model;

    /**
     * Constructor for UiController class
     * 
     * @param model the model associated with this controller
     */
    public UiController(SemanticControl model) {
        this.model = model;
        this.views = model.getViews();
        initViews();
    }

    /**
     * Initializes the views of the controller
     */
    public void initViews() {
        model.setShellText("This is a test");
        for (Object view : views.toArray()) {
            UiView tempView = (UiView) view;
            tempView.addManyButtons(model.getAllValues());

        }
        // model.getShell().pack();
    }

    /**
     * Initializes the Controller
     */
    public void initController() {
        for (Object view : views.toArray()) {
            UiView tempView = (UiView) view;
            List<Button> buttons = tempView.getButtons();
            for (Button button : buttons) {
                button.addSelectionListener(new SelectionAdapter() {

                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        Button source = (Button) e.getSource();

                        if (source.getSelection()) {
                            model.getCurrValue().add(source.getText());
                        }
                    }
                });
            }
        }
    }

    /**
     * Adds listeners to the buttons from the view
     * 
     * @param view the view to get the buttons from
     */
    public void addListeners(UiView view) {

    }

    /**
     * Updates the list of views in case more have been added to the model
     */
    public void updateViews() {
        this.views = this.model.getViews();
    }

    /**
     * Gets the view associated with the controller
     * 
     * @return the view associated with the controller
     */
    public List<UiView> getView() {
        return views;
    }

    /**
     * Sets the view associated with the controller
     * 
     * @param view the view associated with the controller
     */
    public void setView(LinkedList<UiView> view) {
        this.views = view;
    }

    /**
     * Gets the model associated with the controller
     * 
     * @return the model associated with the controller
     */
    public SemanticControl getModel() {
        return model;
    }

    /**
     * Sets the model associated with the controller
     * 
     * @param model the model associated with the controller
     */
    public void setModel(SemanticControl model) {
        this.model = model;
    }
}
