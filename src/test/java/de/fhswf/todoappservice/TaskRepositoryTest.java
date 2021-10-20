package de.fhswf.todoappservice;

import de.fhswf.todoappservice.model.Task;
import de.fhswf.todoappservice.repository.TaskRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

/*
@RunWith(SpringRunner.class)
//@SpringBootTest()
@AutoConfigureDataJpa()
//@SpringBootTest()
//@ActiveProfiles("test")
//@TestPropertySource(locations = {"classpath:application.properties"})
//@ExtendWith(SpringExtension.class)
@DataJpaTest
*/
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void shouldReturnAllTasks() {

        Task task = new Task();
        task.setId(1);
        task.setCompleted(false);
        task.setDescription("Dies ist eine Aufgabenbeschreibung");
        task.setTitle("Aufgabe");
        taskRepository.save(task);

        List<Task> tasks = taskRepository.findAll();

        assertThat(tasks).contains(task);

    }

}
