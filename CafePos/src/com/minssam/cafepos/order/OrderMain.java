package com.minssam.cafepos.order;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.minssam.cafepos.main.AppMain;
import com.minssam.cafepos.main.Page;

public class OrderMain extends Page {
	// 서쪽관련
	JPanel menu_box;
	Choice ch_top;
	Choice ch_sub;
	JButton bt_regist;

	// smbang
	JButton coffee;
	JButton tea;
	JButton ade;
	JButton bubble;
	JButton p_etc;

	JPanel product_category_box;
	JPanel product_category_box2;

	// 센터관련
	JPanel product_box;
	JPanel p_center;
	JPanel p_search; // 검색 컴포넌트들을 올려놓을 패널
	Choice ch_category; // 검색 카테고리 선택
	JTextField t_keyword; // 검색어 입력
	JButton bt_search;
	JTable table;
	JScrollPane scroll_table;

	// 동쪽관련
	JPanel orderList_box;
	JLabel t_top;
	JTextField t_top2;
	JLabel price;
	JTextField price2;
	JLabel category;
	JTextField category2;
	JLabel image;
	JTextField image2;
	JLabel state;
	JTextField state2;

	// 남쪽관련
	JPanel p_south;
	JButton bt_delete;
	JButton bt_order;
	JButton bt_cancel;

	public OrderMain(AppMain appMain) {
		super(appMain);
		setBackground(Color.RED);

		// 상품전체영역

		// 상단 카페고리 버튼 초기화
		menu_box = new JPanel();
		coffee = new JButton("매출관리");
		tea = new JButton("상품관리");
		ade = new JButton("상품통계");
		bubble = new JButton("카테고리 관리");
		p_etc = new JButton("      기타      ");

		// 동쪽
		orderList_box = new JPanel();
		t_top = new JLabel("메뉴 이름");
		t_top2 = new JTextField();
		price = new JLabel("상품 가격");
		price2 = new JTextField();
		category = new JLabel("카테고리");
		category2 = new JTextField();
		image = new JLabel("상품이미지");
		image2 = new JTextField();
		state = new JLabel("판매상태");
		state2 = new JTextField();
		bt_delete = new JButton("상품삭제");
		bt_cancel = new JButton("상품수정");
		bt_order = new JButton("상품등록");

		// 남쪽
//		p_south = new JPanel();

		// 카테고리별 상품영역
		product_box = new JPanel();
		product_category_box = new JPanel();
		product_category_box2 = new JPanel();

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
//				p_south.setPreferredSize(new Dimension(1200, 100));
//				p_south.setBackground(Color.GREEN);

		// 상품이미지영역
		product_category_box.setPreferredSize(new Dimension(790, 100));
		product_category_box.setLayout(new FlowLayout());
		product_category_box.add(new JButton("panel1"));
		
		product_category_box2.setPreferredSize(new Dimension(790, 685));
		product_category_box2.setLayout(new FlowLayout());
		product_category_box2.add(new JButton("panel2"));

		// 상단카테고리 버튼 부착
		menu_box.setLayout(null);
		menu_box.add(coffee);
		menu_box.add(tea);
		menu_box.add(ade);
		menu_box.add(bubble);
		menu_box.add(p_etc);
		coffee.setBounds(15, 20, 120, 50);
		tea.setBounds(15, 100, 120, 50);
		ade.setBounds(15, 180, 120, 50);
		bubble.setBounds(15, 260, 120, 50);
		p_etc.setBounds(15, 340, 120, 50);

		// 상품이미지영역 부착
		product_box.setLayout(new FlowLayout());
		product_box.add(product_category_box, BorderLayout.NORTH);
		product_box.add(product_category_box2, BorderLayout.CENTER);		
		

		// 동쪽
		orderList_box.setLayout(null);
		orderList_box.add(t_top);
		orderList_box.add(t_top2);
		orderList_box.add(price);
		orderList_box.add(price2);
		orderList_box.add(category);
		orderList_box.add(category2);
		orderList_box.add(image);
		orderList_box.add(image2);
		orderList_box.add(state);
		orderList_box.add(state2);
		orderList_box.add(bt_delete);
		orderList_box.add(bt_cancel);
		orderList_box.add(bt_order);
		t_top.setBounds(10, 10, 100, 30);
		t_top2.setBounds(110, 10, 150, 30);
		price.setBounds(10, 60, 100, 30);
		price2.setBounds(110, 60, 150, 30);
		category.setBounds(10, 110, 100, 30);
		category2.setBounds(110, 110, 150, 30);
		image.setBounds(10, 160, 100, 30);
		image2.setBounds(110, 160, 150, 30);
		state.setBounds(10, 210, 100, 30);
		state2.setBounds(110, 210, 150, 30);
		bt_delete.setBounds(10, 700, 100, 50);
		bt_cancel.setBounds(125, 700, 100, 50);
		bt_order.setBounds(240, 700, 100, 50);

		// 남쪽

		add(menu_box, BorderLayout.WEST);
		add(product_box, BorderLayout.CENTER);
		add(orderList_box, BorderLayout.EAST);
//				add(p_south, BorderLayout.SOUTH);

	}
}
