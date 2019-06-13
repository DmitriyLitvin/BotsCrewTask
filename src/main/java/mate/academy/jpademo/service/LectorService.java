package mate.academy.jpademo.service;

import mate.academy.jpademo.model.Lector;

public interface LectorService {
    Lector read(Integer id);

    Integer create(Lector lector);

    void update(Lector lector);

    void delete(Lector lector);

    void showLectorsWithTemplateSearch(String pattern);
}
