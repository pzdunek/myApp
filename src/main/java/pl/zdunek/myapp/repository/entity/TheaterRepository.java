package pl.zdunek.myapp.repository.entity;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pl.zdunek.myapp.domain.entity.Theater;


/**
 * Spring Data JPA repository for the User entity.
 */
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
	
//	@EntityGraph(value = "form.getAllReferences")
//	Form findOne(FormPK id);
//
//	@Query(value = "SELECT distinct kod_opisu_formularza from Form ORDER BY kod_opisu_formularza ASC", nativeQuery = true)
//	List<String> findDistinctAllIdKodOpisuFormularza();
//
//	@Query(value = "SELECT f.wariant FROM Form f WHERE f.kod_opisu_formularza = (:kodOpisuFormularza) ORDER BY wariant DESC", nativeQuery = true)
//	List<Integer> findAllWariantByKodOpisuFormularza(@Param(value = "kodOpisuFormularza") String kodOpisuFormularza);
//
//	Form findOneByIdKodOpisuFormularzaAndIdWariant(String kodOpisuFormularza, Integer wariant);
	
}