package com.lotto.web.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.lotto.web.constantPool.Value;
import com.lotto.web.domain.LottoBean;
import com.lotto.web.service.LottoService;
import com.lotto.web.serviceImpl.LottoServiceImpl;

public class LottoController {
	public static void main(String[] args) {
		LottoBean lotto = null;
		List<LottoBean> resLotto = new ArrayList<LottoBean>();
		LottoService lottoService = new LottoServiceImpl();
		String resFileStr = "";
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
					resLotto = lottoService.list();
					for(int i = 0; i < resLotto.size(); i++) {
						resFileStr += resLotto.get(i).getLottoNumber();
					}
					JOptionPane.showMessageDialog(null, resFileStr);
					break;
				case "3":
					File f = new File("C:\\Users\\1027\\jse\\eclipse\\workspace\\lotto\\lottonumber\\lotto.txt");
					BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(f));
					bw.write(resFileStr);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						bw.flush();
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
					break;
				default:
					JOptionPane.showMessageDialog(null, "0 ~ 3 중의 메뉴에 해당하는 숫자를 눌러주세요");
					break;
			}
		}
	}
}
