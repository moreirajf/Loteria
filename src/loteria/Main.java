package loteria;
/**
 * Created by zefrancisco on 16/05/17.
 */

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame {

private JPanel contentPane;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField textField_6;
private JTextField textField_7;
private JTextField textField_8;
private JTextField textField_9;
private JTextField textField_10;
private JTextField textField_11;
private JPanel panel_6;
private JTextPane txtpnQuadra;
private JPanel panel_7;
private JTextPane txtpnGanhadores;
private JTextField textField_12;
private JTextField textField_13;
private JTextField textField_14;

private ArrayList <Jogo> volantes = new ArrayList <>();

private ArrayList <Integer> ganhadores = new ArrayList <>();
private ArrayList<Jogo> jogo6 = new ArrayList <>();
private ArrayList<Jogo> jogo5 = new ArrayList <>();
private ArrayList<Jogo> jogo4 = new ArrayList <>();
private int sena = 0, quina = 0, quadra = 0;


/**
* Launch the application.
*/
public static void main(String args[]) {
EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {
            Main frame = new Main();
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
public Main() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 300);
contentPane = new JPanel();
contentPane.setBackground(Color.LIGHT_GRAY);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JPanel panel = new JPanel();
panel.setBackground(Color.LIGHT_GRAY);
FlowLayout flowLayout = (FlowLayout) panel.getLayout();
flowLayout.setAlignOnBaseline(true);
flowLayout.setAlignment(FlowLayout.LEFT);
panel.setBorder(new EmptyBorder(0, 0, 0, 0));
panel.setBounds(12, 12, 257, 42);
contentPane.add(panel);

textField = new JTextField();
panel.add(textField);
textField.setColumns(3);

textField_1 = new JTextField();
panel.add(textField_1);
textField_1.setColumns(3);

textField_2 = new JTextField();
panel.add(textField_2);
textField_2.setColumns(3);

textField_3 = new JTextField();
panel.add(textField_3);
textField_3.setColumns(3);

textField_4 = new JTextField();
panel.add(textField_4);
textField_4.setColumns(3);

textField_5 = new JTextField();
panel.add(textField_5);
textField_5.setColumns(3);

JPanel panel_1 = new JPanel();
panel_1.setBackground(Color.LIGHT_GRAY);
panel_1.setBounds(281, 12, 157, 42);
contentPane.add(panel_1);

JButton btnRegistrar = new JButton("Registrar");
btnRegistrar.addActionListener(new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent arg0) {
        cadastrar();

    }});
panel_1.add(btnRegistrar);

JPanel panel_2 = new JPanel();
panel_2.setBackground(Color.LIGHT_GRAY);
panel_2.setBounds(22, 54, 416, 35);
contentPane.add(panel_2);

JButton btnSortear = new JButton("Sortear");
btnSortear.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!volantes.isEmpty()){
        verificarGanha(volantes, sortear());
        resuntados(jogo6,jogo5,jogo4);
        resetValues();
        }else {
            JOptionPane.showMessageDialog(null,"Nenhum Jogo Cadastrado!");
        }
    }
});
panel_2.add(btnSortear);

JPanel panel_3 = new JPanel();
panel_3.setBackground(Color.LIGHT_GRAY);
panel_3.setBounds(12, 89, 426, 42);
contentPane.add(panel_3);

textField_6 = new JTextField();
textField_6.setBackground(Color.LIGHT_GRAY);
textField_6.setEditable(false);
textField_6.setColumns(3);
panel_3.add(textField_6);

textField_7 = new JTextField();
textField_7.setBackground(Color.LIGHT_GRAY);
textField_7.setEditable(false);
textField_7.setColumns(3);
panel_3.add(textField_7);

textField_8 = new JTextField();
textField_8.setBackground(Color.LIGHT_GRAY);
textField_8.setEditable(false);
textField_8.setColumns(3);
panel_3.add(textField_8);

textField_9 = new JTextField();
textField_9.setBackground(Color.LIGHT_GRAY);
textField_9.setEditable(false);
textField_9.setColumns(3);
panel_3.add(textField_9);

textField_10 = new JTextField();
textField_10.setBackground(Color.LIGHT_GRAY);
textField_10.setEditable(false);
textField_10.setColumns(3);
panel_3.add(textField_10);

