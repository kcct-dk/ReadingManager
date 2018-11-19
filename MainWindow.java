import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
	public MainWindow() {
		final String title = "讀書管理";
		final String version = "0.0.1";

		// ウィンドウ設定 ---------------------------------------------------
		setTitle(title);
		setSize(400, 400);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		// ------------------------------------------------------------------

		// メニューバー設定 -------------------------------------------------
		JMenuBar menuBar = new JMenuBar();
		
		JMenu systemMenu = new JMenu("システム");
		JCheckBoxMenuItem setOnTopItem = new JCheckBoxMenuItem("常に最前面に表示");
		setOnTopItem.addActionListener(
			(ActionEvent e) -> {
				setAlwaysOnTop(setOnTopItem.isSelected());
			}
		);
		JMenuItem infoItem = new JMenuItem("情報");
		infoItem.addActionListener(
			(ActionEvent e) -> {
				InfoWindow infoWindow = new InfoWindow(this, title, version);
				infoWindow.setVisible(true);
			}
		);
		JMenuItem exitItem = new JMenuItem("終了");
		exitItem.addActionListener(
			(ActionEvent e) -> {
				System.exit(0);
			}
		);
		systemMenu.add(setOnTopItem);
		systemMenu.addSeparator();
		systemMenu.add(infoItem);
		systemMenu.add(exitItem);
		menuBar.add(systemMenu);

		JMenu bookMenu = new JMenu("文書");
		JMenuItem addBookItem = new JMenuItem("追加");
		JMenuItem editBookItem = new JMenuItem("編輯");
		JMenuItem deleteBookItem = new JMenuItem("削除");
		bookMenu.add(addBookItem);
		bookMenu.add(editBookItem);
		bookMenu.add(deleteBookItem);
		menuBar.add(bookMenu);

		setJMenuBar(menuBar);
		// -----------------------------------------------------------------

		// タブペイン設定 --------------------------------------------------
		JTabbedPane tabbedPane = new JTabbedPane();

		JPanel bookPanel = new JPanel();
		JPanel unreadPanel = new JPanel();
		JPanel readingPanel = new JPanel();
		JPanel readPanel = new JPanel();
		tabbedPane.add("文書一覧", bookPanel);
		tabbedPane.add("未読", unreadPanel);
		tabbedPane.add("読中", readingPanel);
		tabbedPane.add("既読", readPanel);

		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		// -----------------------------------------------------------------
	}
}

