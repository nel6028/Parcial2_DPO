package presentacion;

import logica.Parcial;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FPrincipal extends JFrame {
	 
	private JPanel panel;
	private JPanel panelA;
	private JPanel panelB;
	private JPanel panelC;
	
	private Parcial parcial;
	private JLabel a;
	private JLabel b;
	private JLabel c;
	private JTextField campoA;
	private JTextField campoB;
	private JTextField campoC;
	private JButton botonCalcular;
	private JTextArea resultado;
	
	
	public FPrincipal() {
		
		this.parcial = new Parcial();

	    this.setTitle("Calculadora de ecuaciones cuadraticas");
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setBounds((int)pantalla.getWidth()/2 - 200,(int)pantalla.getHeight()/2 - 300, 400, 600);

	    this.panel = new JPanel(new GridLayout(2, 1));

	    panel.setBorder(BorderFactory.createEmptyBorder(30, 25, 30, 25));

	    this.a = new JLabel("a");
	    this.b = new JLabel("b");
	    this.c = new JLabel("c");

	    this.campoA = new JTextField(15);
	    this.campoB = new JTextField(15);
	    this.campoC = new JTextField(15);

	    this.panelA = new JPanel();
	    this.panelB = new JPanel();
	    this.panelC = new JPanel();

	    panelA.setLayout(new BoxLayout(panelA, BoxLayout.Y_AXIS));
	    panelB.setLayout(new BoxLayout(panelB, BoxLayout.Y_AXIS));
	    panelC.setLayout(new BoxLayout(panelC, BoxLayout.Y_AXIS));

	    panelA.add(a);
	    panelA.add(campoA);

	    panelB.add(b);
	    panelB.add(campoB);

	    panelC.add(c);
	    panelC.add(campoC);

	    Dimension tamano = new Dimension(100, 30);

	    campoA.setMaximumSize(tamano);
	    campoB.setMaximumSize(tamano);
	    campoC.setMaximumSize(tamano);

	    JPanel panelSuperior = new JPanel(new GridLayout(1, 3));

	    panelSuperior.add(panelA);
	    panelSuperior.add(panelB);
	    panelSuperior.add(panelC);

	    panel.add(panelSuperior);

	    this.botonCalcular = new JButton("Calcular");

	    JPanel panelBoton = new JPanel();
	    panelBoton.add(botonCalcular);

	    this.resultado = new JTextArea();
	    resultado.setEditable(false);

	    JPanel panelInferior = new JPanel(new BorderLayout());

	    panelInferior.add(panelBoton, BorderLayout.NORTH);
	    panelInferior.add(new JScrollPane(resultado), BorderLayout.CENTER);

	    panel.add(panelInferior);

	    this.add(panel);

	    this.setVisible(true);
		
		botonCalcular.addActionListener(e -> {

		    try {

		        double A = Double.parseDouble(campoA.getText());
		        double B = Double.parseDouble(campoB.getText());
		        double C = Double.parseDouble(campoC.getText());

		        String respuesta = parcial.Cuadratica(A, B, C);

		        resultado.setText(respuesta);

		    } catch (Exception ex) {

		        resultado.setText(ex.getMessage());

		    }

		});
	}
	
	public static void main(String[] args) {
		new FPrincipal();
	}
	
	

	

}
