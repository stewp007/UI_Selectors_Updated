import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;

public class TestRadioButtons {
	 public static void main(String[] args) {

	        List<Object> gender = new LinkedList<>();
	        gender.add("Male");
	        gender.add("Female");
	        gender.add("I don't want to answer");
	        gender.add(null);
	        List<Object> agreement = new LinkedList<>();
	        agreement.add("Agree");
	        agreement.add("Not agree");
	        OneFromN model = new OneFromN();
	        
	        model.addManyToAllValues(gender);
	        BoxButtonView view = new BoxButtonView(model, Views.BOXB);
	        model.addView(view);
	        model.getViews().get(0).setGroupTitle("Agreement:");
	        model.getViews().get(0).setGroupBackground(SWT.COLOR_BLUE);
	        
	        //model.addManyToAllValues(agreement);
	        RadioButtonView view2 = new RadioButtonView(model, Views.RADIOB);
	        model.addView(view2);
	        model.getViews().get(1).setGroupTitle("Gender:");
	        model.getViews().get(1).setGroupBackground(SWT.COLOR_GRAY);
	        
	        //UiController controller = new UiController(model);
	        //controller.initController();
	        //controller.updateView();
	        
	        System.out.println("Before " + model.getCurrValue());
	        model.launchUi();
	        System.out.println("After " + model.getCurrValue());
	 }
}
