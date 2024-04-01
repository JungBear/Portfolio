package com.study.domain.main;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BridgeMapper {
	/*
	 * @param = 분석정보
	 */
	public List<BridgeDTO> getResult(BridgeDTO params);
}
