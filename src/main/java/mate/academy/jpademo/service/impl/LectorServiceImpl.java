package mate.academy.jpademo.service.impl;

import mate.academy.jpademo.dao.LectorDao;
import mate.academy.jpademo.model.Lector;
import mate.academy.jpademo.service.LectorService;

import java.util.List;

public class LectorServiceImpl implements LectorService {
    private LectorDao lectorDao;

    public LectorServiceImpl(LectorDao lectorDao) {
        this.lectorDao = lectorDao;
    }

    @Override
    public Lector read(Integer id) {
        return lectorDao.read(id);
    }

    @Override
    public Integer create(Lector lector) {
        return lectorDao.create(lector);
    }

    @Override
    public void update(Lector lector) {
        lectorDao.update(lector);
    }

    @Override
    public void delete(Lector lector) {
        lectorDao.delete(lector);
    }

    @Override
    public void showLectorsWithTemplateSearch(String pattern) {
        List<Lector> lectors = lectorDao.findAll();
        String keyWord = Colours.RED.getCode() + pattern + Colours.END.getCode();

        for (Lector lector : lectors) {
            String initials = lector.getName() + " " + lector.getSurname() + " ";
            String[] strings = initials.split(pattern);

            for (int i = 0; i < strings.length; i++) {
                if (i < strings.length - 1) {
                    System.out.print(strings[i] + keyWord);
                } else {
                    System.out.print(strings[i]);
                }
            }

            System.out.println();
        }
    }
}

