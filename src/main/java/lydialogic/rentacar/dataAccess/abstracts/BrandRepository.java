package lydialogic.rentacar.dataAccess.abstracts;

import lydialogic.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
