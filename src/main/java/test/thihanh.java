package test;

import view.landing_page;
import view.loginView;

public class thihanh  {
	public static void main(String[] args) {
		landing_page page = new landing_page();
		for (int i = 0; i <= 100; i++) {
			try {
<<<<<<< HEAD
				Thread.sleep(5);
=======
				Thread.sleep(10);
>>>>>>> 9abdd73e09be36debf1dc34af43afb2be2cedce6
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
