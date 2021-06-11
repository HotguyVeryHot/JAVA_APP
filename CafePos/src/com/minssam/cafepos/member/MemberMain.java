package com.minssam.cafepos.member;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.minssam.cafepos.main.AppMain;
import com.minssam.cafepos.main.Page;
import com.minssam.cafepos.model.domain.Product;

public class MemberMain extends Page {
	// 서쪽관련
	JPanel menu_box;
	JButton bt_regist;

	// smbang
	JButton p_progress;
	JButton p_fin;

	JPanel product_category_box;
	
	// 센터
	JPanel product_box;
	JTable table;
	JScrollPane scroll_table;
	
	// 동쪽관련
	JPanel orderList_box;
	JLabel t_top;

	// 남쪽관련
	JPanel p_south;
	JButton bt_order;
	JButton bt_cancel;


	public MemberMain(AppMain appMain) {
		super(appMain);
		setBackground(Color.BLUE);// 상품전체영역



		// 서쪽
		menu_box = new JPanel();
		p_progress = new JButton("      진행중      ");
		p_fin = new JButton          ("    판매완료    ");

		// 동쪽

		orderList_box = new JPanel();
		t_top = new JLabel("주문내역");
		
		// 센터
		product_box = new JPanel();
		table = new JTable(20, 5);
		scroll_table = new JScrollPane(table);
		
		// 남쪽
		p_south = new JPanel();
		bt_cancel = new JButton("주문취소"); 
		bt_order = new JButton("결제");

		// 카테고리별 상품영역
		product_category_box = new JPanel();

		bt_regist = new JButton("상품등록");

		// 스타일 & 레이아웃
		setLayout(new BorderLayout());


		Dimension d = new Dimension(250, 30); // 공통크기

		// 전체영역
		product_box.setPreferredSize(new Dimension(900, 900));
		product_box.setBackground(Color.BLUE);
		menu_box.setPreferredSize(new Dimension(150, 900));
		menu_box.setBackground(Color.RED);
		orderList_box.setPreferredSize(new Dimension(350, 900));
		orderList_box.setBackground(Color.CYAN);
//		p_south.setPreferredSize(new Dimension(1200, 100));
//		p_south.setBackground(Color.GREEN);

		// 상단카테고리 버튼 부착
		menu_box.setLayout(null);
		menu_box.add(p_progress);
		menu_box.add(p_fin);
		p_progress.setBounds(15, 20, 120, 50);
		p_fin.setBounds(15, 100, 120, 50);

		// 상품이미지영역 부착
		product_box.setLayout(null);
		product_box.add(table);
		product_box.add(scroll_table);
		table.setBounds(100, 50, 600, 700);
		scroll_table.setBounds(0, 0, 0, 0);

		// 동쪽
		orderList_box.setLayout(null);
		orderList_box.add(t_top);
		orderList_box.add(bt_cancel);
		orderList_box.add(bt_order);
		t_top.setBounds(150, 10, 100, 50);
		bt_cancel.setBounds(60, 700, 100, 50);
		bt_order.setBounds(200, 700, 100, 50);

		// 남쪽
//		p_south.setLayout(null);
//		p_south.add(bt_cancel);
//		p_south.add(bt_order);


		add(menu_box, BorderLayout.WEST);
		add(product_box, BorderLayout.CENTER);
		add(orderList_box, BorderLayout.EAST);
		add(p_south, BorderLayout.SOUTH);

		// 지워 테스트임
		p_progress.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getPrdList("C01");
			}
		});
	}

	// 상품 리스트 가져오기
	public void getPrdList(String category_code) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product WHERE category_code='C01'";

		try {
			pstmt = this.getAppMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.getAppMain().release(pstmt, rs);
		}

		System.out.println(sql);

	}
}
