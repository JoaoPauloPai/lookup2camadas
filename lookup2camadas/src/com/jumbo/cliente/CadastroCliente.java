/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroCliente.java
 *
 * Created on 12/12/2012, 11:56:44
 */
package com.jumbo.cliente;

import com.jumbo.java.ClienteVO;
import java.awt.Dimension;
import java.text.ParseException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.lookup.client.LookupListener;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.message.receive.java.ValueObject;

/**
 *
 * @author T2Ti
 */
public class CadastroCliente extends InternalFrame {


    LookupController situacaoClienteController;
    LookupSituacaoClienteDataLocator situacaoClienteDataLocator;

    LookupController cepController;
    LookupCepDataLocator cepDatalocator;

    CepGridController cepGridController;

    LookupController paisController;
    LookupPaisDataLocator paisDataLocator;


    /** Creates new form CadastroCliente */
    public CadastroCliente(CadastroClienteController controller) {
        initComponents();

        gridControl1.setController(controller);
        gridControl1.setGridDataLocator(controller);

        situacaoClienteController = new LookupController();
        situacaoClienteDataLocator = new LookupSituacaoClienteDataLocator();
        situacaoClienteController.setLookupValueObjectClassName("com.jumbo.java.SituacaoClienteVO");
        situacaoClienteController.addLookup2ParentLink("id", "situacaoCliente.id");
        situacaoClienteController.addLookup2ParentLink("descricao", "situacaoCliente.descricao");
        situacaoClienteController.setHeaderColumnName("id", "Código");
        situacaoClienteController.setHeaderColumnName("descricao", "Descrição");
        situacaoClienteController.setAllColumnVisible(true);
        situacaoClienteController.setVisibleStatusPanel(true);
        situacaoClienteController.setFramePreferedSize(new Dimension(400, 500));
        situacaoClienteController.setFrameTitle("Importar Situação Cliente");
        codLookupColumn1.setLookupController(situacaoClienteController);
        situacaoClienteController.setLookupDataLocator(situacaoClienteDataLocator);
        situacaoClienteController.setSortableColumn("descricao", true);
        situacaoClienteController.setFilterableColumn("descricao", true);
        situacaoClienteController.setGridFilterButton(true);


        cepController = new LookupController();
        cepDatalocator = new LookupCepDataLocator();
        cepController.setLookupValueObjectClassName("com.jumbo.java.CepVO");
        cepController.addLookup2ParentLink("cep", "cep");
        cepController.addLookup2ParentLink("bairro", "bairro");
        cepController.addLookup2ParentLink("uf", "uf");
        cepController.setHeaderColumnName("cep", "CEP");
        cepController.setHeaderColumnName("bairro", "Bairro");
        cepController.setHeaderColumnName("uf", "UF");
        cepController.setVisibleColumn("uf", true);
        cepController.setVisibleColumn("bairro", true);
        cepController.setVisibleColumn("cep", true);
        cepController.setFramePreferedSize(new Dimension(400,500));
        cepController.setFrameTitle("Importar CEP");
        codLookupColumn2.setLookupController(cepController);
        cepController.setLookupDataLocator(cepDatalocator);
        cepController.setAllColumnPreferredWidth(100);
        try {
            MaskFormatter formatter = new MaskFormatter("##.###-###");
            formatter.setValueContainsLiteralCharacters(false);
            cepController.setFormattedTextColumn("cep", formatter);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        cepGridController = new CepGridController();
        cepController.setLookupGridController(cepGridController);
        cepController.setGridInsertButton(true);
        cepController.setGridEditButton(true);
        cepController.setGridDeleteButton(true);
        cepController.setColumnEditableOnInsert("cep", true);
        cepController.setColumnEditableOnInsert("bairro", true);
        cepController.setColumnEditableOnInsert("uf", true);
        cepController.setColumnEditableOnEdit("cep", true);
        cepController.setColumnEditableOnEdit("bairro", true);
        cepController.setColumnEditableOnEdit("uf", true);
        cepController.setColumnRequired("siglaPais", false);
        cepController.setColumnRequired("id", false);

        paisController = new LookupController();
        paisDataLocator = new LookupPaisDataLocator();
        paisController.setLookupValueObjectClassName("com.jumbo.java.PaisVO");
        paisController.addLookup2ParentLink("sigla", "siglaPais");
        paisController.setHeaderColumnName("nome", "Nome Pais");
        paisController.setHeaderColumnName("sigla", "Sigla");
        paisController.setAllColumnVisible(true);
        paisController.setFramePreferedSize(new Dimension(400,500));
        paisController.setFrameTitle("Importa País");
        codLookupColumn3.setLookupController(paisController);
        paisController.setLookupDataLocator(paisDataLocator);

        paisController.addLookupListener(new LookupListener() {

            public void beforeLookupAction(ValueObject parentVO) {

            }

            public void codeChanged(ValueObject parentVO, Collection parentChangedAttributes) {
                ClienteVO cliente = (ClienteVO) parentVO;
                cliente.setBairro("");
                cliente.setCep("");
                cliente.setUf("");

                cepDatalocator.getLookupFrameParams().put("siglaPais", cliente.getSiglaPais());
                cepDatalocator.getLookupValidationParameters().put("siglaPais", cliente.getSiglaPais());
            }

            public void codeValidated(boolean validated) {

            }

            public void forceValidate() {

            }
        });

 

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        editButton1 = new org.openswing.swing.client.EditButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        saveButton1 = new org.openswing.swing.client.SaveButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        gridControl1 = new org.openswing.swing.client.GridControl();
        codLookupColumn1 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn1 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn2 = new org.openswing.swing.table.columns.client.TextColumn();
        codLookupColumn2 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn3 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        codLookupColumn3 = new org.openswing.swing.table.columns.client.CodLookupColumn();

        setTitle("Cadastro de Cliente");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(insertButton1);
        jPanel1.add(editButton1);
        jPanel1.add(deleteButton1);
        jPanel1.add(saveButton1);
        jPanel1.add(reloadButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        gridControl1.setDeleteButton(deleteButton1);
        gridControl1.setEditButton(editButton1);
        gridControl1.setInsertButton(insertButton1);
        gridControl1.setReloadButton(reloadButton1);
        gridControl1.setSaveButton(saveButton1);
        gridControl1.setValueObjectClassName("com.jumbo.java.ClienteVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupColumn1.setColumnName("situacaoCliente.descricao");
        codLookupColumn1.setEditableOnEdit(true);
        codLookupColumn1.setEditableOnInsert(true);
        codLookupColumn1.setHeaderColumnName("Situação Cliente");
        codLookupColumn1.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codLookupColumn1.setPreferredWidth(150);
        gridControl1.getColumnContainer().add(codLookupColumn1);

        textColumn1.setColumnName("nome");
        textColumn1.setEditableOnEdit(true);
        textColumn1.setEditableOnInsert(true);
        textColumn1.setHeaderColumnName("Nome");
        textColumn1.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn1.setPreferredWidth(200);
        gridControl1.getColumnContainer().add(textColumn1);

        textColumn2.setColumnName("endereco");
        textColumn2.setEditableOnEdit(true);
        textColumn2.setEditableOnInsert(true);
        textColumn2.setHeaderColumnName("Endereço");
        textColumn2.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn2.setPreferredWidth(200);
        gridControl1.getColumnContainer().add(textColumn2);

        codLookupColumn2.setColumnName("cep");
        codLookupColumn2.setEditableOnEdit(true);
        codLookupColumn2.setEditableOnInsert(true);
        codLookupColumn2.setHeaderColumnName("CEP");
        codLookupColumn2.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(codLookupColumn2);

        textColumn3.setColumnName("bairro");
        textColumn3.setHeaderColumnName("Bairro");
        textColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(textColumn3);

        textColumn4.setColumnName("uf");
        textColumn4.setHeaderColumnName("UF");
        textColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn4.setPreferredWidth(50);
        gridControl1.getColumnContainer().add(textColumn4);

        codLookupColumn3.setColumnName("siglaPais");
        codLookupColumn3.setEditableOnEdit(true);
        codLookupColumn3.setEditableOnInsert(true);
        codLookupColumn3.setHeaderColumnName("País");
        codLookupColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(codLookupColumn3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControl1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn1;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn2;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn3;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.InsertButton insertButton1;
    private javax.swing.JPanel jPanel1;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.table.columns.client.TextColumn textColumn3;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    // End of variables declaration//GEN-END:variables
}
