package kr.co.metlife.pseudomgtsystemapi.store.aggregate;

import kr.co.metlife.pseudomgtsystemapi.store.entity.User;

public interface UserAggrService {
    User retrieve(String userId);
}
