package kr.co.metlife.pseudomgtsystemapi.store.repository;

import kr.co.metlife.pseudomgtsystemapi.store.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {

    Table findByName(String name);
}
