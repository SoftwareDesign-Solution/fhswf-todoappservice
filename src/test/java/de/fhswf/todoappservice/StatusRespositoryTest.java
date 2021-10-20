package de.fhswf.todoappservice;

import de.fhswf.todoappservice.model.Status;
import de.fhswf.todoappservice.repository.StatusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/*
@RunWith(SpringRunner.class)
@SpringBootTest(
        SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
*/

//@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJpaTest // Geht gegen eine H2-Datenbank
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToDoAppServiceApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class StatusRespositoryTest {

    @Autowired
    StatusRepository statusRepository;

    @Test
    @Transactional
    public void shouldReturn() {

        Status status = new Status();
        status.setId(1);
        status.setName("Neu");

        List<Status> statuses = statusRepository.findAll();

        assertThat(statuses).contains(status);

    }
}
