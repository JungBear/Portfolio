package com.study.domain.goodbad;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoodbadService {
	private final GoodbadMapper goodbadmapper;
	
	public boolean checkGood(GoodbadDTO params) {
		if (goodbadmapper.checkGood(params) == 0) {
			return false; 
		}else {
			return true;
		}
	}
	
	public boolean checkbad(GoodbadDTO params) {
		if (goodbadmapper.checkbad(params) == 0) {
			return false; 
		}else {
			return true;
		}
	}
	
	public void clickGood(GoodbadDTO params) {
		goodbadmapper.clickGood(params);
	}
	
	public void cancelGood(GoodbadDTO params) {
		goodbadmapper.cancelGood(params);
	}
	
	public void increaseCountGood(int params) {
		goodbadmapper.increaseCountGood(params);
	}
	
	public void decreaseCountGood(int params) {
		goodbadmapper.decreaseCountGood(params);
	}
	
	public void clickBad(GoodbadDTO params) {
		goodbadmapper.clickBad(params);
	};
	
	public void increaseCountBad(int params) {
		goodbadmapper.increaseCountBad(params);
	};
	
	public void decreaseCountBad(int params) {
		goodbadmapper.decreaseCountBad(params);
	};
}
