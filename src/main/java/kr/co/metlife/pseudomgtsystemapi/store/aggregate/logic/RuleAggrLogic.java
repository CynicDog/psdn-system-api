//package kr.co.metlife.pseudomgtsystemapi.store.aggregate.logic;
//
//import kr.co.metlife.pseudomgtsystemapi.store.aggregate.RuleAggrService;
//import kr.co.metlife.pseudomgtsystemapi.store.entity.Rule;
//import kr.co.metlife.pseudomgtsystemapi.store.repository.RuleRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class RuleAggrLogic implements RuleAggrService {
//
//    private final RuleRepository repository;
//
//    @Override
//    public List<Rule> retrieve()
//    {
//        return  repository.findAll(Sort.by(Sort.Direction.ASC, "sequence"));
//    }
//}
