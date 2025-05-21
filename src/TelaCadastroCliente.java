import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaCadastroCliente extends JFrame {
    private JTextField campoNome;
    private JTextField campoTelefone;
    private JTextField campoEmail;
    private JButton botaoSalvar;
    private ArrayList<Cliente> listaClientes;

    public TelaCadastroCliente(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;

        setTitle("Cadastro de Cliente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nome:"));
        campoNome = new JTextField();
        add(campoNome);

        add(new JLabel("Telefone:"));
        campoTelefone = new JTextField();
        add(campoTelefone);

        add(new JLabel("Email:"));
        campoEmail = new JTextField();
        add(campoEmail);

        botaoSalvar = new JButton("Salvar");
        add(botaoSalvar);

        botaoSalvar.addActionListener(e -> {
            String nome = campoNome.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();

            Cliente cliente = new Cliente(nome, telefone, email);
            listaClientes.add(cliente);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            dispose();
        });

        setVisible(true);
    }
}