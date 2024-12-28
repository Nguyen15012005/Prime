package entity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Prime extends JFrame implements ActionListener {
    private JTextField txtN;
    private JButton btnN;
    private JTextArea lstN;
    
    public Prime() {
        this.setTitle("Primes");
        this.setSize(400, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        
        // Tạo các thành phần giao diện
        this.txtN = new JTextField(15);
        this.btnN = new JButton("Generator");
        this.lstN = new JTextArea();
        lstN.setEditable(false);  // Chỉ hiển thị, không cho chỉnh sửa
        lstN.setLineWrap(true);  // Tự động xuống dòng
        lstN.setWrapStyleWord(true);  // Đảm bảo không cắt từ khi xuống dòng

        // Thêm Border cho JTextArea với padding bên ngoài
//        int top = 10, left = 20, bottom = 10, right = 20;
        
        // Tạo border cho viền trong
        Border innerBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        // Tạo padding bên ngoài
        Border outerPadding = new EmptyBorder(20, 74, 40, 74);
        
        // Kết hợp padding và border
        lstN.setBorder(BorderFactory.createCompoundBorder(outerPadding, innerBorder));

        // Bố cục cho các thành phần
        JPanel p1 = new JPanel();
        p1.add(txtN);
        p1.add(btnN);
        
        JScrollPane p2 = new JScrollPane(lstN); // Tạo cuộn cho JTextArea
        
        // Cấu hình Container
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout()); // Đảm bảo sử dụng BorderLayout
        container.add(BorderLayout.NORTH, p1);
        container.add(BorderLayout.CENTER, p2);

        // Thêm hành động cho nút "Generator"
        this.btnN.addActionListener(this);
        
        // Hiển thị cửa sổ
        this.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnN)) {
			this.lstN.setText("");
			int n = Integer.parseInt(txtN.getText());
			if (n < 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên dương!");
				this.txtN.setText("");
				this.requestFocus();
			}
			else {
				for (int i = 2; i < Integer.MAX_VALUE; i++) {
					if(isPrime(i)) {
						lstN.append(i + "\n");
						n--;
					}
					if(n == 0) {
						break;
					}
				}
			}
		}
	}
	
	private boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
}
