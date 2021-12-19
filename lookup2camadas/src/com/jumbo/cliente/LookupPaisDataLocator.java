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
 * @author João Paulo
 */
public class LookupPaisDataLocator extends LookupDataLocator{

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType) {
        Session session = null;

        String baseSQL = "select PAIS from com.jumbo.java.PaisVO as PAIS";

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Response res = HibernateUtils.getBlockFromQuery(
                    action,
                    startIndex,
                    50, // block size...
                    filteredColumns,
                    currentSortedColumns,
                    currentSortedVersusColumns,
                    com.t2ti.java.PaisVO.class,
                    baseSQL,
                    new Object[0],
                    new Type[0],
                    "PAIS",
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

        String baseSQL = "select PAIS from com.jumbo.java.PaisVO as PAIS where PAIS.id = " + code;

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
                    com.t2ti.java.PaisVO.class,
                    baseSQL,
                    new Object[0],
                    new Type[0],
                    "PAIS",
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
