import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Will
 *
 */
public class OneFromN extends SemanticControl {

    /**
     * Constructor
     * @param display the display used with all the Ui Components
     * @param shell   the Shell used with all the Ui components
     */
    public OneFromN(Display display, Shell shell) {
        super(display, shell);
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
                getViews().add(new RadioButtonView(this));
                break;
            case BOXB:
                getViews().add(new BoxButtonView(this));
                break;
            case POPUP:
                getViews().add(new PopMenuView(this));
                break;
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
     * This function is to add views
     * 
     * @param view The view to be added
     */
    public void addView(UiView view) {
        if ((view.getType() == Views.RADIOB) || (view.getType() == Views.BOXB) || (view.getType() == Views.POPUP) 
        		|| (view.getType() == Views.CIRCLEB) || (view.getType() == Views.TEXTFIELD)) {
            getViews().add(view);
        } else {
            System.out.println("Error: Non-valid view");
        }
    }
    
    /**
     * This function is to set the view name
     * 
     * @param number The order of the view
     * @param name The name of the view
     */
    public void setViewName(int number, String name) {
    	this.getViews().get(number - 1).setGroupTitle(name);
    }

}
