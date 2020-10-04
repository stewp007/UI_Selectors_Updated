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
     */
    public MfromN() {
        super();
    }

    /**
     * Adds a view to the current list of views
     * 
     * @param view   a value to add to the current Values
     * @param layout the layout of the presenter buttons
     */
    @Override
    public void addView(Views view, boolean layout) {
        switch (view) {
            case FULL:
                getViews().add(new FullListView(0, layout, this, Views.FULL));
                break;
            case SCROLL:
                getViews().add(new ScrollListView(0, layout, this, Views.SCROLL));
                break;
            case CHECK:
                // views.add(new UiView());
            default:
                System.out.println("Error: Incapatable view selected: " + view);
        }
    }

}
