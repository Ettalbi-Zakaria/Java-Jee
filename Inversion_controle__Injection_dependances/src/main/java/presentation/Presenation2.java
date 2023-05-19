package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presenation2 {
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        /*
        Injection des dependances par
        Instanciation dynamique
         */
        Scanner scanner = new Scanner(new File("config.txt"));


        IDao dao = getDao("DaoImpl2");

        String metierClassName = "metier.MetierImpl";
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();
        Method method = cMetier.getMethod("setDao",IDao.class);
        method.invoke(metier,dao);
        System.out.println(metier.calcul());
    }
    public static IDao   getDao(String daoClassName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class cDao = Class.forName("dao.".concat(daoClassName));
        IDao dao = (IDao) cDao.newInstance();
        return  dao;
    }
}
