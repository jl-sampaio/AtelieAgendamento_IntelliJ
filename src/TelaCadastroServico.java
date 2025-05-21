import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaCadastroServico extends JFrame {
    private JTextField campoNome;
    private JTextField campoPreco;
    private JTextField campoDuracao;
    private JButton botaoSalvar;
    private ArrayList<Servico> listaServicos;

    public TelaCadastroServico(ArrayList<Servico> listaServicos) {
        this.listaServicos = listaServicos;

        setTitle("Cadastro de Serviço");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nome do Serviço:"));
        campoNome = new JTextField();
        add(campoNome);

        add(new JLabel("Preço (R$):"));
        campoPreco = new JTextField();
        add(campoPreco);

        add(new JLabel("Duração (min):"));
        campoDuracao = new JTextField();
        add(campoDuracao);

        botaoSalvar = new JButton("Salvar");
        add(botaoSalvar);

        botaoSalvar.addActionListener(e -> {
            try {
                String nome = campoNome.getText();
                double preco = Double.parseDouble(campoPreco.getText());
                int duracao = Integer.parseInt(campoDuracao.getText());

                Servico servico = new Servico(nome, preco, duracao);
                listaServicos.add(servico);
                JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos.");
            }
        });

        setVisible(true);
    }
}