package com.hemi.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Emplistener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		Constants.SESSION_COUNT++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		Constants.SESSION_COUNT--;
	}

}
