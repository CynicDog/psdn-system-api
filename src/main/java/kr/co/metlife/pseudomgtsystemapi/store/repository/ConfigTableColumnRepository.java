package kr.co.metlife.pseudomgtsystemapi.store.repository;

import kr.co.metlife.pseudomgtsystemapi.store.entity.ConfigTableColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigTableColumnRepository extends JpaRepository<ConfigTableColumn, Long> {

}
