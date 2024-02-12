package exercise.controller;

import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    private Task generateTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
    }

    // BEGIN
    @Test
    void testShow() throws Exception {
        var someTask = generateTask();
        taskRepository.save(someTask);

        var result = mockMvc.perform((get("/tasks/" + someTask.getId())))
                .andExpect(status().isOk())
                .andReturn();
        var json = om.readValue(result.getResponse().getContentAsString(), Task.class);
        assertThatJson(json).isObject().isEqualTo(someTask);
    }

    @Test
    void testCreate() throws Exception {
        var someTask = generateTask();
        var json = om.writeValueAsString(someTask);
        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);
        mockMvc.perform(request).andExpect(status().isCreated());
        var expect = taskRepository.findByTitle(someTask.getTitle()).isPresent();
        assertThat(expect).isTrue();
    }

    @Test
    void testUpdate() throws Exception {
        var someTask = generateTask();
        var data = new HashMap<String, String>();
        taskRepository.save(someTask);
        data.put("title", "some title");

        var json = om.writeValueAsString(data);
        var request = put("/tasks/" + someTask.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);
        mockMvc.perform(request).andExpect(status().isOk());

        var task = taskRepository.findById(someTask.getId()).get();
        assertThat(task.getTitle()).isEqualTo(data.get("title"));
    }

    @Test
    void testDelete() throws Exception {
        var someTask = generateTask();
        taskRepository.save(someTask);

        var request = delete("/tasks/" + someTask.getId());
        mockMvc.perform(request).andExpect(status().isOk());

        var expect = taskRepository.findById(someTask.getId()).isEmpty();
        assertThat(expect).isTrue();
    }    // END
}