textField_11 = new JTextField();
textField_11.setBackground(Color.LIGHT_GRAY);
textField_11.setEditable(false);
textField_11.setColumns(3);
panel_3.add(textField_11);

JPanel panel_4 = new JPanel();
panel_4.setBackground(Color.LIGHT_GRAY);
FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
flowLayout_1.setAlignment(FlowLayout.LEFT);
panel_4.setBounds(12, 183, 416, 27);
contentPane.add(panel_4);

JTextPane txtpnSena = new JTextPane();
txtpnSena.setBackground(Color.LIGHT_GRAY);
txtpnSena.setText("Sena:");
panel_4.add(txtpnSena);

textField_12 = new JTextField();
textField_12.setEditable(false);
textField_12.setColumns(3);
textField_12.setBackground(Color.LIGHT_GRAY);
panel_4.add(textField_12);

JPanel panel_5 = new JPanel();
panel_5.setBackground(Color.LIGHT_GRAY);
FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
flowLayout_2.setAlignment(FlowLayout.LEFT);
panel_5.setBounds(12, 222, 416, 27);
contentPane.add(panel_5);

JTextPane txtpnQuina = new JTextPane();
txtpnQuina.setBackground(Color.LIGHT_GRAY);
txtpnQuina.setText("Quina:");
panel_5.add(txtpnQuina);

textField_13 = new JTextField();
textField_13.setEditable(false);
textField_13.setColumns(3);
textField_13.setBackground(Color.LIGHT_GRAY);
panel_5.add(textField_13);

panel_6 = new JPanel();
panel_6.setBackground(Color.LIGHT_GRAY);
FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
flowLayout_3.setAlignment(FlowLayout.LEFT);
panel_6.setBounds(12, 261, 416, 27);
contentPane.add(panel_6);

txtpnQuadra = new JTextPane();
txtpnQuadra.setBackground(Color.LIGHT_GRAY);
txtpnQuadra.setText("Quadra:");
panel_6.add(txtpnQuadra);

textField_14 = new JTextField();
textField_14.setEditable(false);
textField_14.setColumns(3);
textField_14.setBackground(Color.LIGHT_GRAY);
panel_6.add(textField_14);

panel_7 = new JPanel();
panel_7.setBackground(Color.LIGHT_GRAY);
panel_7.setBounds(12, 143, 426, 28);
contentPane.add(panel_7);

txtpnGanhadores = new JTextPane();
txtpnGanhadores.setBackground(Color.LIGHT_GRAY);
txtpnGanhadores.setText("GANHADORES:");
panel_7.add(txtpnGanhadores);
}
public void cadastrar(){
try{
    String a = textField.getText();
    String b = textField_1.getText();
    String c = textField_2.getText();
    String d = textField_3.getText();
    String e = textField_4.getText();
    String f = textField_5.getText();


    int[] vetor = new int[6];

    vetor[0] = Integer.parseInt(a);
    vetor[1] = Integer.parseInt(b);
    vetor[2] = Integer.parseInt(c);
    vetor[3] = Integer.parseInt(d);
    vetor[4] = Integer.parseInt(e);
    vetor[5] = Integer.parseInt(f);

    for (int i = 0; i < 6; i++){
        System.out.println(vetor[i]);
    }

    if (verifica(vetor) && verifica2(vetor)){
        volantes.add(new Jogo(vetor));
    }else {
        JOptionPane.showMessageDialog(null,"Jogo Inválido");
        for (int i = 0; i < 6; i++){
            vetor[i] = 0;
        }
    }
} catch (Exception e){
	JOptionPane.showMessageDialog(null,"Jogo Inválido");
}

}

public boolean verifica(int[] vetor){

for (int j = 0; j < 6; j++){
    for (int i = 0; i < 6; i++) {
        if (vetor[j] == vetor[i] && j != i) {
            System.out.println("erro de igual");
            return false;
        }

    }
}
return true;
}

public boolean verifica2(int[] vetor){
for (int i = 0; i < 6; i++) {
    if (vetor[i] == 0 || vetor[i] > 60){
        System.out.println("erro aqui");
        return false;
    }
}
return true;
}

