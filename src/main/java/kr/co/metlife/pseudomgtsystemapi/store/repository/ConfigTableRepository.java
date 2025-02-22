package kr.co.metlife.pseudomgtsystemapi.store.repository;

import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigTableRepository extends JpaRepository<ConfigTable, Long> {

    ConfigTable findByProjectNameAndName(String project, String table);
}
