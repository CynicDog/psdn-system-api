package kr.co.metlife.pseudomgtsystemapi.store.repository;

import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConfigParameterRepository extends JpaRepository<ConfigParameter, String> {
}
