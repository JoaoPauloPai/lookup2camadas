/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jumbo.cliente;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.JTree;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.openswing.swing.lookup.client.LookupDataLocator;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author Jo�o Paulo
 */
public class LookupCepDataLocator extends LookupDataLocator{

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType) {
        Session session = null;

        String siglaPais = (String) getLookupFrameParams().get("siglaPais");

        String baseSQL = "select CEP from com.jumbo.java.CepVO as CEP where CEP.siglaPais = '" + siglaPais + "'";

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Response res = HibernateUtils.getBlockFromQuery(
                    action,
                    startIndex,
                    50, // block size...
                    filteredColumns,
                    currentSortedColumns,
                    currentSortedVersusColumns,
                    com.t2ti.java.CepVO.class,
                    baseSQL,
                    new Object[0],
                    new Type[0],
                    "CEP",
                    HibernateUtil.getSessionFactory(),
                    session);
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }

    @Override
    public Response validateCode(String code) {
        Session session = null;

        String siglaPais = (String) getLookupValidationParameters().get("siglaPais");

        String baseSQL = "select CEP from com.t2ti.java.CepVO as CEP where CEP.cep = " + code + " and CEP.siglaPais = '" + siglaPais + "'";

        try {
            GridParams pars = new GridParams();
            session = HibernateUtil.getSessionFactory().openSession();
            Response res = HibernateUtils.getBlockFromQuery(
                    pars.getAction(),
                    pars.getStartPos(),
                    50, // block size...
                    pars.getFilteredColumns(),
                    pars.getCurrentSortedColumns(),
                    pars.getCurrentSortedVersusColumns(),
                    com.t2ti.java.CepVO.class,
                    baseSQL,
                    new Object[0],
                    new Type[0],
                    "CEP",
                    HibernateUtil.getSessionFactory(),
                    session);
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }

    @Override
    public Response getTreeModel(JTree tree) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}