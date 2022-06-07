package uz.pdp.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uz.pdp.entity.Class;
import uz.pdp.entity.Student;

import java.util.List;

public class ClassRepositoryImpl implements ClassRepository{
    JdbcTemplate jdbcTemplate;

    public ClassRepositoryImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Class clas) {
        try {
            return jdbcTemplate.update("insert into aClass(name, Id) values (?,?)", clas.getName(), clas.getId());

        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Class> read() {
        return jdbcTemplate.query("select * from clas", BeanPropertyRowMapper.newInstance(Class.class));
    }

    @Override
    public Class findClassById(int clasId) {
        return jdbcTemplate.queryForObject("SELECT * FROM clas WHERE id=?", BeanPropertyRowMapper.newInstance(Class.class), clasId);
    }

    @Override
    public int update(Class clas) {
        return jdbcTemplate.update("UPDATE clas SET name=? WHERE id=?", clas.getName());
    }

    @Override
    public int delete(int clasId) {
        return jdbcTemplate.update("DELETE FROM clas WHERE id=?", clasId);
    }
}
