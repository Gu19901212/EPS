package view;

/**
 * FileName: LogOn.java
 * 登录界面
 * @author Lipeishan，ZhangQin
 * @Date  2020.03.19
 */
import java.awt.Font;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import dao.LogOnDao;
import fuction.TimeTrigger;
import pojo.Admin;
import pojo.User;
import pojo.College;
import util.DbUtil;
import util.StringUtil;

/** 登录界面*/
public class LogOn extends JFrame {
	// 表示登录身份
	private ButtonGroup buttonGroup1;
	private JLabel jLabel1;
	// 账号标签
	private JLabel jLabel2;
	// 密码标签
	private javax.swing.JLabel jLabel3;
	private javax.swing.JButton jb_logOn;
	private javax.swing.JButton jb_reset;
	// 教师学生登录
	private javax.swing.JRadioButton userButton;
	// 学院登录
	private javax.swing.JRadioButton collegeButton;
	// 防控办登录
	private javax.swing.JRadioButton adminButton;
	private javax.swing.JFormattedTextField userNameTxt;
	private javax.swing.JPasswordField passwordTxt;
	// 数据库连接
	DbUtil dbutil = new DbUtil();
	LogOnDao logOnDao = new LogOnDao();
	// 用户实例
	public static User currentUser;
	// 学院实例
	public static College currentCollege;
	public static Admin currentAdmin;

	public LogOn() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.userButton.setSelected(true);
	}

	/*
	 * 页面布局
	 */
	private void initComponents() {
		buttonGroup1 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		userNameTxt = new javax.swing.JFormattedTextField();
		jLabel3 = new javax.swing.JLabel();
		userButton = new javax.swing.JRadioButton();
		collegeButton = new javax.swing.JRadioButton();
		adminButton = new javax.swing.JRadioButton();
		jb_logOn = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();
		passwordTxt = new javax.swing.JPasswordField();
		Font font = new java.awt.Font("楷体", 1, 15);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("用户登录");
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("楷体", 1, 24));
		jLabel1.setText("师生疫情每日上报系统");

		jLabel2.setFont(font);

		jLabel2.setText("账号");

		jLabel3.setFont(font);

		jLabel3.setText("密码");

		buttonGroup1.add(userButton);
		userButton.setFont(font);
		userButton.setText("学生/教师");

		buttonGroup1.add(collegeButton);
		collegeButton.setFont(font);
		collegeButton.setText("学院");

		buttonGroup1.add(adminButton);
		adminButton.setFont(font);
		adminButton.setText("防控办");

		jb_logOn.setFont(font);
		jb_logOn.setText("登录");
		jb_logOn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_logOnActionPerformed(evt);
			}
		});

		jb_reset.setFont(font);
		jb_reset.setText("重置");
		jb_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_resetActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(100, 100, 100)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1)

						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(jLabel3).addGap(30, 30, 30))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(30, 30, 30)))
								.addGap(6, 6, 6)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(passwordTxt, 0, 0, Short.MAX_VALUE)
										.addComponent(userNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 135,
												Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jb_logOn).addComponent(userButton))

														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addGroup(layout.createSequentialGroup()
																		.addGap(30, 30, 30).addComponent(jb_reset)

																)

																.addGroup(layout.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(layout.createSequentialGroup()
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGap(30, 30, 30)
																				.addComponent(collegeButton,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																		.addGap(30, 30, 30).addComponent(adminButton,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))))))
				.addContainerGap(143, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(77, Short.MAX_VALUE).addComponent(jLabel1)
						.addGap(39, 39, 39).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

								.addComponent(userButton).addComponent(collegeButton).addComponent(adminButton))
						.addGap(30, 30, 30)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jb_reset).addComponent(jb_logOn))
						.addGap(58, 58, 58)));

		pack();
	}

	/** 登录*/
	private void jb_logOnActionPerformed(java.awt.event.ActionEvent evt) {
		String userName = userNameTxt.getText();
		String password = new String(passwordTxt.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "账号不能为空");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空!");
			return;
		}
		Connection con = null;
		// 判断身份学生或者教师
		if (this.userButton.isSelected()) {
			User user = new User(Integer.parseInt(userName), password);
			try {
				con = dbutil.getCon();
				currentUser = logOnDao.login(con, user);
				if (currentUser != null) {
					this.dispose();
					new Main_user().timeTig();
					new Main_user().timeTigAlarm();
					new Main_user().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "用户名或密码错误!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "登录失败");
			} finally {
				try {
					dbutil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // 防控办登录
		else if (this.adminButton.isSelected()) {
			// User user = new User(Integer.parseInt(userName), password);
			Admin admin = new Admin(Integer.parseInt(userName), password);
			try {
				con = dbutil.getCon();
				currentAdmin = logOnDao.login(con, admin);
				// currentUser = logOnDao.login(con, user);
				if (currentAdmin != null) {
					this.dispose();
					//new Main_user().timeTig();
					new Main_admin().setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(this, "用户名或密码错误!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "登录失败!");
			} finally {
				try {
					dbutil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // 学院登录
		else if (this.collegeButton.isSelected()) {
			College college1 = new College(Integer.parseInt(userName), password);
			try {
				con = dbutil.getCon();
				currentCollege = logOnDao.login(con, college1);
				if (currentCollege != null) {
					this.dispose();
					new Main_college().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "用户名或密码错误!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "登录失败!");
			} finally {
				try {
					dbutil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/** 重置功能*/
	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}

	private void resetValue() {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		this.userButton.setSelected(true);
		this.collegeButton.setSelected(true);
		this.adminButton.setSelected(true);
	}


	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LogOn().setVisible(true);
			}
		});
	}

}