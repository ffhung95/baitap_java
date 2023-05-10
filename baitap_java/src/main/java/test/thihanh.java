package test;

import view.landing_page;
import view.loginView;

public class thihanh {
public static void main(String[] args) {
	landing_page page= new landing_page();
	page.setVisible(true);
	try {
		for( int i=0;i<=100;i++) {
			Thread.sleep(40);
			page.MyprogressBar.setValue(i);
			page.loading.setText(Integer.toString(i)+"%");
		}
	} catch (Exception e) {		
	}
	loginView login = new loginView();
	login.setVisible(true);
	page.dispose();	
}
}
