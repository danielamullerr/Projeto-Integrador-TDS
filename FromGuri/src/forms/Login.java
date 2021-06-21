package forms;

import api.Api;
import domain.Cadastro;
import mappers.CadastroMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.*;

public class Login extends JFrame{
    private JPanel rootContainer;
    private JTextField textFieldLoguin;
    private JPasswordField passwordField;
    private JButton loguinButton;

    private JPanel loguinContainer;
    private JButton cadastroButton;
    private Connection connection;
    private Api api;

    public Login(Api api)  {
        this.api = api;

        initForm();
        pack();


        Component self = this;
        loguinButton.addActionListener(new ActionListener() {//bd
            @Override
            public void actionPerformed(ActionEvent e) {//
                String loguinUsuario = textFieldLoguin.getText();
                String senhaUsuario= passwordField.getText();

                try {
                    api.logar(loguinUsuario, senhaUsuario);

                    setVisible(false);
                    MarketPlace marketPlace = new MarketPlace(api);

                    marketPlace.setVisible(true);


                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(self, exception.getMessage(), "Login", JOptionPane.ERROR_MESSAGE);
                }




            }
        });

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CadastroUsuario cadastroUsuario = new CadastroUsuario(api);
                cadastroUsuario.setVisible(true);


            }
        });
    }

    private void initForm() {
        setTitle("From Guri");
        setContentPane(rootContainer);
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
