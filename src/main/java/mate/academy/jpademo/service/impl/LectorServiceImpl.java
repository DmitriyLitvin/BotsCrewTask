package mate.academy.jpademo.service.impl;

import mate.academy.jpademo.dao.LectorDao;
import mate.academy.jpademo.model.Colours;
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
        String keyword = Colours.RED.getCode() + pattern + Colours.END.getCode();

        lectors.stream()
                .peek(lector -> lector
                        .setName(lector.getName().replaceAll(pattern, keyword)))
                .peek(lector -> lector
                        .setSurname(lector.getSurname()
                                .replaceAll(pattern, keyword)))
                .map(lector -> lector.getName() + " " + lector.getSurname())
                .forEach(System.out::println);
    }
}

