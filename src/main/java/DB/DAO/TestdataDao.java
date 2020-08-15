package DB.DAO;

import DB.model.Testdata;
import DB.sessionFactory.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TestdataDao<Bean> implements TestdataDaoImpl {

    @Override
    public Testdata getDataByTag(String tag) {
        Transaction transaction = null;
        try(Session session = SessionFactoryUtil.getSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Testdata> query = builder.createQuery(Testdata.class);
            Root<Testdata> root = query.from(Testdata.class);
            query.select(root).where(builder.equal(root.get("tag"), tag));
            Query<Testdata> testdataQuery = session.createQuery(query);
            Testdata testdata = testdataQuery.getSingleResult();
            transaction.commit();
            return testdata;
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return null;
    }
}
