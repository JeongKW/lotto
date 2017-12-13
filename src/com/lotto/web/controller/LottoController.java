package com.lotto.web.controller;

import javax.swing.JOptionPane;

import com.lotto.web.constantPool.Value;
import com.lotto.web.domain.LottoBean;
import com.lotto.web.service.LottoService;
import com.lotto.web.serviceImpl.LottoServiceImpl;

public class LottoController {
	public static void main(String[] args) {
		LottoBean lotto = null;
		LottoService lottoService = new LottoServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog(Value.MENU)){
				case "0":
					JOptionPane.showMessageDialog(null, "안녕히가십시오, 고객님");
					return;
				case "1":
					lotto = new LottoBean();
					lotto.setInputMoney(Integer.parseInt(JOptionPane.showInputDialog("금액을 넣어주세요")));
					lottoService.makeCustom(lotto);
					break;
				case "2":
					JOptionPane.showMessageDialog(null, lottoService.list().get(0).getLottoNumber());
					break;
				case "3":
					
					break;
				default:
					JOptionPane.showMessageDialog(null, "0 ~ 3 중의 메뉴에 해당하는 숫자를 눌러주세요");
					break;
			}
		}
	}
}
