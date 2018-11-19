import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			MainWindow mainWindow = new MainWindow();
			mainWindow.setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			System.out.println("[エラー] システム標準の外観設定に失敗");
			e.printStackTrace();
		}
	}
}

