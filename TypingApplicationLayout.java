

import javax.swing.*;
import java.awt.*;
public class TypingApplicationLayout extends JFrame {
	private JTabbedPane tabbedPane;
	private JPanel mainPanel;
	private JPanel keyPane;
	private JPanel pangPanel;
	private JPanel histPanel;
	private JPanel labelPanel;
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
	private GridBagLayout mainLayout;
	
	public TypingApplicationLayout(){
		super("Typing App");
		setLayout(new BorderLayout());
		
		tabbedPane = new JTabbedPane();
		
		textA = new JTextArea(10,10);
		
		mainPanel = new JPanel();//Inicializando main panel do teclado
		mainLayout = new GridBagLayout();
		mainPanel.setLayout(mainLayout);
		constraints = new GridBagConstraints();
		JPanel textPane = new JPanel();//Criando panel para TextArea
		textPane.add(textA);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		mainLayout.setConstraints(textPane, constraints);
		mainPanel.add(textPane);
		
		labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(2,1));
		
		labelPangrama = new JLabel("Teste sua habilidade escolhendo um pangrama");
		labelPanel.add(labelPangrama);
		
		labelResult = new JLabel("dasdasd");
		labelPanel.add(labelResult);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		mainLayout.setConstraints(labelPanel, constraints);
		mainPanel.add(labelPanel);
		
		keyPane = new JPanel();//Criando panel do teclado
		keyLayout = new GridBagLayout();
		keyPane.setLayout(keyLayout);
		teclado = new JButton[teclas.length];// inicializando os botoes
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
		
		
		
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		mainLayout.setConstraints(keyPane, constraints);
		mainPanel.add(keyPane);
		tabbedPane.addTab("Teclado",null,mainPanel,"Teste sua habilidade!");
		
		pangPanel = new JPanel();
		tabbedPane.addTab("Teste Pangrama",null, pangPanel,"Escolha um desafio!");
		
		histPanel = new JPanel();
		tabbedPane.addTab("Histórico", null, histPanel, "Veja seu historico!");
		
		add(tabbedPane);
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
		TypingApplicationLayout test = new TypingApplicationLayout();
		test.setSize(1080, 720);
		test.setDefaultCloseOperation(EXIT_ON_CLOSE);
		test.setVisible(true);
	}
	
}
