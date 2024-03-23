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
    private void Add() {
    	String task = textField.getText();
    	//nếu edt có dữ liệu nhập vào thì sẽ thêm dữ liệu đó vào 1 hàng trong table
    	if(!task.isEmpty()) {
    		tableModel.addRow(new Object[]{task});
    		textField.setText("");
    	}
    }
    private void Edit() {
    	//lấy chỉ số của dòng được chọnn
    	int selected = table.getSelectedRow();
    	if( selected != 0) {
    		String editTask = JOptionPane.showInputDialog(this, "Sửa công việc", tableModel.getValueAt(selected, 0));
    		//ktra xem người dùng có nhập dữ liệu mới vào hay không
    		if(editTask!= null && !editTask.isEmpty()) {
    			tableModel.setValueAt(editTask, selected, 0);
    		}
    		else
    			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 công việc để sửa","Thông báo", JOptionPane.WARNING_MESSAGE);
    	}
    }
    private void Delete() {
    	//lấy chỉ số của dòng được chọnn
    	int selected = table.getSelectedRow();
    	if( selected != 0) {
    		int confirm = JOptionPane.showConfirmDialog(this, "Xóa công việc đã chọn?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
    		//nếu chọn user chọn yes thì sẽ xóa đi hàng đã chọn
    		if(confirm == JOptionPane.YES_OPTION) {
    			tableModel.removeRow(selected);
    		}
    		else
    			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 công việc để xóa","Thông báo", JOptionPane.WARNING_MESSAGE);
    	}
    }
    private void Clear() {
    	int confirm = JOptionPane.showConfirmDialog(this, "Xóa tất cả công việc ???", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
    	if(confirm == JOptionPane.YES_OPTION) {
    		tableModel.setRowCount(0);
    	}
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QLCV();
            }
        });
    }
}
