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
        int count = 0;
        int size = model.getAllValues().size();
        for (Object view : views.toArray()) {
            UiView tempView = (UiView) view;
            for (Object value : model.getAllValues().subList(count, size)) {
                if (value != null) {
                    tempView.addButton((String) value);
                } else {
                    count++;
                    break;
                }
                count++;
            }
        }
    }

    /**
     * Initializes the Controller
     */
    public void initController() {
        model.addView(Views.FULL, false);
        model.getViews().get(2).setGroupTitle("Current Order");
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
                            model.getViews().get(2).addButton(source.getText());
                            System.out.println("Added: " + source.getText());
                            int count = model.getViews().get(2).getButtons().size();
                            model.getViews().get(2).getButtons().get(count - 1).setSelection(true);
                            model.getViews().get(2).getButtonGroup().layout();
                            model.getShell().layout();
                            model.getShell().redraw();
                            // updateView();
                        } else {
                            model.getCurrValue().remove(source.getText());
                            model.getViews().get(2).removeButton(source.getText());
                            System.out.println("Removed: " + source.getText());
                            // model.getViews().get(2).getButtonGroup().update();
                            model.getViews().get(2).getButtonGroup().layout();
                            model.getShell().layout();
                            model.getShell().redraw();
                        }
                    }
                });
            }
        }
        // updateView();
    }

    /**
     * Updates a new result view with the current values of the model
     */
    public void updateView() {

    }

    /**
     * Opens the Shell and displays the Presenters until exited
     */
    public void launchUi() {
        model.getShell().pack();
        model.getShell().open();
        while (!model.getShell().isDisposed()) {
            if (!model.getDisplay().readAndDispatch()) {
                model.getDisplay().sleep();
            }
        }
        model.getDisplay().dispose();
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
