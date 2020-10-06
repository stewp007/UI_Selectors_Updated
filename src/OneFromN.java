/**
 * @author Will
 *
 */
public class OneFromN extends SemanticControl {

    /**
     * Constructor
     */
    public OneFromN() {
        super();
    }

    /**
     * This function is to add a view to the current list of views
     * 
     * @param view the value to add to the current Values
     * @param layout the layout of the presenter buttons
     */
    @Override
    public void addView(Views view, boolean layout) {
        switch (view) {
            case RADIOB:
                getViews().add(new RadioButtonView(this, Views.FULL));
                break;
//            case BOXB:
//                getViews().add(new ScrollListView(0, layout, this, Views.SCROLL));
//                break;
//            case POPUP:
//                getViews().add(new DoubleListView(this));
//                break;
//            case CIRCLEB:
//                getViews().add(new DoubleListView(this));
//                break;
//            case TEXTFIELD:
//                getViews().add(new DoubleListView(this));
//                break;
            default:
                System.out.println("Error: Incapatable view selected: " + view);
        }
    }

    /**
     * @param view
     */
    public void addView(UiView view) {
        if ((view.getType() == Views.RADIOB) || (view.getType() == Views.BOXB) || (view.getType() == Views.POPUP) 
        		|| (view.getType() == Views.CIRCLEB) || (view.getType() == Views.TEXTFIELD)) {
            getViews().add(view);
        } else {
            System.out.println("Error: Non-valid view");
        }
    }

}
