package com.lotto.web.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lotto.web.domain.LottoBean;
import com.lotto.web.service.LottoService;

public class LottoServiceImpl implements LottoService{
	List<LottoBean> custom;
	public LottoServiceImpl() {
		custom = new ArrayList<LottoBean>();
	}
	@Override
	public void makeCustom(LottoBean lotto) {
		int lottoCount = lotto.getInputMoney() / 1000;
		List<String> tempLottoNum = new ArrayList<String>();
		for(int i = 0; i < lottoCount; i++) {
			if(i != 0 && i % 5 == 0) {
				lotto.setLottoNumber(tempLottoNum);
				custom.add(lotto);
				// 5개 받고 Override
				tempLottoNum = new ArrayList<String>();
			}
			tempLottoNum.add(makeLottoNum());
		}
	}
	@Override
	public String makeLottoNum() {
		String strTemp = "[";
		int[] res = new int[6];
		// Random 중복 제거
		for(int i = 0; i < 6; i++) {
			res[i] = (int)(Math.random() * 45) + 1;
			for(int j = 0; j < i; j++) {
				if(res[i] == res[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(res);
		// 중복없는 Random 값 입력
		for(int i = 0; i < 6; i++) { 
			if(i != 5) {
				strTemp += res[i] + ", ";
			} else {
				strTemp += res[i];
			}
		}
		strTemp += "]\n";
		return strTemp;
	}
	@Override
	public List<LottoBean> list() {
		return custom;
	}
}
