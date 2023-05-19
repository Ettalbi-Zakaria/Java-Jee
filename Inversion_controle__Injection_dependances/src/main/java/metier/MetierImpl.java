package metier;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component

public class MetierImpl implements IMetier {
    IDao dao ;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        return dao.getData()+1.5;
    }

    /*
    setDao permet d'injecter dans la variable dao un objet d'une classe qui implemente l'interface IDao
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
