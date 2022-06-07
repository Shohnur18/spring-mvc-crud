package uz.pdp.repository;

import uz.pdp.entity.Class;

import java.util.List;

public interface ClassRepository {
    public int create (Class clas);

    public List<Class> read();

    public Class findClassById (int clasId);

    public int update (Class clas);

    public int delete (int clasId);

}
