package data;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class DBUtil {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TOBAPU");
    public static EntityManagerFactory getEmFactory(){
        return emf;
    }
    
}