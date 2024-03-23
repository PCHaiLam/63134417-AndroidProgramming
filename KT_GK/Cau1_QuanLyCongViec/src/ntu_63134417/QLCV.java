package ntu_63134417;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class QLCV extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;
    
    public QLCV() {
        setTitle("Quản Lý Công Việc");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        
        //main chứa các thành phần
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
      //button
        JPanel buttonPanel = new JPanel();
        
        JButton addButton = new JButton("Thêm");
        addButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Add();
        	}
        });
        buttonPanel.add(addButton);

        JButton editButton = new JButton("Sửa");
        editButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Edit();
        	}
        });
        buttonPanel.add(editButton);
        
        JButton deleteButton = new JButton("Xóa");
        deleteButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Delete();
        	}
        });
        buttonPanel.add(deleteButton);
        
        JButton clearButton = new JButton("Xóa tất cả");
        clearButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Clear();
        	}
        });
        buttonPanel.add(clearButton);
        
      //input
        JPanel inputPanel = new JPanel();
        mainPanel.add(inputPanel);
        
        JLabel lblNewLabel = new JLabel("Nhập CV ");
        inputPanel.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setColumns(10);
        //thêm textfield và buttonpanel vào inputPanel
        inputPanel.add(textField, BorderLayout.CENTER);
        inputPanel.add(buttonPanel, BorderLayout.EAST);
        
      //table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Công Việc");
        
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane,BorderLayout.CENTER);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QLCV();
            }
        });
    }
}
