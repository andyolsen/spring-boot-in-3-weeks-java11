package demo.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initEmployees() {
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"James", 21000, "London"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Marie", 22000, "Edinburgh"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Peter", 23000, "Belfast"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Sally", 24000, "Cardiff"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Peter", 51000, "London"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Berty", 52000, "Edinburgh"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Milly", 53000, "Belfast"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Jayne", 54000, "Cardiff"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Wally", 91000, "London"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Emily", 92000, "Edinburgh"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Tommy", 93000, "Belfast"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Colin", 94000, "Cardiff"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Sarah", 121000, "London"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Darel", 122000, "Edinburgh"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Benji", 123000, "Belfast"});
        jdbcTemplate.update("insert into EMPLOYEES (name, salary, region) values (?, ?, ?)", new Object[]{"Carys", 124000, "Cardiff"});
    }

    @PostConstruct
    public void initCars() {
        jdbcTemplate.update("insert into CARS (registration_number, make, model) values (?, ?, ?)", new Object[]{"AAA 111", "Bugatti", "Divo"});
        jdbcTemplate.update("insert into CARS (registration_number, make, model) values (?, ?, ?)", new Object[]{"BBB 222", "Lamborghini", "Sian"});
        jdbcTemplate.update("insert into CARS (registration_number, make, model) values (?, ?, ?)", new Object[]{"CCC 333", "Volkswagen", "Beetle"});
    }
}