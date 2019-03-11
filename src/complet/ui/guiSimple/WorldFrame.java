package complet.ui.guiSimple;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import complet.model.world.MondeAnimable;


public class WorldFrame extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * une instance du Monde animable
	 */
	private MondeAnimable monde;
	
	/**
	 * Thread d'éxécution
	 */
	private Thread thread;
	
	/**
	 * Label affichant les infos
	 */
	private JLabel labelInfo= new JLabel("Animation non démarrée");

	public WorldFrame(MondeAnimable m) {
		super("Le fabuleux monde des abeilles");
		/*
		 * initialisation des attributs
		 */
		this.monde = m;
		thread = new Thread(this);
		/*
		 * positionnement de la fenètre
		 */
		dimensionnerFenetre();
		/*
		 * construction des composants de la fenetre
		 */
		fabriqueFenetre();
		/*
		 * opération par défaut en cas de fermeture
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * affichage
		 */
		this.setVisible(true);
	}

	private void fabriqueFenetre() {
		Container panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		
		JPanel panStats = new JPanel();
		panStats.setBackground(Color.red);
		
		JPanel panInfo = new JPanel();
		panInfo.setBackground(Color.blue);
		panInfo.add(labelInfo);
		
		JPanel panCommandes = new JPanel();
		panCommandes.setBackground(Color.green);
		panCommandes.setLayout(new GridLayout(10,1));
		JButton btStart = new JButton("Start");
		JButton btStop = new JButton("Stop");
		panCommandes.add(btStart);
		panCommandes.add(btStop);
		
		btStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});		
		btStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stop();
			}	
		});
		
		JPanel panMonde = new PanneauPrincipal(monde);
		panMonde.setBackground(Color.orange);	
		
		panStats.setPreferredSize(new Dimension(200,0));
		panCommandes.setPreferredSize(new Dimension(200,50));
		panInfo.setPreferredSize(new Dimension(0,100));
		
		panneau.add(panStats,BorderLayout.WEST);
		panneau.add(panInfo,BorderLayout.SOUTH);
		panneau.add(panCommandes,BorderLayout.EAST);
		panneau.add(panMonde,BorderLayout.CENTER);
		
		setContentPane(panneau);
	}

	/**
	 * lance l'animation
	 */
	private void stop() {
		monde.stopperAnimation();
		
		labelInfo.setText("Animation en pause");
	}

	private void start() {
		monde.lancerAnimation();
		if(!thread.isAlive()) {
			thread.start();
		}

		labelInfo.setText("Animation en cours");
	}

	private void dimensionnerFenetre() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		dim.height = dim.height/3*2;
		dim.width = dim.width/3*2;
		this.setPreferredSize(dim);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	

}
