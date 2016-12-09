package web.lisenter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {
	public static int count;
	
	public OnlineCountListener() {
		count =0;
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		count++;
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;
	}

}
