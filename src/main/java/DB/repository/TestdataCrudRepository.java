package DB.repository;

import DB.model.Testdata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TestdataCrudRepository extends CrudRepository<Testdata, Long> {

    Testdata findTestdataByTagEquals(String tag);

}
