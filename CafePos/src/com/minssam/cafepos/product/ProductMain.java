package com.minssam.cafepos.product;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.minssam.cafepos.main.AppMain;
import com.minssam.cafepos.main.Page;
import com.minssam.cafepos.model.domain.Product;
import com.minssam.cafepos.model.domain.Subcategory;
import com.minssam.cafepos.model.domain.Topcategory;

// 상품의 메인 페이지
public class ProductMain extends Page {
	// 서쪽관련
	JPanel menu_box;
	JPanel product_box;
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

	// Choice 컴포넌트는 html의 option 과 달리 텍스트, value 값을 동시에 담을수 없다
	// 따라서 우리가 이 부분을 복합 데이터 형태로 직접 만들어서 해결해보자
	ArrayList<Topcategory> topList = new ArrayList<Topcategory>(); // size 0 즉 아무것도 없다
	ArrayList<Subcategory> subList = new ArrayList<Subcategory>();

	// 센터관련
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

	// 남쪽관련
	JPanel p_south;
	JButton bt_order;
	JButton bt_cancel;

	Toolkit kit = Toolkit.getDefaultToolkit();
	Image image; // 등록시 미리보기에 사용할 이미지

	public ProductMain(AppMain appMain) {
		super(appMain);
		setBackground(Color.YELLOW);

		// 상품전체영역



		// 상단 카페고리 버튼 초기화
		menu_box = new JPanel();
		coffee = new JButton  ("      커피      ");
		tea = new JButton      ("    티 Tea    ");
		ade = new JButton     ("     에이드     ");
		bubble = new JButton("     에이드     ");
		p_etc = new JButton  ("      기타      ");

		// 동쪽
		orderList_box = new JPanel();
		t_top = new JLabel("주문내역");
		bt_cancel = new JButton("주문취소");
		bt_order = new JButton("주문완료");

		// 남쪽
//		p_south = new JPanel();

		// 카테고리별 상품영역
		product_box = new JPanel();
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

		// 상품이미지영역
		product_category_box.setPreferredSize(new Dimension(100, 100));

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
		product_box.add(product_category_box);

		// 동쪽
		orderList_box.setLayout(null);
		orderList_box.add(t_top);
		orderList_box.add(bt_cancel);
		orderList_box.add(bt_order);
		t_top.setBounds(150, 10, 100, 50);
		bt_cancel.setBounds(60, 700, 100, 50);
		bt_order.setBounds(200, 700, 100, 50);

		// 남쪽

		add(menu_box, BorderLayout.WEST);
		add(product_box, BorderLayout.CENTER);
		add(orderList_box, BorderLayout.EAST);
//		add(p_south, BorderLayout.SOUTH);

		// 지워 테스트임
		coffee.addActionListener(new ActionListener() {

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

			while (rs.next()) {
				Product product = new Product(); // empty
				product.setProduct_uid(rs.getInt("product_uid")); // pk
				product.setProduct_number(rs.getString("product_number")); // 카테고리명
				product.setName(rs.getString("name")); // 카테고리명
				product.setState(rs.getString("state")); // 카테고리명
				product.setPrice(rs.getInt("price")); // 카테고리명
				product.setCategory_code(rs.getString("category_code")); // 카테고리명

				
				System.out.println(product.getName());
				System.out.println(product.getProduct_number());
				System.out.println(product.getPrice());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.getAppMain().release(pstmt, rs);
		}

		System.out.println(sql);

	}
}
