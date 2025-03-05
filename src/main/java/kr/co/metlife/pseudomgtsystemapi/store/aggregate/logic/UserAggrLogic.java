package kr.co.metlife.pseudomgtsystemapi.store.aggregate.logic;

import kr.co.metlife.pseudomgtsystemapi.store.aggregate.UserAggrService;
import kr.co.metlife.pseudomgtsystemapi.store.entity.User;
import kr.co.metlife.pseudomgtsystemapi.store.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserAggrLogic implements UserAggrService {
    private final UserRepository repository;

    public UserAggrLogic(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User retrieve(String userId)
    {
        return  repository.findByUserId(userId);
    }
}
