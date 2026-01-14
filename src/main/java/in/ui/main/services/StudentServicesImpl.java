package in.ui.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ui.main.entities.Students;
import in.ui.main.repositories.StudentRepository;

@Service
public class StudentServicesImpl implements StudentServices {
	
	@Autowired
	private StudentRepository stdrepo;

	@Override
	public boolean registerstudent(Students std) {
		try {
			stdrepo.save(std);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Students loginstudent(String email, String password) {
		Students validstd =stdrepo.findByEmail(email);
		if(validstd != null && validstd.getPassword().equals(password)) {
			return validstd;
		}
		return null;
	}

}
