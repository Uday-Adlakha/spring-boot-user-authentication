package in.ui.main.services;

import in.ui.main.entities.Students;

public interface StudentServices {
	
	public boolean registerstudent(Students std);
	
	public Students loginstudent(String email ,String password);

}
