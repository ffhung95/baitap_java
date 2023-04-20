package test;

import view.landing_page;
import view.loginView;

public class thihanh  {
	
	public static void main(String[] args) {
		landing_page page = new landing_page();
		page.setVisible(true);
		for (int i = 0; i <= 100; i++) {
			try {
				Thread.sleep(40);

			} catch (Exception e) {
				e.printStackTrace();
			}
			page.loading.setText(Integer.toString(i) + "%");
			page.MyprogressBar.setValue(i);
		}
		loginView login = new loginView();
		login.setVisible(true);
		page.dispose();
	}

	

	
	
}
