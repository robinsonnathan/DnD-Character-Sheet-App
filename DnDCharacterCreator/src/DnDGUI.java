import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;

public class DnDGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	boolean createNew;
	private JButton btnNewCharacter;
	private JButton btnExistingCharacter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DnDGUI frame = new DnDGUI();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DnDGUI() {
		setBackground(Color.GRAY);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 400, 442, 274);
		setTitle("D&D Character Builder");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblTitle = new JLabel("Welcome To The D&D Character Builder");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(6, 6, 1, 61);
		contentPane.add(lblTitle, BorderLayout.NORTH);
		lblTitle.setBorder(new EmptyBorder(10, 10, 20, 20));

		btnNewCharacter = new JButton("Create a New Character");
		btnNewCharacter.setBounds(1000, 95, 200, 131);
		contentPane.add(btnNewCharacter, BorderLayout.WEST);
		btnNewCharacter.setPreferredSize(new Dimension(195, 400));

		btnExistingCharacter = new JButton("Import Existing Character");
		btnExistingCharacter.setBounds(229, 95, 200, 131);
		contentPane.add(btnExistingCharacter, BorderLayout.EAST);
		btnExistingCharacter.setPreferredSize(new Dimension(175, 400));

		Component horizontalGlue = Box.createHorizontalGlue();
		contentPane.add(horizontalGlue, BorderLayout.CENTER);

		btnNewCharacter.addActionListener(this);
		btnExistingCharacter.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewCharacter) {
			createNew = true;
			this.dispose();
			new CharacterSheetEditor(createNew);
		}

		if (e.getSource() == btnExistingCharacter) {
			createNew = false;
			this.dispose();
			new CharacterSheetEditor(createNew);
		}

	}
}
