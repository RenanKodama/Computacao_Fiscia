package Controller;

import DAOs.DAOGenerico;
import DAOs.DAOSensor;
import DAOs.DAOUsuario;
import DAOs.DB_Direct;
import Model.Sensor;
import Model.Usuario;
import View.FrmBatimentos;
import View.FrmCadastro;
import View.FrmPrincipal;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marcelo
 */
public class PrincipalController {

    DB_Direct db = new DB_Direct("src/DAOs/local.txt");

    DAOUsuario daoUsuario = new DAOUsuario();

    public PrincipalController() {

    }

    public void PrencheComboBox(FrmPrincipal tela) {

        JComboBox box = tela.getCbUsuario();
        box.removeAllItems();
        List<Usuario> us = daoUsuario.list();
        for (Usuario usuario : us) {
            box.addItem(usuario);
            System.out.println(usuario.getNomeUsuario());
        }

        tela.setCbUsuario(box);

    }

    public void PrencheTela(FrmPrincipal tela) {
        Usuario u = (Usuario) tela.getCbUsuario().getSelectedItem();
        JLabel nome = tela.getLblNome();
        JLabel idade = tela.getLblIdade();
        JLabel peso = tela.getLblPeso();
        if (u != null) {
            nome.setText(u.getNomeUsuario());
            idade.setText(u.getIdade().toString());
            peso.setText(u.getPeso().toString());

            tela.setLblNome(nome);
            tela.setLblIdade(idade);
            tela.setLblPeso(peso);
        }

    }

    public void AbriTelaCadastro() {
        FrmCadastro cadastro = new FrmCadastro(this);
        cadastro.setVisible(true);
    }
    
    public void AbrirTelaBatimentos(){
        FrmBatimentos batimentos = new FrmBatimentos(this);
        batimentos.setVisible(true);
        
    }
    
    public void PeencheTelaBatimentos(FrmBatimentos batimentos){
        String dadosFromArduino = batimentos.getAcessaArduino().getDadosArduino().trim();
        JLabel b = batimentos.getLblBatimentos();
        b.setText(dadosFromArduino);
        batimentos.setLblBatimentos(b);
    }

    public void SalvarUsuario(FrmCadastro tela) {
        String nome = tela.getTxtNome().getText();
        Integer idade = Integer.parseInt(tela.getTxtIdade().getText());
        Double peso = Double.parseDouble(tela.getTxtPeso().getText());
        System.out.println(peso);
        double a = 0.0;
        if (nome.equals("") && idade.equals(0) && peso.equals(a)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!! ");
            
        } else {
            Usuario usuario = new Usuario(nome, peso.floatValue(), idade);

            daoUsuario.inserir(usuario);
            tela.dispose();

        }

    }

    public void RemoverUsuario(FrmPrincipal tela) {
        Usuario u = (Usuario ) tela.getCbUsuario().getSelectedItem();
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este usuario ? \n"+ u.getNomeUsuario().toUpperCase(), "REMOVER", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            
            daoUsuario.remover(u);
            
           JOptionPane.showMessageDialog(null, "Usuario  " + u.getNomeUsuario().toUpperCase()+"  Removido");
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Usuario nao removido");
        }
    }

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
    // TODO code application logic here
    //new GUI1();
    /*
        DB_Direct db = new DB_Direct("src/DAOs/local.txt");
   
        
        DAOSensor d = new DAOSensor();
        List<Sensor> se = d.lista();
        for(Sensor s: se){
            System.out.println(s.getNomeSensor());
        }
        
        System.out.println(db.getStatusDaConexao());
     */
    //}
}
