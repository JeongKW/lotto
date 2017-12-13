package com.lotto.web.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBean {
	private int inputMoney;
	private List<String> lottoNumber;
	public LottoBean() {
		lottoNumber = new ArrayList<String>();
	}
	public int getInputMoney() {
		return inputMoney;
	}
	public void setInputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
	}
	public List<String> getLottoNumber() {
		return lottoNumber;
	}
	public void setLottoNumber(List<String> tempLottoNum) {
		this.lottoNumber = tempLottoNum;
	}
}
