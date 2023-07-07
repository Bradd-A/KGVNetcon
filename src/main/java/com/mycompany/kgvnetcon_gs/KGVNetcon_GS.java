/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kgvnetcon_gs;
import javax.swing.SwingUtilities;
import views.menuView;

/**
 *
 * @author arteaga
 */
public class KGVNetcon_GS {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SwingUtilities.invokeLater(() -> {
            menuView mev = new menuView();
            mev.setLocationRelativeTo(null);
            mev.setVisible(true);
        });
    }
}
