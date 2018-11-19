import javax.swing.*;
import java.awt.*;

public class InfoWindow extends JFrame {
	public InfoWindow(MainWindow owner, String name, String version) {
		setTitle("情報");
		setSize(200, 100);

		setLocationRelativeTo(owner);

		JPanel panel = new JPanel();

		JLabel nameLabel = new JLabel(name);
		JLabel versionLabel = new JLabel(version);
		panel.add(nameLabel);
		panel.add(versionLabel);

		getContentPane().add(panel, BorderLayout.CENTER);
	}
}

