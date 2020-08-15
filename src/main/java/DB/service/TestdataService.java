package DB.service;

import DB.model.Testdata;
import DB.repository.TestdataCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TestdataService {

    @Autowired
    private TestdataCrudRepository testdataCrudRepository;

//    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
//    public void TestdataCrudReoisitory(){
//        Optional<Testdata> testdataOptional = testdataCrudRepository.findById(1L);
//    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    public Testdata TestdataCrudFindByTag(String tag){
        Testdata testdataOptional = testdataCrudRepository.findTestdataByTagEquals(tag);
        return testdataOptional;
    }


}
