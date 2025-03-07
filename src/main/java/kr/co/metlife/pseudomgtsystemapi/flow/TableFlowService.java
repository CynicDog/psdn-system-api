package kr.co.metlife.pseudomgtsystemapi.flow;

import kr.co.metlife.pseudomgtsystemapi.dto.TableDTO;

import java.util.List;

public interface TableFlowService {

    List<TableDTO> getTables();
}
