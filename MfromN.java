/**
 * 
 */

/**
 * @author stewartpowell
 *
 */
public class MfromN extends SemanticControl {

    /**
     * Constructor for MfromN Model
     * 
     * @param layout the layout of the Shell: true for horizontal and false for
     *               vertical
     */
    public MfromN(boolean layout) {
        super(layout);
    }

    /**
     * Adds a view to the current list of views
     * 
     * @param view a value to add to the current Values
     */
    public void addView(Views view) {
        switch (view) {
            case FULL:
                getViews().add(new FullListView(0, false, this));
                break;
            case SCROLLING:
                // views.add(new UiView());
            case CHECK:
                // views.add(new UiView());
            default:
                System.out.println("Error: Incapatable view selected: " + view);
        }
    }

}
