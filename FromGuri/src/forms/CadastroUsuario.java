package forms;

import api.Api;
import domain.Cadastro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class CadastroUsuario extends JFrame{
    private JPanel cadastroContainer;
    private JTextField textFieldNome;
    private JTextField textFieldCpf;
    private JTextField textFieldNascimento;
    private JTextField textFieldEmail;
    private JTextField textFieldSenha;
    private JTextField textFieldRua;
    private JTextField textFieldNumero;
    private JTextField textFieldCidade;
    private JButton cancelarButton;
    private JButton salvarButton;
    private JTextField textFieldUf;

    private Api api;

    public  CadastroUsuario(Api api){
        this.api = api;

        initForm();
        showMe();

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome=textFieldNome.getText();
                String cpf=textFieldCpf.getText();
                String datanasc=textFieldNascimento.getText();
                String email=textFieldEmail.getText();
                String senha=textFieldSenha.getText();
                String rua=textFieldRua.getText();
                String numero=textFieldNumero.getText();
                String cidade=textFieldCidade.getText();
                String uf = textFieldUf.getText();

                try {
                    Cadastro cadastro = new Cadastro();
                    cadastro.setNome(nome);
                    cadastro.setNome(cpf);
                    cadastro.setNome(datanasc);
                    cadastro.setNome(senha);
                    cadastro.setNome(email);
                    cadastro.setNome(rua);
                    cadastro.setNome(numero);
                    cadastro.setNome(cidade);
                    cadastro.setNome(uf);

                    api.novoUsuario(cadastro);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                setVisible(false);
                MarketPlace marketPlace = new MarketPlace(api);
                marketPlace.setVisible(true);


            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login login = new Login(api);
                login.setVisible(true);

            }
        });

    }



    private void initForm() {
        setTitle("From Guri");
        setContentPane(cadastroContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
    public void showMe() {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                pack();
                setVisible( true);
            }
        });
    }
}
