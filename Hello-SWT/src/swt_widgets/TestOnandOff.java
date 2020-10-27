package swt_widgets;


import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;


public class TestOnandOff {
	
	public static void main(String[] args) {
		
		List<Object> group = new LinkedList<>();
		group.add("My Friends");
		group.add("Follows");
		group.add("Followers");
		group.add("Strangers");
		group.add(null);
		
		TestOnandOff model = new TestOnandOff();
		
		/**
		model.addManyToAllValues(group);//can be changed depends on the user
		
		model.addView(Views.FULL, false);
		model.addView(Views.TOGGLE, false);
	
		model.getViews().get(0).setGroupTitle("Select who CAN NOT see the posts on my account:");
		model.getViews().get(1).setGroupTitle("Select Who CAN NOT see my posts on my account:");
		
		System.out.println("Before " + model.getCurrValue());
		model.launchUi();
		System.out.println("After " + model.getCurrValue());
		*/
		
		
	}
	

}

