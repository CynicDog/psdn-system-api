package kr.co.metlife.pseudomgtsystemapi.store.repository;

import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import kr.co.metlife.pseudomgtsystemapi.store.util.DatabaseInitializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProjectRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void GetProjects()
    {
        List<Project> projectList = projectRepository.findAll();
    }
    @Test
    void GetProjectByUsername()
    {
        List<Project> projectList = projectRepository.findAllByUsername("jaeho.cha");
    }

    @Test
    @Commit
    void SetProject()
    {
        Project project = Project.builder()
                .username("jaeho.cha")
                .name("TEST")
                .status("WRITING")
                .sequence(1)
                .explanation("테스트")
                .createTimestamp(LocalDateTime.now())
                .updateTimestamp(LocalDateTime.now()).build();
        projectRepository.save(project);
        projectRepository.flush();
    }
}