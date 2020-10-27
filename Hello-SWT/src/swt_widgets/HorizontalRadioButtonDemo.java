package swt_widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
 
public class HorizontalRadioButtonDemo {
 
    public static void main(String[] args) {
 
        Display display = new Display();
        Shell shell = new Shell(display);
        
        shell.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
        shell.setBackgroundMode(SWT.INHERIT_FORCE);
        shell.setText("selecte who CAN see my posts: ");
 
        RowLayout rowLayout = new RowLayout();
        rowLayout.marginLeft = 5;
        rowLayout.marginTop = 5;
        rowLayout.spacing = 10;
        shell.setLayout(rowLayout);
 
        // Create a group to contain 2 radio (Horizontal)
 
        
        //Followers     
        Group followersGroup = new Group(shell, SWT.NONE);
        followersGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        
        Label followersLabel = new Label(followersGroup, SWT.NONE);
        followersLabel.setText("Followers:");
 
        Button buttonFollower = new Button(followersGroup, SWT.RADIO);
        buttonFollower.setText("Show");
 
        Button buttonFollowerHide = new Button(followersGroup, SWT.RADIO);
        buttonFollowerHide.setText("Hide");
        
        //Follows
        Group followsGroup = new Group(shell, SWT.NONE);
        followsGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        
        Label followsLabel = new Label(followsGroup, SWT.NONE);
        followsLabel.setText("Follows:");
 
        Button buttonFollow = new Button(followsGroup, SWT.RADIO);
        buttonFollow.setText("Show");
 
        Button buttonFollowHide = new Button(followsGroup, SWT.RADIO);
        buttonFollowHide.setText("Hide");
        
        //Friends
        Group friendsGroup = new Group(shell, SWT.NONE);
        friendsGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
 
        Label friendslabel = new Label(friendsGroup, SWT.NONE);
        friendslabel.setText("My Friends: ");
 
        Button buttonFriends = new Button(friendsGroup, SWT.RADIO);
        buttonFriends.setText("Show");
 
        Button buttonHide = new Button(friendsGroup, SWT.RADIO);
        buttonHide.setText("Hide");
        
        //Strangers
        Group strangersGroup = new Group(shell, SWT.NONE);
        strangersGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
 
        Label strangerslabel = new Label(strangersGroup, SWT.NONE);
        strangerslabel.setText("My Friends: ");
 
        Button buttonStrangers = new Button(strangersGroup, SWT.RADIO);
        buttonStrangers.setText("Show");
 
        Button buttonStrangersHide = new Button(strangersGroup, SWT.RADIO);
        buttonStrangersHide.setText("Hide");
        
        
    
 
        shell.setSize(400, 250);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
 
}