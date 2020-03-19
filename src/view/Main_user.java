package view;
/*
 *  FileName: Main_user.java
 *  ʦ����Ϣ��д����
 *  @author Lipeishan��ZhangQin
 *  @Date  2020.03.19
 */
import java.sql.Connection;

import javax.swing.JOptionPane;

import java.util.Calendar;

import java.util.Date;

import java.util.Timer;


import dao.UserDao;
import fuction.TimeTrigger;
import pojo.User;
import util.Dbutil;
import util.FloatUtil;
import util.IntUtil;
import util.StringUtil;

public class Main_user extends javax.swing.JFrame {
	// id
	private javax.swing.JTextField userIDTxt;
	// ����
	private javax.swing.JTextField userNameTxt;
	// �Ա�
	private javax.swing.JTextField userSexTxt;
	// ʡ��
	private javax.swing.JTextField userProTxt;
	// ����
	private javax.swing.JTextField userCityTxt;
	// �¶�
	private javax.swing.JTextField userTemperatureTxt;
	// �Ƿ�����
	private javax.swing.JTextField userSymptom;
	// �Ƿ�ȷ��
	private javax.swing.JTextField userCheck;

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JButton jb_reset;
	private javax.swing.JButton jb_add;

	Dbutil dbUtil = new Dbutil();
	UserDao userDao = new UserDao();

	public Main_user() {
		initComponents();
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		
	}

	/*
	 * ҳ������
	 */
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		userIDTxt = new javax.swing.JTextField();
		userNameTxt = new javax.swing.JTextField();
		userSexTxt = new javax.swing.JTextField();
		userProTxt = new javax.swing.JTextField();
		userCityTxt = new javax.swing.JTextField();
		userTemperatureTxt = new javax.swing.JTextField();
		userSymptom = new javax.swing.JTextField();
		userCheck = new javax.swing.JTextField();
		jb_add = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();

		setTitle("������Ϣ���");

		jLabel1.setText("ѧ��/����");

		jLabel2.setText("  ����      ");

		jLabel3.setText("����ʡ��");

		jLabel4.setText("���ڳ��� ");

		jLabel5.setText("  �Ա�      ");

		jLabel6.setText("�������� ");

		jLabel7.setText("�Ƿ�����");

		jLabel8.setText("�Ƿ�ȷ��");

		jb_add.setText("ȷ��");
		/*
		 * ���ȷ�ϼ���
		 */
		jb_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_addActionPerformed(evt);
			}
		});

		jb_reset.setText("����");
		jb_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_resetActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(41, 41, 41)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
										userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE))

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(userProTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jb_add))
								.addGap(60, 60, 60)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(userCityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jb_reset)))

						.addGroup(layout.createSequentialGroup().addComponent(jLabel5)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userSexTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel6)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userTemperatureTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addComponent(jLabel7)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userSymptom, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel8)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(44, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(46, 46, 46)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jLabel2)
								.addComponent(userIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jLabel4)
								.addComponent(userProTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userCityTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(jLabel6)
								.addComponent(userSexTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userTemperatureTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(jLabel8)
								.addComponent(userSymptom, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userCheck, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(5, 5, 5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jb_reset).addComponent(jb_add))
						.addGap(20, 20, 20)));

		pack();

	}

	/*
	 * �����Ϣ
	 */
	private void jb_addActionPerformed(java.awt.event.ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String userId = this.userIDTxt.getText();
		String userSex = this.userSexTxt.getText();
		String userTemperature = this.userTemperatureTxt.getText();
		String userPro = this.userProTxt.getText();
		String userCity = this.userCityTxt.getText();
		String userSympotom = this.userSymptom.getText();
		String userCheck = this.userCheck.getText();
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "��������Ϊ��!");
			return;
		}
		if (IntUtil.isEmpty(Integer.parseInt(userId))) {
			JOptionPane.showMessageDialog(this, "����/ѧ�Ų���Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userSex)) {
			JOptionPane.showMessageDialog(this, "�Ա���Ϊ��!");
			return;
		}
		if (FloatUtil.isEmpty(Float.parseFloat(userTemperature))) {
			JOptionPane.showMessageDialog(this, "�������²���Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userPro)) {
			JOptionPane.showMessageDialog(this, "����ʡ�ݲ���Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userCity)) {
			JOptionPane.showMessageDialog(this, "���ڳ��в���Ϊ��!");
			return;
		}

		if (StringUtil.isEmpty(userSympotom)) {
			JOptionPane.showMessageDialog(this, "�����������Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userCheck)) {
			JOptionPane.showMessageDialog(this, "ȷ���������Ϊ��!");
			return;
		}
		java.util.Date curDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(curDate.getTime());

		User user = new User(Integer.parseInt(userId), userName, userSex, Float.parseFloat(userTemperature), userPro,
				userCity, userSympotom, userCheck, date);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = userDao.userAdd(con, user);
			if (n == 1) {
				JOptionPane.showMessageDialog(this, "��ӳɹ�!");
				this.resetValue();
			} else {
				JOptionPane.showMessageDialog(this, "���ʧ��!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "���ʧ��!");
		}

	}

	/*
	 * ����
	 */
	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}

	/*
	 * �������
	 */
	private void resetValue() {
		this.userIDTxt.setText("");
		this.userNameTxt.setText("");
		this.userSexTxt.setText("");
		this.userTemperatureTxt.setText("");
		this.userProTxt.setText("");
		this.userCityTxt.setText("");
		this.userSymptom.setText("");
		this.userCheck.setText("");
	}
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

	private static final long TEST_SEC = 15 * 1000;
	
	public void timeTig() {

		// ʹ��Ĭ��ʱ�������Ի������һ������

		Calendar calendar = Calendar.getInstance();

		// ����ʱ��

		calendar.set(Calendar.HOUR_OF_DAY, 9);// Сʱ

		calendar.set(Calendar.MINUTE, 55);// ����

		calendar.set(Calendar.SECOND, 0);// ��

		// ��һ��ִ�������ʱ��

		Date time = calendar.getTime();

		// �����һ��ִ�������ʱ�����ڵ�ǰʱ�䣬��ô��һ��ִ�������ʱ���Ƴ�һ��

		if (time.before(new Date())) {

			time = addDay(time, 1);

		}

		//System.out.println("����ʱ��:" + time);

		// �����ƻ�

		Timer timer = new Timer();

		timer.schedule(new TimeTrigger(), time, PERIOD_DAY);

		//System.out.println("��ǰʱ��:" + new Date());

	}

 

	// ����һ��

	public Date addDay(Date date, int num) {
		JOptionPane.showMessageDialog(null,"�����ʱ��!");

		Calendar startDT = Calendar.getInstance();

		startDT.setTime(date);

		startDT.add(Calendar.DAY_OF_MONTH, num);

		return startDT.getTime();

	}

 

	// ����һ����

	public Date addMinute(Date date, int num) {

		System.out.println("����һ����");

		Calendar startDT = Calendar.getInstance();

		startDT.setTime(date);

		startDT.add(Calendar.MINUTE, num);

		return startDT.getTime();

	}

 
	/*
	public static void main(String[] args) {
		new Main_user().setVisible(true);
		new Main_user().timeTig();	
		}
	 
*/
}
