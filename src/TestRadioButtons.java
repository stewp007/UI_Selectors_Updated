import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;

public class TestRadioButtons {
	 public static void main(String[] args) {

	        List<Object> gender = new LinkedList<>();
	        gender.add("Male");
	        gender.add("Female");
	        gender.add("I don't want to answer");
	        
	        OneFromN model = new OneFromN();
	        model.addManyToAllValues(gender);
	        
	        RadioButtonView view = new RadioButtonView(model);
	        view.setGroupBackground(SWT.COLOR_DARK_GRAY);
	        
	        model.addView(view);
	        model.setViewName(1, "Gender");
	        
	        BoxButtonView view2 = new BoxButtonView(model);
	        view2.setGroupBackground(SWT.COLOR_DARK_CYAN);
	        model.addView(view2);
	        model.setViewName(2, "Gender");
	        
//	        PopMenuView view3 = new PopMenuView(model);
//	        view3.setGroupBackground(SWT.COLOR_DARK_CYAN);
//	        model.addView(view3);
//	        model.setViewName(3, "Gender");
	        
	        System.out.println("Before " + model.getCurrValue());
	        model.launchUi();
	        System.out.println("After " + model.getCurrValue());
	  
	 }
}
