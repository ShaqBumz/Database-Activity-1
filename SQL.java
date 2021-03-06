import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class SQL {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SQL window = new SQL();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SQL() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton btnCreate = new JButton("Create Table");
		btnCreate.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnCreate.setForeground(Color.BLACK);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Create a variable for the connection string.
				String connectionUrl = "jdbc:sqlserver://localhost:1433;"
						+ "databaseName= ShaqBumz;integratedSecurity=true;";
				
				
				
				// Declare the JDBC Objects.
				Connection con = null;
				Statement stmt = null;
				
				
				    try {
				        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				        con = DriverManager.getConnection(connectionUrl);
				        
				        
				        String myTableName = "CREATE TABLE Player (" 
					            + "PlayerID INT NOT NULL ,"  
					            + "Name CHAR(10) NOT NULL ," 
					            + "Age INT NOT NULL ,"  
					            + "Matches INT NOT NULL , "
					            + "PRIMARY KEY(PlayerID))";  
				        
				        
				        stmt = con.createStatement();
				        stmt.execute(myTableName);
				        
				        System.out.println("Table Created");
				    }
				    catch (SQLException e1 ) {
				        System.out.println("An error has occured on Table Creation");
				        e1.printStackTrace();
				    }
				    catch (ClassNotFoundException e1) {
				        System.out.println("An Mysql drivers were not found");
				    }
				}
				
			
		});
		frame.getContentPane().add(btnCreate, BorderLayout.CENTER);
	}

}
