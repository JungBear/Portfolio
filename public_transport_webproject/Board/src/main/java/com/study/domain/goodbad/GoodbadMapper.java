package com.study.domain.goodbad;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodbadMapper {
	int checkGood(GoodbadDTO params);
	
	int checkbad(GoodbadDTO params);
	
	void clickGood(GoodbadDTO params);

	void cancelGood(GoodbadDTO params);
	
	void increaseCountGood(int params);
	
	void decreaseCountGood(int params);
	
	void clickBad(GoodbadDTO params);
	
	void increaseCountBad(int params);
	
	void decreaseCountBad(int params);
}
