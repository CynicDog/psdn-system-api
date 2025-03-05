package kr.co.metlife.pseudomgtsystemapi.store.repository;

import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConfigRuleRepository extends JpaRepository<ConfigRule, UUID> {
}
