import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
	public MainWindow() {
		final String title = "讀書管理";
		final String version = "0.0.1";

		// ウィンドウ設定 ---------------------------------------------------
		setTitle(title);
		setSize(500, 505);
		setResizable(false);

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

		JPanel bookListPanel = new JPanel();
		String[][] data = {
				{"量子力学", "わい", "物理"},
				{"哲学", "あああ", "数学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"},
				{"電気回路", "あの人", "工学"}
		};
		String[] columns = {"題", "著者", "分野"};
		JTable bookList = new JTable(data, columns);
		JScrollPane bookListPane = new JScrollPane(bookList);
		bookListPane.setPreferredSize(new Dimension(480, 400));

		JButton addButton = new JButton("追加");
		JButton editButton = new JButton("編輯");
		JButton deleteButton = new JButton("削除");
		bookListPanel.add(bookListPane);
		bookListPanel.add(addButton);
		bookListPanel.add(editButton);
		bookListPanel.add(deleteButton);


		JPanel unreadPanel = new JPanel();
		JTable unreadList = new JTable(data, columns);
		JScrollPane unreadListPane = new JScrollPane(unreadList);
		unreadListPane.setPreferredSize(new Dimension(480, 400));

		JButton openButton = new JButton("開巻");
		unreadPanel.add(unreadListPane);
		unreadPanel.add(openButton);


		JPanel readingPanel = new JPanel();
		JTable readingList = new JTable(data, columns);
		JScrollPane readingListPane = new JScrollPane(readingList);
		readingListPane.setPreferredSize(new Dimension(480, 400));
		
		JButton readButton = new JButton("読了");
		readingPanel.add(readingListPane);
		readingPanel.add(readButton);
		
		
		JPanel readPanel = new JPanel();
		JTable readList = new JTable(data, columns);
		JScrollPane readListPane = new JScrollPane(readList);
		readListPane.setPreferredSize(new Dimension(480, 400));
		readPanel.add(readListPane);

		tabbedPane.add("文書一覧", bookListPanel);
		tabbedPane.add("未読", unreadPanel);
		tabbedPane.add("読中", readingPanel);
		tabbedPane.add("既読", readPanel);

		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		// -----------------------------------------------------------------
	}
}

