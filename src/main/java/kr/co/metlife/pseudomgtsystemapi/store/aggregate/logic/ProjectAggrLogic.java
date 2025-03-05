package kr.co.metlife.pseudomgtsystemapi.store.aggregate.logic;

import kr.co.metlife.pseudomgtsystemapi.store.aggregate.ProjectAggrService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.Project;
import kr.co.metlife.pseudomgtsystemapi.store.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectAggrLogic implements ProjectAggrService {

    private final ProjectRepository repository;


//    @Override
//    public List<Project> retrieve(String userId)
//    {
//        return  repository.findAllByUserId(userId);
//    }
//
//    @Override
//    public Project save(String userId, String name, Integer sequence, String explanation)
//    {
//        Project project = Project.builder()
//                .userId(userId)
//                .name(name)
//                .sequence(sequence)
//                .explanation(explanation).build();
//        return repository.save(project);
//    }
//
//    @Override
//    public Project update(UUID uuid, String name, Integer sequence, String explanation)
//    {
//        Project project = repository.getReferenceById(uuid);
//
//        project.setName(name);
//        project.setSequence(sequence);
//        project.setExplanation(explanation);
//
//        return repository.save(project);
//    }
}
