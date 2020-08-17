package collins.kent.tutor;

import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import collins.kent.tutor.strings.StringIndexOfProblem;

public class Tester {

	private JTree tree;

	public Tester() {
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(
				"Select your exercises:");
		addNodes(top);
		tree = new JTree(top);
		tree.setRootVisible(false);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				Arrays.stream(e.getPaths())
						.forEach(System.out::println);
				System.out.println("and no others.");
			}
		});
		JScrollPane treeView = new JScrollPane(tree);
		int dialog = JOptionPane.showConfirmDialog(null, treeView);
	}

	public static void main(String[] args) {
		Tester t = new Tester();
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			Problem p = new StringIndexOfProblem();
			p.generate(r);
			System.out.println(p.getStatement());
			String response = s.nextLine();
			if (!p.isCorrect(response)) {
				System.out.println(p.getFeedback(response));
			}
		}
		s.close();
	}

	void addNodes(DefaultMutableTreeNode top) {
		// add a branch for each package in the running directory
		File[] folders = null;
		folders = new File("./src/collins/kent/tutor/")
				.listFiles(File::isDirectory);
		Arrays.stream(folders).map(f -> f.getName()).forEach(s -> {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(s);
			for (int i = 0; i<3; i++) {
				node.add(new DefaultMutableTreeNode("Node: "+i));
			}
			top.add(node);
			System.out.println(s);
		});

	}

}
