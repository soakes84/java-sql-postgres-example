package com.theironyard.sqldbintro.repository;

import com.theironyard.sqldbintro.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String ADD_SQL = "INSERT INTO persons (firstName, lastName) VALUES (?,?)";

    @Override
    public void add(Person person) {

        jdbcTemplate.update(ADD_SQL, person.getFirstName(), person.getLastName());

    }

    private final String GET_BY_ID_SQL = "SELECT * FROM persons WHERE id = ?";
    @Override
    public Person getById(int id) {
        return jdbcTemplate.queryForObject(GET_BY_ID_SQL, new PersonMapper(), id);
    }

    private final String GET_ALL_SQL = "SELECT * FROM persons";
    @Override
    public List<Person> get() {
        return jdbcTemplate.query(GET_ALL_SQL, new PersonMapper());
    }

    private final String UPDATE_SQL = "UPDATE persons SET firstName=?, lastName=? WHERE id=?";
    @Override
    public void update(Person person) {
        jdbcTemplate.update(UPDATE_SQL, person.getFirstName(), person.getLastName(), person.getId());
    }

    private final String UPDATE_FIRST_NAME_SQL = "UPDATE persons SET firstName=? WHERE id=?";
    @Override
    public void updateFirstName(Person person) {
        jdbcTemplate.update(UPDATE_FIRST_NAME_SQL, person.getFirstName(), person.getId());
    }

    private final String DELETE_SQL = "DELETE FROM persons WHERE id=?";
    @Override
    public void delete(int id) {

        jdbcTemplate.update(DELETE_SQL, id);

    }

    public class PersonMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setFirstName(rs.getString("firstName"));
            person.setLastName(rs.getString("lastName"));

            return person;
        }
    }
}
