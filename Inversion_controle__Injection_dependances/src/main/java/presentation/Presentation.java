package presentation;

import dao.DaoImpl;
import dao.IDao;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        /*
        Injection des dependances par
        Instanciation statique => new
         */
        IDao dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao);
        /*metier.setDao(dao);*/

        System.out.println(metier.calcul());
    }
}
