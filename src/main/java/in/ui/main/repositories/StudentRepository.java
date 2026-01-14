package in.ui.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ui.main.entities.Students;



public interface StudentRepository extends JpaRepository<Students	, Integer>{
	Students findByEmail(String email);

}
