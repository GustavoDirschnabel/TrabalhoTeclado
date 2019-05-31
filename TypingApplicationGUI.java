

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class TypingApplicationGUI extends JFrame {

	private JTabbedPane tabbedPane;
	private JPanel mainPanel;
	private JPanel keyPane;
	private JPanel pangPanel;
	private JPanel histPanel;
	private JPanel labelPanel;
	
	private JTextArea textHist;
	private JTextArea textA;
	
	private JLabel labelPangrama;
	private JLabel labelResult;
	
	private JButton[] teclado;
	private final String[] teclas = {"~","1","2","3","4","5","6","7","8","9","0","-","+","Backspace",
			"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\",
			"Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter",
			"Shift","Z","X","C","V","B","N","M",",",".","?","^",
			"                                 ","<","v",">"};
	
	private GridBagConstraints constraints;
	private GridBagLayout keyLayout;
	
	private JRadioButton pangrama1;
	private JRadioButton pangrama2;
	private JRadioButton pangrama3;
	private JRadioButton pangrama4;
	private JRadioButton pangrama5;
	
	private String pangramaAtual;
	
	public TypingApplicationGUI(){
		super("Typing App");
		setLayout(new BorderLayout());
		
		tabbedPane = new JTabbedPane();
		
		//Inicializando a primeira tab
		
		textA = new JTextArea(10,10);
		textA.setPreferredSize(new Dimension(1070,550));
		
		mainPanel = new JPanel();//Inicializando main panel do teclado
		mainPanel.setLayout(new BorderLayout());
		JPanel textPane = new JPanel();//Criando panel para TextArea
		textPane.add(textA);
		mainPanel.add(textPane,BorderLayout.NORTH);
		
		
		textPane.setPreferredSize(new Dimension(500, 400));
		textPane.grabFocus();
		
		labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(2,1));
		
		labelPangrama = new JLabel("Teste sua habilidade escolhendo um pangrama");
		labelPanel.add(labelPangrama);
		
		labelResult = new JLabel("");
		labelPanel.add(labelResult);
		mainPanel.add(labelPanel,BorderLayout.CENTER);
		
		keyPane = new JPanel();//Criando panel do teclado
		keyLayout = new GridBagLayout();
		keyPane.setLayout(keyLayout);
		teclado = new JButton[teclas.length];// inicializando os botoes
		constraints = new GridBagConstraints();
		
		for(int i = 0; i < teclas.length ; i++) {
			teclado[i] = new JButton(teclas[i]);
		}
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(2,2,2,2);
		
		addComponent(teclado[0],0,0,1,1);
		addComponent(teclado[1],0,1,1,1);
		addComponent(teclado[2],0,2,1,1);
		addComponent(teclado[3],0,3,1,1);
		addComponent(teclado[4],0,4,1,1);
		addComponent(teclado[5],0,5,1,1);
		addComponent(teclado[6],0,6,1,1);
		addComponent(teclado[7],0,7,1,1);
		addComponent(teclado[8],0,8,1,1);
		addComponent(teclado[9],0,9,1,1);
		addComponent(teclado[10],0,10,1,1);
		addComponent(teclado[11],0,11,1,1);
		addComponent(teclado[12],0,12,1,1);
		addComponent(teclado[13],0,13,2,1);
		addComponent(teclado[14],1,0,2,1);
		addComponent(teclado[15],1,2,1,1);
		addComponent(teclado[16],1,3,1,1);
		addComponent(teclado[17],1,4,1,1);
		addComponent(teclado[18],1,5,1,1);
		addComponent(teclado[19],1,6,1,1);
		addComponent(teclado[20],1,7,1,1);
		addComponent(teclado[21],1,8,1,1);
		addComponent(teclado[22],1,9,1,1);
		addComponent(teclado[23],1,10,1,1);
		addComponent(teclado[24],1,11,1,1);
		addComponent(teclado[25],1,12,1,1);
		addComponent(teclado[26],1,13,1,1);
		addComponent(teclado[27],1,14,1,1);
		addComponent(teclado[28],2,0,2,1);
		addComponent(teclado[29],2,2,1,1);
		addComponent(teclado[30],2,3,1,1);
		addComponent(teclado[31],2,4,1,1);
		addComponent(teclado[32],2,5,1,1);
		addComponent(teclado[33],2,6,1,1);
		addComponent(teclado[34],2,7,1,1);
		addComponent(teclado[35],2,8,1,1);
		addComponent(teclado[36],2,9,1,1);
		addComponent(teclado[37],2,10,1,1);
		addComponent(teclado[38],2,11,1,1);
		addComponent(teclado[39],2,12,1,1);
		addComponent(teclado[40],2,13,2,1);
		addComponent(teclado[41],3,0,2,1);
		addComponent(teclado[42],3,2,1,1);
		addComponent(teclado[43],3,3,1,1);
		addComponent(teclado[44],3,4,1,1);
		addComponent(teclado[45],3,5,1,1);
		addComponent(teclado[46],3,6,1,1);
		addComponent(teclado[47],3,7,1,1);
		addComponent(teclado[48],3,8,1,1);
		addComponent(teclado[49],3,9,1,1);
		addComponent(teclado[50],3,10,1,1);
		addComponent(teclado[51],3,11,1,1);
		addComponent(teclado[52],3,13,1,1);
		addComponent(teclado[53],4,4,6,1);
		addComponent(teclado[54],4,12,1,1);
		addComponent(teclado[55],4,13,1,1);
		addComponent(teclado[56],4,14,1,1);
		
		KeyHandler kh = new KeyHandler();
		textA.addKeyListener(kh);
		
		keyPane.setPreferredSize(new Dimension(400,250));
		mainPanel.add(keyPane,BorderLayout.SOUTH);
		tabbedPane.addTab("Teclado",null,mainPanel,"Teste sua habilidade!");
		
		//Inicializando a segunda tab
		
		pangPanel = new JPanel();
		pangPanel.setLayout(new GridLayout(5,1));
		
		pangrama1 = new JRadioButton("Um pequeno jabuti xereta viu dez cegonhas felizes (42 letras)");
		pangrama2 = new JRadioButton("Quem traz CD, LP, fax, engov e whisky JB? (29 letras)");
		pangrama3 = new JRadioButton("Gazeta publica hoje breve nota de faxina na quermesse (46 letras)");
		pangrama4 = new JRadioButton("Jovem craque belga prediz falhas no xote (34 letras)");
		pangrama5 = new JRadioButton("Bancos fúteis pagavam-lhe queijo, whisky e xadrez (41 letras)");
		
		pangPanel.add(pangrama5);
		pangPanel.add(pangrama4);
		pangPanel.add(pangrama3);
		pangPanel.add(pangrama2);
		pangPanel.add(pangrama1);
		
		ButtonGroup grupoRadio = new ButtonGroup();
		grupoRadio.add(pangrama5);
		grupoRadio.add(pangrama4);
		grupoRadio.add(pangrama3);
		grupoRadio.add(pangrama2);
		grupoRadio.add(pangrama1);
			
		OuvidorRadioButton handler = new OuvidorRadioButton();
		pangrama5.addItemListener(handler);
		pangrama4.addItemListener(handler);
		pangrama3.addItemListener(handler);
		pangrama2.addItemListener(handler);
		pangrama1.addItemListener(handler);
		
		tabbedPane.addTab("Teste Pangrama",null, pangPanel,"Escolha um desafio!");
		
		//Inicializando a terceira tab
		
		histPanel = new JPanel();
		
		textHist = new JTextArea();
		textHist.setPreferredSize(new Dimension(1070,720));
		textHist.setEditable(false);
		textHist.setText("fasd");
		histPanel.add(textHist);
		
		tabbedPane.addTab("Histórico", null, histPanel, "Veja seu historico!");
		
		add(tabbedPane);
		

	}
	
	private class OuvidorRadioButton implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource() == pangrama1) {
				labelPangrama.setText("Um pequeno jabuti xereta viu dez cegonhas felizes");
				pangramaAtual = "Um pequeno jabuti xereta viu dez cegonhas felizes";
			}
			else if (e.getSource() == pangrama2) {
				labelPangrama.setText("Quem traz CD, LP, fax, engov e whisky JB?");
				pangramaAtual = "Quem traz CD, LP, fax, engov e whisky JB?";
			}
			else if(e.getSource() == pangrama3) {
				labelPangrama.setText("Gazeta publica hoje breve nota de faxina na quermesse");
				pangramaAtual = "Gazeta publica hoje breve nota de faxina na quermesse";
			}
			else if(e.getSource() == pangrama4) {
				labelPangrama.setText("Jovem craque belga prediz falhas no xote");
				pangramaAtual = "Jovem craque belga prediz falhas no xote";
			}
			else if(e.getSource() == pangrama5) {
				labelPangrama.setText("Bancos fúteis pagavam-lhe queijo, whisky e xadrez");
				pangramaAtual = "Bancos fúteis pagavam-lhe queijo, whisky e xadrez";
			}
			
		}
		
	}
	
	private class KeyHandler implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getKeyChar());
			System.out.println(e.getExtendedKeyCode());
			if(e.getKeyCode() == KeyEvent.VK_Q) {
				teclado[1].setBackground(Color.BLACK);
				
			}
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridheight = height;
		constraints.gridwidth = width;
		
		keyLayout.setConstraints(component, constraints);
		keyPane.add(component);
	}
	
	public static void main(String args[]) {
		TypingApplicationGUI test = new TypingApplicationGUI();
		test.setSize(1080, 720);
		test.setDefaultCloseOperation(EXIT_ON_CLOSE);
		test.setVisible(true);
		test.setResizable(false);
	}
	
}
