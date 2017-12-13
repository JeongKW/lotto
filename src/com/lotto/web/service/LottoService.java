package com.lotto.web.service;

import java.util.List;

import com.lotto.web.domain.LottoBean;

public interface LottoService {
	public void makeCustom(LottoBean lotto);
	public String makeLottoNum();
	public List<LottoBean> list();
}