public int[] sortear(){
int[] dezenasPremi = new int[6];

Random gerador = new Random();
for (int i = 0; i < 6; i++){
    dezenasPremi[i] = (gerador.nextInt(59)+1);
    for (int j = 0; j < i; j++) {
        if (dezenasPremi[i] == dezenasPremi[j]){
            i--;
        }
    }
}

//int[] dezenasPremi = {1,2,3,4,5,6};


textField_6.setText(String.valueOf(dezenasPremi[0]));
textField_7.setText(String.valueOf(dezenasPremi[1]));
textField_8.setText(String.valueOf(dezenasPremi[2]));
textField_9.setText(String.valueOf(dezenasPremi[3]));
textField_10.setText(String.valueOf(dezenasPremi[4]));
textField_11.setText(String.valueOf(dezenasPremi[5]));
return dezenasPremi;
}

public void verificarGanha(ArrayList<Jogo>  jogo, int[] sorteadas){
int acertos = 0;

for (int i = 0; i < jogo.size();i++){

    for (int j = 0; j < sorteadas.length; j++) {

        for ( int a = 0; a < sorteadas.length; a++) {

            if (jogo.get(i).getDezenas()[j] == sorteadas[a]) {
                acertos++;
            }

        }
    }
    ganhadores.add(acertos);
    acertos = 0;
}
for (int i = 0; i < ganhadores.size(); i++) {
    if (ganhadores.get(i) == 6){
        jogo6.add(jogo.get(i));
        this.sena++;
    }
    if (ganhadores.get(i) == 5){
        jogo5.add(jogo.get(i));
        this.quina++;
    }
    if (ganhadores.get(i) == 4){
        jogo4.add(jogo.get(i));
        this.quadra++;
    }
}
textField_12.setText(String.valueOf(this.sena));
textField_13.setText(String.valueOf(this.quina));
textField_14.setText(String.valueOf(this.quadra));
}
public void resuntados(ArrayList<Jogo> jogo6, ArrayList<Jogo> jogo5, ArrayList<Jogo> jogo4){
if (!jogo6.isEmpty() ){
    System.out.println("Ganhadores na Sena: " + jogo6.size());
    for (int i = 0; i < jogo6.size(); i++){
        for (int j = 0; j < 6; j++) {
            System.out.print(jogo6.get(i).getDezenas()[j] + " ");
        }
        System.out.println(" ");
    }
    if (!jogo5.isEmpty() ){
        System.out.println("Ganhadores na Quina: " + jogo5.size());
        for (int i = 0; i < jogo5.size(); i++){
            for (int j = 0; j < 6; j++) {
                System.out.print(jogo5.get(i).getDezenas()[j] + " ");
            }
            System.out.println(" ");
        }
        if (!jogo4.isEmpty() ) {
            System.out.println("Ganhadores na Quadra: " + jogo4.size());
            for (int i = 0; i < jogo4.size(); i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(jogo4.get(i).getDezenas()[j] + " ");
                }
                System.out.println(" ");
            }
        }
    }
} else if (!jogo5.isEmpty() ){
    System.out.println("Ganhadores na Quina: " + jogo5.size());
    for (int i = 0; i < jogo5.size(); i++){
        for (int j = 0; j < 6; j++) {
            System.out.print(jogo5.get(i).getDezenas()[j] + " ");
        }
        System.out.println(" ");
    }
    if (!jogo4.isEmpty() ) {
        System.out.println("Ganhadores na Quadra: " + jogo4.size());
        for (int i = 0; i < jogo4.size(); i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(jogo4.get(i).getDezenas()[j] + " ");
            }
            System.out.println(" ");
        }
    }
} else if (!jogo4.isEmpty() ) {
    System.out.println("Ganhadores na Quadra: " + jogo4.size());
    for (int i = 0; i < jogo4.size(); i++) {
        for (int j = 0; j < 6; j++) {
            System.out.print(jogo4.get(i).getDezenas()[j] + " ");
        }
        System.out.println(" ");
    }
}else {
    System.out.println("NÂO HA GANHADORES!!");
}
}
public void resetValues(){
volantes.clear();
jogo4.clear();
jogo5.clear();
jogo6.clear();
ganhadores.clear();
this.sena = 0;
this.quina = 0;
this.quadra = 0;
}



}