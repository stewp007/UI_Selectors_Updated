import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;

/**
 * @author stewartpowell Testing class
 */
public class TestMany {

    /**
     * Used to test the Semantic Controls
     * 
     * @param args unused
     */
    public static void main(String[] args) {

        List<Object> toppings = new LinkedList<>();
        toppings.add("lettuce");
        toppings.add("tomatoe");
        toppings.add("onion");
        // toppings.add(null);

        // List<Object> condiments = new LinkedList<>();
        toppings.add("ketchup");
        toppings.add("mustard");
        toppings.add("mayo");
        // condiments.add(null);

        MfromN model = new MfromN();
        model.addManyToAllValues(toppings);
        // model.addManyToAllValues(condiments);
        DoubleListView view = new DoubleListView(model);
        view.setChoiceViewName("Selections: ");
        view.getChoiceView().setGroupBackground(SWT.COLOR_DARK_CYAN);
        // model.addView(view);
        model.addView(view);
        // model.addView(Views.FULL, false);
        model.getViews().get(0).setGroupTitle("Toppings:");
        model.getViews().get(0).setGroupBackground(SWT.COLOR_DARK_CYAN);
        /*
         * model.getViews().get(1).setGroupTitle("Condiments:");
         * model.getViews().get(1).setGroupBackground(SWT.COLOR_DARK_CYAN);
         * 
         * model.getViews().get(2).setGroupTitle("Order:");
         * model.getViews().get(2).setGroupBackground(SWT.COLOR_DARK_CYAN);
         */
        // UiController controller = new UiController(model);
        // controller.initController();
        // controller.updateView();
        System.out.println("Before " + model.getCurrValue());
        model.launchUi();
        System.out.println("After " + model.getCurrValue());

    }

}
